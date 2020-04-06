package cn.swu.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/redirectServlet")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("RedrectServlet's doGet");
		
		request.setAttribute("name", "ghjk");
		System.out.println("RedirectServlet's name:" + request.getAttribute("name"));
		PrintWriter out = response.getWriter();
		out.println("<br>");
		out.println("RedirectServlet's doGet");
		out.println("<br>");
		String location = "testServlet";
		response.sendRedirect(location);
	}

}
