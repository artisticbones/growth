<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>BBB Page</h4>
	
	<%
		//1.请求转发代码
		//request.getRequestDispatcher("c.jsp").forward(request, response);
		
		//2.重定向
		response.sendRedirect("c.jsp");
	%>
</body>
</html>