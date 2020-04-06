<%@page import="cn.swu.edu.LoginUsers" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<font color="red">
		<%=session.getAttribute("message") == null ? "" : session.getAttribute("message")%>
	</font>
	<%
		LoginUsers users = (LoginUsers)session.getAttribute("user");
		String username = users.getUsername();
		String oldPassword = users.getPassword();
		
	%>
	<div align="center">
		<form action="<%=request.getContextPath() %>/setPassword" method="post">
			<input type="hidden" name="username" value="<%= username %>"/>
			<input type="hidden" name="oldPassword" value="<%= oldPassword %>"/>
			New Password:<input type="password" name="newPassword"/><br>
			Again:<input  type="password" name="again"/><br>
			<input type="submit" value="submit" />
		</form>
	</div>
</body>
</html>