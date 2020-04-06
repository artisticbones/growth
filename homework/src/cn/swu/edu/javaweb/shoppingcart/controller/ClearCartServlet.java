package cn.swu.edu.javaweb.shoppingcart.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.swu.edu.javaweb.shoppingcart.dao.BookDao;
import cn.swu.edu.javaweb.shoppingcart.dao.CartNotFoundException;
import cn.swu.edu.javaweb.shoppingcart.pojo.Cart;
import cn.swu.edu.javaweb.shoppingcart.service.BookDaoJdbcService;

/**
 * Servlet implementation class ClearCartServlet
 */
@WebServlet("/clearCartServlet")
public class ClearCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private BookDao bookDao = new BookDaoJdbcService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//得到用户相对应的购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        try {

            //清空购物车【实际上就是清空购物车的Map集合中的元素】
            bookDao.clearCart(cart);

            //返回给购物车显示页面
            request.getRequestDispatcher("/WEB-INF/listCart.jsp").forward(request, response);

        } catch (CartNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("message", "购物车是空的！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
	}

}
