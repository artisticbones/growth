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
 * Servlet implementation class UpdateQuantityServlet
 */
@WebServlet("/updateQuantityServlet")
public class UpdateQuantityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private BookDao bookDao = new BookDaoJdbcService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取得到用户想要修改哪一本书的id和相对应的数量
        String id = request.getParameter("bookid");
        String quantity = request.getParameter("quantity");

        //得到当前用户的购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        try {

            //调用BusinessService的方法去修改对应的数据
            
            bookDao.updateQuantity(id, cart, quantity);

            //修改完再跳转回去购物车的页面中
            request.getRequestDispatcher(request.getContextPath() + "/webpages/shoppingcart/listBook.jsp").forward(request, response);

        } catch (CartNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("message", "购物车是空的！");
            request.getRequestDispatcher("message.jsp").forward(request, response);
        }
	}

}
