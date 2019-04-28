<%@page import="cn.swu.edu.javaweb.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="el.jsp" method="post">
		user:<input type="text" name="username" 
		value="<%= request.getParameter("username") == null ? "" : request.getParameter("username")%>"/>
		<br>
		user:<input type="text" name="username" value="${param.username}"/>
		<br>
		<input type="submit" value="submit">
	</form>
	
	username: <%= request.getParameter("username") %>
	
	<br>
	
	<jsp:useBean id="student" class="cn.swu.edu.javaweb.Student" scope="session"></jsp:useBean>
	<jsp:setProperty property="age" value="12" name="student"/>
	
	age:
	<%
		Student student2 = (Student)session.getAttribute("student");
		out.print(student2.getAge());
	%>
	<br>
	age:<jsp:getProperty property="age" name="student"/><br>
	<a href="el2.jsp?score=89">To el2.jsp</a>
</body>
</html>