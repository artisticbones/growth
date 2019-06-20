package cn.swu.edu.javaweb.login.controlloer;

import cn.swu.edu.javaweb.login.dao.LoginUserDAO;
import cn.swu.edu.javaweb.login.pojo.LoginUser;
import cn.swu.edu.javaweb.login.service.LoginUserDAOJdbcImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LoginServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginUserDAO loginUserDAO = new LoginUserDAOJdbcImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取servletPath
        String servletPath = request.getServletPath();
        //2.去掉后缀和/
        String methodName = servletPath.substring(1);
        methodName = methodName.substring(0,methodName.length()-7);

        System.out.println(methodName);
        try {
            Method method = getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            //3.利用反射获取具体的方法
            method.invoke(this,request,response);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            response.sendRedirect("/404.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private void login(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    	//1.获取用户名,密码和验证码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String paramCode = request.getParameter("CHECK_CODE_PARAM_NAME");
		String sessionCode = (String)request.getSession().getAttribute("CHECK_CODE_KEY");
        //2.查询数据库是否匹配
		System.out.println(paramCode);
		System.out.println(sessionCode);
        LoginUser loginUser = loginUserDAO.findUser(username, password);
		if(loginUser != null) {
			if (paramCode != null && paramCode.equals(sessionCode)){
	            //3.匹配则重定向到主页
				HttpSession session = request.getSession();
                session.setAttribute("username", username);
                
	            response.sendRedirect(request.getContextPath() + "/bootstrap/index.jsp");
	            return;
	        }else {
	            //4.否则重定向到登录页面
	        	request.getSession().setAttribute("message", "验证码不一致！");
				response.sendRedirect(request.getContextPath() + "/login.jsp");
				return;
	        }
		}else {
			request.getSession().setAttribute("message", "用户名或密码不正确！");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		//System.out.println(loginUser);
//		if(paramCode != null && paramCode.equals(sessionCode)) {
//			response.sendRedirect(request.getContextPath() + "/shoppingcart/step-1.jsp");
//		}else {
//			request.getSession().setAttribute("message", "验证码不一致！");
//			response.sendRedirect(request.getContextPath() + "/check/index.jsp");
//			return;
//		}
    }
    
    private void register(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        //1.获取用户名和密码
        String username = request.getParameter("username");
        String realName = request.getParameter("firstName") + request.getParameter("lastName");
        System.out.println(realName);
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");
        System.out.println(username);
        LoginUser loginUser = new LoginUser();
        System.out.println("1");
        //不检查是否为空（在前端监测比在后端检查要方便）
        //2.调用save方法将信息存入数据库
        if (username != null && password != null){
        	if(password.equals(repeatPassword)) {
	            System.out.println("2");
	            loginUser.setRealName(realName);
	            loginUser.setUsername(username);
	            loginUser.setPassword(password);
	            System.out.println("3");
	            loginUserDAO.save(loginUser);
	            System.out.println("4");
	            response.sendRedirect("index.jsp");
	            return;
            }else {
            	HttpSession session = request.getSession();
            	session.setAttribute("message", "两次密码不一致");
            	response.sendRedirect(request.getContextPath() + "/register.jsp");
            	return;
            }
        }else {
            request.setAttribute("message","用户名或密码不合规范！");
            request.getRequestDispatcher(request.getContextPath() + "/register.jsp").forward(request,response);
            return;
        }
    }
    
    private void logout(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    	
    	HttpSession session = request.getSession();
    	//String name = (String) session.getAttribute("username");
		session.removeAttribute("username");
    	response.sendRedirect(request.getContextPath() + "/login.jsp");
    	
    }
    
    private void update(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    	//1.获取表单参数: id,name,address,phone,oldName
    			String id = request.getParameter("id");
    			System.out.println(id);
    			String name = request.getParameter("username");
    			String realName = request.getParameter("realname");
    			String password = request.getParameter("password");
    			String address = request.getParameter("address");
    			String phone = request.getParameter("phone");
    			String oldName = request.getParameter("oldName");
    			//2.检验name是否被占用:
    			//2.1比较name和oldname是否相同，相同说明namekeyong
    			if(!(oldName.equalsIgnoreCase(name))) {
    				long count = loginUserDAO.getCountWithName(name);
    				//若返回值大于0，则响应updatecustomer.jsp页面,使用转发方式
    				System.out.println(count);
    				if(count > 0) {
    					//在该页面显示提示错误消息
    					String message = "user " + name + "already exists!";
    					request.setAttribute("message", message);
    					request.getRequestDispatcher(request.getContextPath() + "/login/userInfo.jsp").forward(request, response);
    					return;
    				}
    			}
    			LoginUser user = new LoginUser();
    			user.setId(Integer.parseInt(id));
    			user.setUsername(name);
    			user.setRealName(realName);
    			user.setPassword(password);
    			user.setAddress(address);
    			user.setPhone(phone);
    				
    			loginUserDAO.update(user);
    			System.out.println("user-->" + user);
    			response.sendRedirect(request.getContextPath() + "/login/success.jsp");
    }
}
