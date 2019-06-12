package cn.swu.edu.javaweb.shoppingcart.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.swu.edu.javaweb.shoppingcart.dao.BookDao;
import cn.swu.edu.javaweb.shoppingcart.pojo.Cart;
import cn.swu.edu.javaweb.shoppingcart.service.BookDaoJdbcService;

/**
 * Servlet implementation class CartAddServlet
 */
@WebServlet("/cartAddServlet")
public class CartAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private BookDao bookDao = new BookDaoJdbcService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            String bookid = request.getParameter("bookid");
            // 从session中获取购物车
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            if (cart == null) {
                //用户第一次添加商品时
                cart = new Cart();
                request.getSession().setAttribute("cart", cart);
            }
            bookDao.buyBook(bookid, cart);
            request.getRequestDispatcher("/listCart.jsp").forward(request, response);
            return;
        } catch (Exception e) {
            request.setAttribute("message", "操作失败！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }
	}

}
