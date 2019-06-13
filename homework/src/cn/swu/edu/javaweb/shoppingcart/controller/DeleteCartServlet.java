package cn.swu.edu.javaweb.shoppingcart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.swu.edu.javaweb.shoppingcart.dao.BookDao;
import cn.swu.edu.javaweb.shoppingcart.dao.CartNotFoundException;
import cn.swu.edu.javaweb.shoppingcart.pojo.Cart;
import cn.swu.edu.javaweb.shoppingcart.service.BookDaoJdbcService;

/**
 * Servlet implementation class DeleteCartServlet
 */

public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private BookDao bookDao = new BookDaoJdbcService(); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.获取用户想要删除的那个书本的ID
		String id  = request.getParameter("bookid");
		
		//2.获取该用户相对应的购物车对象
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		try {
            //删除购物车的商品，也应该是在BusinessService中有的功能，于是乎又回到BusinessService中写代码
			bookDao.deleteBook(id, cart);

            //删除购物车的商品后，也应该直接跳转回去购物车的显示页面中
            request.getRequestDispatcher("/webpages/shoppingcart/listCart.jsp").forward(request, response);

        } catch (CartNotFoundException e) {
            request.setAttribute("message", "购物车空了！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "删除中出现了异常～待会再试试呗！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
	}

}
