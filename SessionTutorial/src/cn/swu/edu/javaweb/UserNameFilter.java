package cn.swu.edu.javaweb;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class UserNameFilter
 */
@WebFilter("/hello.jsp")
public class UserNameFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserNameFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		String username = request.getParameter("username");
		String initUser = filterConfig.getInitParameter("username");
		
		if(!username.equals(initUser)) {
			request.setAttribute("message", "用户名不存在！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}

	private FilterConfig filterConfig;
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = fConfig;
	}

}
