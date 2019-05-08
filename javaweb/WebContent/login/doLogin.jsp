<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		//1.获取用户登录信息
		String username = request.getParameter("username");
		
		//2.若登录信息完成，则将信息放入到HttpSession中
		if(username != null && !username.trim().equals("")){
			session.setAttribute(application.getInitParameter("userSessionKey"), username);
			//3.重定向到list.jsp
			response.sendRedirect("list.jsp");
		}else{
			response.sendRedirect("login.jsp");
		}
	%>
	
</body>
</html>