package cn.swu.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetPasswordServlet
 */
@WebServlet("/setPassword")
public class SetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取新密码和旧密码和id
		UserDAO userDAO = new UserDAO();
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String again = request.getParameter("again");
		LoginUsers user = (LoginUsers)request.getSession().getAttribute("user");
		//2.检查新旧密码是否一致,并检查两次的密码是否一致：
		if(!(oldPassword.equals(newPassword))) {
			if(newPassword.equals(again)) {
				//若一致，则调用update方法
				user.setPassword(newPassword);
				userDAO.update(user);
				//3.成功后，重定向到成功定时返回到login的success.jsp
				response.sendRedirect(request.getContextPath() + "/success.jsp");
			}else {
				//否则，告知用户和旧密码相同
				request.getSession().setAttribute("message", "两次密码不一致，请重新输入！");
				request.getRequestDispatcher("/setpassword.jsp").forward(request, response);
				return;
			}
		}else {
			request.getSession().setAttribute("message", "和旧密码一致，请重新更换密码！");
			response.sendRedirect(request.getContextPath() + "/setpassword.jsp");
			return;
		}
		
	}

}
