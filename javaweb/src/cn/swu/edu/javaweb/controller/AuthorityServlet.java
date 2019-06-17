package cn.swu.edu.javaweb.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.swu.edu.javaweb.dao.UserDao;
import cn.swu.edu.javaweb.pojo.Authority;
import cn.swu.edu.javaweb.pojo.User;

/**
 * Servlet implementation class AuthorityServlet
 */
@WebServlet("/authorityServlet")
public class AuthorityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
	public void getAuthorities(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String username = request.getParameter("username");
		User user = userDao.get(username);
		
		request.setAttribute("user", user);
		request.setAttribute("authorities", userDao.getAuthorities());
		request.getRequestDispatcher("/permission/authority-manager.jsp").forward(request, response);
	}
	
	public void updateAuthorities(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String [] authorities = request.getParameterValues("authority");
		
		List<Authority> authorityList = userDao.getAuthorities(authorities);
		userDao.update(username,authorityList);
		response.sendRedirect(request.getContextPath() + "/permission/authority-manager.jsp");
	}
}