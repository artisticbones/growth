<%@page import="cn.swu.edu.LoginUsers" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%=session.getAttribute("message") == null ? "" : session.getAttribute("message")%>
	<%
		List<LoginUsers> users = (List<LoginUsers>)session.getAttribute("user");
		for(LoginUsers user:users){
			String username = user.getUsername();
			String oldPassword = user.getPassword();
		
	%>
	<form action="setPassword" method="post">
		<input type="hidden" name="username" value="<%= username %>"/>
		<input type="hidden" name="oldPassword" value="<%= oldPassword %>"/>
		New Password:<input type="password" name="newPassword"/>
		Again:<input  type="password" name="again"/>
		<input type="submit" value="submit" />
	</form>
	<% 
		}
	%>	
</body>
</html>