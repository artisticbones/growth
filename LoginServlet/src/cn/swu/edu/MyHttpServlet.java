package cn.swu.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyHttpServlet extends MyGenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(arg0 instanceof HttpServletRequest) {
			HttpServletRequest request = (HttpServletRequest)arg0;
			if(arg1 instanceof HttpServletRequest) {
				HttpServletResponse response = (HttpServletResponse)arg1;
				
				service(request,response);
			}
		}
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
		String method = request.getMethod();
		
		if(method.equalsIgnoreCase("GET")) {
			doGet(request,response);
		}else if(method.equalsIgnoreCase("POST")) {
			doPost(request,response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// TODO Auto-generated method stub
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// TODO Auto-generated method stub
		
	}

}
