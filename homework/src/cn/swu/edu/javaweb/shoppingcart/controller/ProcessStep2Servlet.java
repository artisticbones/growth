package cn.swu.edu.javaweb.shoppingcart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.swu.edu.javaweb.shoppingcart.pojo.Customer;

/**
 * Servlet implementation class ProcessStep2Servlet
 */
public class ProcessStep2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.获取请求参数
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String cardType = request.getParameter("cardType");
		String card = request.getParameter("card");
		//2.将请求信息放入session中
		Customer customer = new Customer(name, address, cardType, card);
		request.getSession().setAttribute("customer", customer);
		//3.重定向到页面confirm.jsp
		response.sendRedirect(request.getContextPath() + "/webpages/shoppingcart/confirm.jsp");
	}

}
