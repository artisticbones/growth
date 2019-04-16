<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	SessionID: <%= session.getId() %>
	<br><br>
	
	IsNew: <%= session.isNew() %>
	<br><br>
	
	MaxInactiveInterval: <%= session.getMaxInactiveInterval() %>
	<br><br>
	
	CreateTime: <%=session.getCreationTime() %>
	<br><br>
	
	LastAccessTime:<%=session.getLastAccessedTime() %>
	<br><br>
	
	Bye: <%=session.getAttribute("username") %>
	<br><br>
	
	
	<%
		session.invalidate();
	%>

	<a href="login.jsp">重新登录</a>
</body>
</html>