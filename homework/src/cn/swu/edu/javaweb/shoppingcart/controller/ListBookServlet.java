package cn.swu.edu.javaweb.shoppingcart.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.swu.edu.javaweb.shoppingcart.dao.BookDao;
import cn.swu.edu.javaweb.shoppingcart.pojo.Book;
import cn.swu.edu.javaweb.shoppingcart.service.BookDaoJdbcService;

/**
 * Servlet implementation class ListBookServlet
 */
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private BookDao bookDao = new BookDaoJdbcService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map<String, Book> books = (Map<String, Book>) bookDao.getAll();
		System.out.println("1");
		
		
		//存放到request域对象中，交给jsp显示
		request.setAttribute("books", books);
		
		//进行跳转
		request.getRequestDispatcher(request.getContextPath() + "/webpages/shoppingcart/listBook.jsp").forward(request, response);
	}

}
