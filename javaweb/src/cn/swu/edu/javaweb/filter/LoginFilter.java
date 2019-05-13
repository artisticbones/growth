package cn.swu.edu.javaweb.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.swu.edu.javawe.common.HttpFilter;

public class LoginFilter extends HttpFilter {

	//1.获取sessionKey.redirectUrl,uncheckedUrls
	private String sessionKey;
	private String redirectUrl;
	private String uncheckedUrls;
	
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		ServletContext servletContext = getFilterConfig().getServletContext();
		
		sessionKey = servletContext.getInitParameter("userSessionKey");
		redirectUrl = servletContext.getInitParameter("redirectPage");
		uncheckedUrls = servletContext.getInitParameter("uncheckedUrls");
	}
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//1.获取请求的URL
		String requestUrl = request.getServletPath();
		System.out.println(requestUrl);
		//2.比较是否需要拦截，不需要则直接放行
		List<String> urls = Arrays.asList(uncheckedUrls.split(","));
		if(urls.contains(requestUrl)) {
			chain.doFilter(request, response);
			return;
		}
		//3.检查是否有sessionKey，没有则重定向到login.jsp
		Object user = request.getSession().getAttribute(sessionKey);
		if(user == null) {
			response.sendRedirect(request.getContextPath() + redirectUrl);
			return;
		}
		//4.否则直接放行
		chain.doFilter(request, response);
	}

}
