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
	<!-- EL可以自动进行类型转换 -->
	score:${param.score + 11}
	<br>
	score:<%=request.getParameter("score") + 11%><br>
	<%
		Student student2 = new Student();
		student2.setAge("23");
		request.setAttribute("student", student2);
	%>
	
	<!-- 没有指定范围的话从小到达 -->
	age:${student.age}
	<br>
	age:${sessionScope.student["age"]}
	
	<%
		Student student = new Student();
		student.setName("HELLO");
		
		session.setAttribute("swu.edu.cn", student);
	%>
	<br>
	name:${sessionScope["swu.edu.cn"].name }

</body>
</html>