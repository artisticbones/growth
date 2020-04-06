package cn.swu.edu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForgetPassServlet
 */
@WebServlet("/forgetPass")
public class ForgetPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取参数username
		String username = request.getParameter("username");
		System.out.println(username);
		//2.根据username查询id号
		UserDAO userDAO = new UserDAO();
		LoginUsers users = userDAO.getCountWithName(username);
		System.out.println(users.getId());
		System.out.println(users.getPassword());
		System.out.println(users.getUsername());
		
		//3.将id号放到session中
		request.getSession().setAttribute("user",users);
		//4.重定向到setpassword.jsp
		response.sendRedirect(request.getContextPath() + "/setpassword.jsp");
	}

}
