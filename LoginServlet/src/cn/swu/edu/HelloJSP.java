package cn.swu.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class HelloJSP extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		if(user.equals("tomcat") && pass.equals("tomcat")){
			session.setAttribute("success", "登陆成功");
			String strAge = request.getParameter("age");
			Integer age = Integer.parseInt(strAge);
			if(age >= 18){
				out.println(user + "," + "You're an adult...");	
			}else{
				out.println(user + "," + "You're underage...");
			}
			response.sendRedirect(request.getContextPath()+"/count.jsp");
			
		}else {
			request.setAttribute("message", "LoginFailed");
			request.getRequestDispatcher("/hello2.jsp").forward(request, response);
		}
	}

}
