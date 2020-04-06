package cn.swu.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet extends MyGenericServlet {

	public void init() throws ServletException {
		System.out.println("初始化");
	}
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
