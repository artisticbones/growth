package hello;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;



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
			String value = req.getParameter(name);
			
			System.out.println("^^" + name + "," + value);
		}
		
		Map<String, String[]> map = req.getParameterMap();
		for(Map.Entry<String, String[]> entry:map.entrySet()) {
			System.out.println("**" + entry.getKey() + ":" + Arrays.asList(entry.getValue()));
		}
		
		HttpServletRequest httpservlet = (HttpServletRequest) req; 
		String URI = httpservlet.getRequestURI();
		System.out.println(URI);
		
		String query = httpservlet.getQueryString();
		System.out.println(query);
		
		String method = httpservlet.getMethod();
		System.out.println(method);
		
		String servletPath = httpservlet.getServletPath();
		System.out.println(servletPath);
	}
	
}
