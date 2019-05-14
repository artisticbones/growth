package cn.swu.edu.javaweb.practice;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.swu.edu.javaweb.common.HttpFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/*")
public class EncodingFilter extends HttpFilter {

	private String encoding;
	@Override
	protected void init() {
		encoding = getFilterConfig().getServletContext().getInitParameter("encoding");
	}
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//String encoding = request.getServletContext().getInitParameter("encoding");
		System.out.println(encoding);
		
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
	}
	
}
