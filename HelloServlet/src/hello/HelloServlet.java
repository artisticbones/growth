package hello;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet{


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy...");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("getServletConfig...");
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("getServletInfo...");
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Init...");
		
		String user = config.getInitParameter("user");
		System.out.println("user:" + user);
		
		Enumeration<String> names = config.getInitParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String value = config.getInitParameter(name);
			System.out.println("^^" + name + ":" + value );
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service");
	}
	
	public HelloServlet() {
		System.out.println("helloServlet` construct");
	}

}
