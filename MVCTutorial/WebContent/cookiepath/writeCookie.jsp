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
		Cookie cookie = new Cookie("cookiePath","CookiePathValue");
		//设置Cookie的作用范围
		cookie.setPath(request.getContextPath());
	
		response.addCookie(cookie);
	%>
	
	<a href="../cookie2.jsp">To read CookiePath</a>
	<br>
	<%= request.getContextPath() %>
</body>
</html>