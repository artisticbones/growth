<%@page import="cn.swu.edu.Student"%>
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
	
	<%
		List<Student> stus = (List<Student>)request.getAttribute("students");
	%>
	
	<table border="1">
		
		<tr>
			<th>FlowId</th>
			<th>Type</th>
			<th>IdCard</th>
			<th>ExamCard</th>
			<th>StudentName</th>
			<th>Location</th>
			<th>Grade</th>
			<th>Delete</th>
		</tr>
		
		<%
			for(Student student: stus){
		%>
		
		<tr>
			<td><%= student.getFlowId() %></td>
			<td><%= student.getType() %></td>
			<td><%= student.getIdCard() %></td>
			<td><%= student.getExamCard() %></td>
			<td><%= student.getStudentName() %></td>
			<td><%= student.getLocation() %></td>
			<td><%= student.getGrade() %></td>
			<td><a href="deleteStudent?flowId=<%= student.getFlowId()%>">delete</a></td>
		</tr>
		
		<%		
			}
		%>
		
	</table>
	if you want to add record,please click <a href="addrecord.jsp">here</a>
	
	
</body>
</html>