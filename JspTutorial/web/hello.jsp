<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Page</h1>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	
	POST's and GET's username: <%= request.getParameter("username") %>
	
	<br><br>
	
	<%
		String val = request.getParameter("username");
		String username = new String(val.getBytes("UTF-8"),"UTF-8");
		out.println("GET's username: " + username);
	%>
</body>
</html>