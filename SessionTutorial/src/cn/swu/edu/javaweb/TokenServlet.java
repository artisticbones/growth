package cn.swu.edu.javaweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TokenServlet
 */
@WebServlet("/tokenServlet")
public class TokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		
		Object token = session.getAttribute("token");
		String tokenValue = request.getParameter("tokenValue");
		System.out.println(token);
		System.out.println(tokenValue);
		
		if(token != null && token.equals(tokenValue)) {
			session.removeAttribute("token");
		}else {
			response.sendRedirect(request.getContextPath() + "/token/token.jsp");
			return;
		}
		
		String name = request.getParameter("name");
		
		System.out.println("name: " + name);
		
		response.sendRedirect(request.getContextPath() + "/token/success.jsp");
	}

}
