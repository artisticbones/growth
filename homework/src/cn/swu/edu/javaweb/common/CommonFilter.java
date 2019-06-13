package cn.swu.edu.javaweb.common;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class CommonFilter
 */
@WebFilter("/*")
public class CommonFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
		//设置响应报头允许当前应用被跨域请求（CROS）
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		HttpSession session = request.getSession();
		
		//获得用户请求的URL
		String url = request.getRequestURI();
		boolean check =false;
		
		// 因为是全局过滤，所以会对所有请求进行过滤，诸如css、js、png等等
        // 所以应该做到只拦截.html和.jsp请求，对请求地址的末尾进行判断
        // 修订 servlet加入拦截过滤范围
        if (url.endsWith(".jsp") || url.endsWith(".html") || url.endsWith("Servlet") || url.endsWith(".action"))
            check = true;
        
        //判断登录请求的servlet或者登录页面不过滤
        if(url.endsWith("/homework/login.action") || url.endsWith("/homework/index.jsp") || url.endsWith("/homework/validateColorServlet") || url.endsWith("/homework/register.jsp"))
        	check = false;
        if (check) {
            // 判断session中此值是否存在
            if (session.getAttribute("username") != null) {
                //System.out.println("---->通过】");
                chain.doFilter(request, response); //放行
            } else {
                //System.out.println("---->未通过!】");
                response.sendRedirect("/homework"); //跳转回根目录
            }
        } else {
            // 非html和jsp请求一律不管
            chain.doFilter(request, response);
        }
	}


}
