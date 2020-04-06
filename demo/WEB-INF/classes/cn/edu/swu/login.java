package cn.edu.swu;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class login extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		this.doPost(request,response);
}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
	
		PrintWriter out = response.getWriter();
		String username = (String)request.getParameter("user");
		String password = (String)request.getParameter("pass");
		if(username.equals("tomcat") && password.equals("tomcat")){
			out.println("success!");
		}
		else{
			out.println("fail!");
		}
		
		
	}
	
	
}
