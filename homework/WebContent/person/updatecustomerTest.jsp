
<%@page import="cn.swu.edu.javaweb.manager.pojo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%= request.getAttribute("message") == null ? "" : request.getAttribute("message")%>
	<%
		String id = null;
		String name = null;
		String oldName = null;
		String position = null;
		String office = null;
		String age = null;
		String sDate = null;
		String salary = null;
		
		Person person = (Person)request.getAttribute("person");
		if(person != null){
			id = person.getId() + "";
			oldName = person.getName();
			name = person.getName();
			position = person.getPosition();
			office = person.getOffice();
			age = person.getAge();
			sDate = person.getsDate();
			salary = person.getSalary();
			
		}else{
			id = request.getParameter("id");
			oldName = request.getParameter("oldName");
			name = request.getParameter("oldName");
			
			position = request.getParameter("position");
			office = request.getParameter("office");
			age = request.getParameter("age");
			sDate = request.getParameter("sDate");
			salary = request.getParameter("salary");
		}
	%>
	
	<form action="update.do" method="post">
	
		<input type="hidden" name="id" value="<%= id %>"/>
		<input type="hidden" name="oldName" value="<%= oldName %>"/>
		<table>
			<tr>
				<td>CustomerName:</td>
				<td><input type="text" name="name" value="<%= name%>"></td>
			</tr>
			<tr>
				<td>Position:</td>
				<td><input type="text" name="position" value="<%= position%>"></td>
			</tr>
			<tr>
				<td>Office:</td>
				<td><input type="text" name="office" value="<%= office%>"></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input type="text" name="age" value="<%= age%>"></td>
			</tr>
			<tr>
				<td>Start_Date:</td>
				<td><input type="text" name="sDate" value="<%= sDate%>"></td>
			</tr>
			<tr>
				<td>Salary:</td>
				<td><input type="text" name="salary" value="<%= salary%>"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
	
</body>
</html>