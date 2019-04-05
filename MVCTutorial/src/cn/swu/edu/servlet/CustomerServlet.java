package cn.swu.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.swu.edu.CustomerDAO;
import cn.swu.edu.dao.impl.CustomerDAOJdbcImpl;
import cn.swu.edu.domain.Customer;


/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/customerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerDAO customerDAO = new CustomerDAOJdbcImpl();
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
		PrintWriter out = response.getWriter();	
		out.println("edit");
		System.out.println("edit");
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();	
		out.println("update");
		System.out.println("update");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();	
		out.println("delete");
		System.out.println("delete");
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();	
//		out.println("query");
//		System.out.println("query");
		//1.调用CustomerDAO的getAll()得到Customer集合
		List<Customer> customer = customerDAO.getAll();
		
		//2.把customer的集合放入到request中
		request.setAttribute("customer", customer);
		
		//3.转发页面到index.jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();	
		out.println("addCustomer");
		System.out.println("addCustomer");
	}

}
