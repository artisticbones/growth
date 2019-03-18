package cn.swu.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet2 extends MyHttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String method = request.getMethod();
		System.out.println(method);
		String inituser = getServletContext().getInitParameter("user");
		String initpassword = getServletContext().getInitParameter("password");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		if(inituser.equals(username) && initpassword.equals(password)) {
			out.print(username + " you have log in nitian.online!");
		}else {
			out.print(username + " login failed!");
		}
	}

}
