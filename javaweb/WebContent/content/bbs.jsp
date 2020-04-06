<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	content:${param.content }
	<br><br>
	
	method:<%= request.getMethod() %>
	<br><br>
	<%=request%>
	
</body>
</html>