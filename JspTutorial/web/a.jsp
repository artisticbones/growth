<%@page import="java.text.DateFormat"%>
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
		Date date = new Date();
		DateFormat dateFormat = null;
		
		HttpServletRequest req = null;
		//int i = 10 / 0;
	%>
	
	<form action="hello.jsp" method="get">
		username: <input type="text" name="username">
		<input type="submit" value="submit">
	</form>
</body>
</html>