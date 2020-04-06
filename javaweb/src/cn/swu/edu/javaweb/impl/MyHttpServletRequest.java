package cn.swu.edu.javaweb.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyHttpServletRequest extends HttpServletRequestWrapper{

	public MyHttpServletRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getParameter(String name) {
		// TODO Auto-generated method stub
		String value = super.getParameter(name);
		if(value != null && value.contains(" fuck ")) {
			value = value.replace("fuck", "****");
		}
		return value;
	}
}
