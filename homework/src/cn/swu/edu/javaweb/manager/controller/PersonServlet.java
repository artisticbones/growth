package cn.swu.edu.javaweb.manager.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.swu.edu.javaweb.manager.dao.PersonDAO;
import cn.swu.edu.javaweb.manager.factory.PersonDAOFactory;
//import cn.swu.edu.javaweb.manager.pojo.CriteriaPerson;
import cn.swu.edu.javaweb.manager.pojo.Person;


/**
 * Servlet implementation class CustomerServlet
 */
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonDAO personDAO = PersonDAOFactory.getInstance().getPersonDAO();
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
		methodName = methodName.substring(0,methodName.length()-3);
		
		//System.out.println(methodName);
		try {
			Method method = getClass().getDeclaredMethod(methodName ,HttpServletRequest.class , HttpServletResponse.class);
			//3.利用反射获取方法
			method.invoke(this, req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			resp.sendRedirect(req.getContextPath() + "/404.jsp");
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();	
//		out.println("edit");
//		System.out.println("edit");
		//1.获取id
		String forwardPath = "/404.jsp";
		
		String idStr = request.getParameter("id");
		
		System.out.println(idStr);
		
		//2.调用customerDAO的customerDAO.getid方法获取信息和id对应的对象；
		try {
			Person person = personDAO.get(Integer.parseInt(idStr));
			if (person != null) {
				forwardPath = "/person/updatecustomer.jsp";
				request.setAttribute("person", person);
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
		String position = request.getParameter("position");
		String office = request.getParameter("office");
		String age = request.getParameter("age");
		String sDate = request.getParameter("sDate");
		String salary = request.getParameter("salary");
		String oldName = request.getParameter("oldName");
		//2.检验name是否被占用:
		//2.1比较name和oldname是否相同，相同说明namekeyong
		if(!(oldName.equalsIgnoreCase(name))) {
			long count = personDAO.getCountWithName(name);
			//若返回值大于0，则响应updatecustomer.jsp页面,使用转发方式
			System.out.println(count);
			if(count > 0) {
				//在该页面显示提示错误消息
				String message = "user " + name + "already exists!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/person/updatecustomer.jsp").forward(request, response);
			}
		}
		Person person = new Person();
		person.setId(Integer.parseInt(id));
		person.setName(name);
		person.setPosition(position);
		person.setAge(age);
		person.setOffice(office);
		person.setsDate(sDate);
		person.setSalary(salary);
			
		personDAO.update(person);
		response.sendRedirect(request.getContextPath() + "/person/success.jsp");
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
			personDAO.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.sendRedirect(request.getContextPath() + "/query.do");
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();	
//		out.println("query");
//		System.out.println("query");
		//1.调用CustomerDAO的getAll()得到Customer集合
//		String name = request.getParameter("name");
//		
//		String position = request.getParameter("position");
//		
//		String office = request.getParameter("office");
//		String age = request.getParameter("age");
//		String sDate = request.getParameter("sDate");
//		String salary = request.getParameter("salary");
//		
//		//Person ps = new Person(id, name, address, office, age, date, salary);
//		//CriteriaPerson cc = new CriteriaPerson(name, position, office, age, sDate, salary);
//		//List<Person> person = personDAO.getForListWithCriteriaCustomer(cc);
		List<Person> person = personDAO.getAll();
		System.out.println("person-->" + person);
		
		//2.把customer的集合放入到request中
		request.setAttribute("person", person);
		System.out.println("person被放入request域对象中!");
		//3.转发页面到index.jsp
		System.out.println(request.getContextPath() + "/person/index.jsp");
		request.getRequestDispatcher("/person/MAIN.jsp").forward(request, response);
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();	
//		out.println("addCustomer");
//		System.out.println("addCustomer");
		//1.根据表单获取参数：name,address,phone
		Person person = new Person();
		String name = request.getParameter("name");
		String position = request.getParameter("position");
		String office = request.getParameter("office");
		String age = request.getParameter("age");
		String sDate = request.getParameter("sDate");
		String salary = request.getParameter("salary");
		
		//2.判断name是否存在
		/**
		 * 2.1调用getCountWithName(String name)获取name是否在数据库中
		 * 2.2 count>0证明有，响应newcustomer.jsp页面，使用转发的方式响应,因需要保留之前填写的数值
		 * 可以显示一个错误消息：name 被占用
		 * 使用value="<%= request.getParameter("name") == null ? "" : request.getParameter("name")%>"来回显
		 */
		if (personDAO.getCountWithName(name) > 0) {
			String message = "user " + name + " already exits,please choose another one!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/person/newcustomer.jsp").forward(request, response);
			
		}else {//验证通过把参数封装进Customer对象customer中
			person.setName(name);
			person.setPosition(position);;
			person.setAge(age);
			person.setOffice(office);
			person.setsDate(sDate);
			person.setSalary(salary);
		}
		
		
		
		
		//调用CustomerDAO的save()方法执行保存
		personDAO.save(person);
		response.sendRedirect(request.getContextPath() + "/person/success.jsp");
		
	}

}
