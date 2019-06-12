package cn.swu.edu.javaweb.shoppingcart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessStep1Servlet
 */
public class ProcessStep1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取选中的图书的信息
		String [] books = request.getParameterValues("book");
		//2.将获取的图书信息放入到session中
		request.getSession().setAttribute("books", books);
		//3.重定向到step-2.jsp
		response.sendRedirect(request.getContextPath() + "/webpages/shoppingcart/step-2.jsp");
	}

}
