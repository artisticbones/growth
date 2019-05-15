package cn.swu.edu.javaweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ServletListener 
	implements ServletContextListener,ServletRequestListener,HttpSessionListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
//		ServletContextListener.super.contextInitialized(sce);
		System.out.println("ServletContext 对象被创建！");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//ServletContextListener.super.contextDestroyed(sce);
		System.out.println("ServletContext 对象被销毁！");
	}
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
//		ServletRequestListener.super.requestInitialized(sre);
		System.out.println("ServletRequest 对象被创建！");
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
//		ServletRequestListener.super.requestDestroyed(sre);
		System.out.println("ServletRequest 对象被销毁！");
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
//		HttpSessionListener.super.sessionCreated(se);
		System.out.println("HttpSession 对象被创建！");
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
//		HttpSessionListener.super.sessionDestroyed(se);
		System.out.println("HttpSession 对象被销毁！");
	}
}
