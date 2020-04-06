package cn.swu.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet("/forwardServlet")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ForwardServlet's doGet!");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setAttribute("name", "abcd");
		System.out.println("ForwardServlet's name:" + request.getAttribute("name"));
		PrintWriter out = response.getWriter();
		out.println("<br>");
		out.println("ForwardServlet's doGet!");
		out.println("<br>");
		String path = "testServlet";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
	}

}
