package cn.swu.edu.javaweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCodeServlet
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramCode = request.getParameter("CHECK_CODE_PARAM_NAME");
		String sessionCode = (String)request.getSession().getAttribute("CHECK_CODE_KEY");
		
		System.out.println(paramCode);
		System.out.println(sessionCode);
		
		if(paramCode != null && paramCode.equals(sessionCode)) {
			response.sendRedirect(request.getContextPath() + "/shoppingcart/step-1.jsp");
		}else {
			request.getSession().setAttribute("message", "验证码不一致！");
			response.sendRedirect(request.getContextPath() + "/check/index.jsp");
			return;
		}
		
	}

}
