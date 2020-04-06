package cn.swu.edu;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public abstract class MyGenericServlet implements Servlet,ServletConfig {

	/**以下方法为servlet接口实现的方法**/
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return servletConfig;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	private ServletConfig servletConfig;
	/**这个成员变量可以获得一些get 的方法**/
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.servletConfig = arg0;
		init();
	}

	@Override
	public abstract void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException;
	
	/**以下方法为ServletConfig接口实现的方法**/
	@Override
	public String getInitParameter(String arg0) {
		// TODO Auto-generated method stub
		return servletConfig.getInitParameter(arg0);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		// TODO Auto-generated method stub
		return servletConfig.getInitParameterNames();
	}

	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return servletConfig.getServletContext();
	}

	@Override
	public String getServletName() {
		// TODO Auto-generated method stub
		return servletConfig.getServletName();
	}

	public void init() throws ServletException{}

}
