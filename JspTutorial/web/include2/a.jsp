<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>AAA Page</h2>
	
	<% String str = "abcde"; %>
	
	<%-- <%@ include file="b.jsp"%> --%>
	
	<jsp:include page="b.jsp">
		<jsp:param value="tomcat" name="username"/>
	</jsp:include>
	<%-- <jsp:forward page="/include/b.jsp">
		<jsp:param value="tomcat" name="username"/>
	</jsp:forward>
	--%>
</body>
</html>