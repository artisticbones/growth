<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>ABB Page</h2>
	<%-- 
	<%=  str %> <!-- 前提是使用了include标签 -->
	--%>
	
	<%
		String name = request.getParameter("username");
		out.println(name);
	%>
</body>
</html>