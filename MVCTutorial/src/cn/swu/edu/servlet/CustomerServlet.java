package cn.swu.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.swu.edu.CriteriaCustomer;
import cn.swu.edu.CustomerDAO;
import cn.swu.edu.dao.factory.CustomerDAOFactory;
import cn.swu.edu.dao.impl.CustomerDAOJdbcImpl;
import cn.swu.edu.domain.Customer;


/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/customerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerDAO customerDAO = CustomerDAOFactory.getInstance().getCustomerDAO();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		String method = request.getParameter("method");
//		
//		switch(method) {
//			case "add": add(request,response);break;
//			case "query": query(request,response);break;
//			case "delete": delete(request,response);break;
//			case "update": update(request,response);break;
//		}
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.获取servletPath
		String servletPath = req.getServletPath();
		//2.去掉/和.do
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0,methodName.length()-7);
		
		PrintWriter out = resp.getWriter();	
		//System.out.println(methodName);
		try {
			Method method = getClass().getDeclaredMethod(methodName ,HttpServletRequest.class , HttpServletResponse.class);
			//3.利用反射获取方法
			method.invoke(this, req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			resp.sendRedirect("error.jsp");
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();	
//		out.println("edit");
//		System.out.println("edit");
		//1.获取id
		String forwardPath = "/error.jsp";
		
		String idStr = request.getParameter("id");
		
		System.out.println(idStr);
		
		//2.调用customerDAO的customerDAO.getid方法获取信息和id对应的对象；
		try {
			Customer customer = customerDAO.get(Integer.parseInt(idStr));
			if (customer != null) {
				forwardPath = "/updatecustomer.jsp";
				request.setAttribute("customer", customer);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
		}
		//3.将customer放入到request中
		request.getRequestDispatcher(forwardPath).forward(request, response);
		//4.响应updatecustomer.jsp页面:转发
		
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();	
//		out.println("update");
//		System.out.println("update");
		//1.获取表单参数: id,name,address,phone,oldName
		String id = request.getParameter("id");
		System.out.println(id);
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String oldName = request.getParameter("oldName");
		//2.检验name是否被占用:
		//2.1比较name和oldname是否相同，相同说明namekeyong
		if(!(oldName.equalsIgnoreCase(name))) {
			long count = customerDAO.getCountWithName(name);
			//若返回值大于0，则响应updatecustomer.jsp页面,使用转发方式
			System.out.println(count);
			if(count > 0) {
				//在该页面显示提示错误消息
				String message = "user " + name + "already exists!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/updatecustomer.jsp").forward(request, response);
			}
		}
		Customer customer = new Customer();
		customer.setId(Integer.parseInt(id));
		customer.setName(name);
		customer.setAddress(address);
		customer.setPhone(phone);
			
		customerDAO.update(customer);
		System.out.println(customer);
		response.sendRedirect("success2.jsp");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();	
//		out.println("delete");
//		System.out.println("delete");
		String idStr = request.getParameter("id");
		//防止恶意操作
		int id = 0;
		
		try {
			id = Integer.parseUnsignedInt(idStr);
			customerDAO.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.sendRedirect("query.action");
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();	
//		out.println("query");
//		System.out.println("query");
		//1.调用CustomerDAO的getAll()得到Customer集合
		String name = request.getParameter("name");
		
		String address = request.getParameter("address");
		
		String phone = request.getParameter("phone");
		
		CriteriaCustomer cc = new CriteriaCustomer(name, address, phone);
		List<Customer> customer = customerDAO.getForListWithCriteriaCustomer(cc);
		
		//2.把customer的集合放入到request中
		request.setAttribute("customer", customer);
		
		//3.转发页面到index.jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();	
//		out.println("addCustomer");
//		System.out.println("addCustomer");
		//1.根据表单获取参数：name,address,phone
		Customer customer = new Customer();
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		//2.判断name是否存在
		/**
		 * 2.1调用getCountWithName(String name)获取name是否在数据库中
		 * 2.2 count>0证明有，响应newcustomer.jsp页面，使用转发的方式响应,因需要保留之前填写的数值
		 * 可以显示一个错误消息：name 被占用
		 * 使用value="<%= request.getParameter("name") == null ? "" : request.getParameter("name")%>"来回显
		 */
		if (customerDAO.getCountWithName(name) > 0) {
			String message = "user " + name + " already exits,please choose another one!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("newcustomer.jsp").forward(request, response);
			
		}else {//验证通过把参数封装进Customer对象customer中
			customer.setName(name);
			customer.setAddress(address);
			customer.setPhone(phone);
		}
		
		
		
		
		//调用CustomerDAO的save()方法执行保存
		customerDAO.save(customer);
		response.sendRedirect("success2.jsp");
		
	}

}
