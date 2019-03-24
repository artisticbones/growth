<%@page import="java.util.Date"%>
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
		pageContext.setAttribute("pageContextAttr", "pageContextValue");
		request.setAttribute("requestAttr", "requestValue");
		session.setAttribute("sessionAttr", "sessionValue");
		application.setAttribute("applicationAttr", "applicationValue");
	%>
	
	<h2>Attr 1 Page <%= new Date() %></h2>
	<br><br>
	pageContextAttr: <%= pageContext.getAttribute("pageContext") %>
	<br><br>
	requestAttr: <%= request.getAttribute("pageContext") %>
	<br><br>
	sessionAttr: <%= session.getAttribute("pageContext") %>
	<br><br>
	applicationAttr: <%= application.getAttribute("pageContext") %>
	
	<a href="attr_2.jsp">To Attr2 Page</a>
</body>
</html>