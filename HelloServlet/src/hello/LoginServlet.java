package hello;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = req.getParameter("user");
		String password = req.getParameter("pass");
		
		System.out.println("user:" + user);
		System.out.println("password:" + password);
		
		String interesting = req.getParameter("checkbox");
		System.out.println(interesting);
		
		String[] interestings = req.getParameterValues("checkbox");
		for(String interest:interestings) {
			System.out.println("-->" + interest);
		}
		
		Enumeration<String> names = req.getParameterNames(); 
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			Map<String, String[]> value = req.getParameterMap();
			
			System.out.println(name + "," + value);
		}
	}

}
