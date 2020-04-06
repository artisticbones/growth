package cn.swu.edu.javaweb.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.swu.edu.javaweb.dao.UserDao;
import cn.swu.edu.javaweb.pojo.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String methodName = request.getParameter("method");
		
		try {
			Method method = getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private UserDao userDao = new UserDao();
	
	public void login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.获取name
		String username = request.getParameter("username");
		//2.调用UserDAO获取用户信息，把用户信息放入到session中
		User user = userDao.get(username);
		request.getSession().setAttribute("user", user);
		//3.重定向到articles.jsp
		response.sendRedirect(request.getContextPath() + "/permission/articles.jsp");
		System.out.println(request.getContextPath() + "/permission/articles.jsp");
	}
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 获取 HttpSession
		
		//2. 使 HttpSession 失效
		request.getSession().invalidate();
		
		//3. 重定向到 /loign.jsp
		response.sendRedirect(request.getContextPath() + "/permission/login.jsp");
	}
}
