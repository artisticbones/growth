<%@page import="cn.swu.edu.javaweb.manager.pojo.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-3.3.1.js"></script>
<!--  <script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var content = $(this).parent().parent().find("td:eq(1)").text();
			var flag = confim("确定删除" + content + "?");
			return flag;
		});
	});
</script>
-->
<script type="text/javascript">
    $(document).ready(function(){
		$("#adminDelete").click(function(){
			if(confirm("Delete Anyway?")){
				alert("success");
				return true;
			}
			return false;
		});
    });
</script>
</head>
<body>
	
	<form action="<%=request.getContextPath() %>/query.do" method="post">
		<table>
			<tr>
				<td>CustomerName:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Position:</td>
				<td><input type="text" name="position"></td>
			</tr>
			<tr>
				<td>Office:</td>
				<td><input type="text" name="office"></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>Start_Date:</td>
				<td><input type="text" name="sDate"></td>
			</tr>
			<tr>
				<td>Salary:</td>
				<td><input type="text" name="salary"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Query"></td>
				<td><a href="<%=request.getContextPath() %>/person/newcustomer.jsp">Create New Customer</a></td>
			</tr>
		</table>
	</form>
	
	<br><br>
	
	<%
		List<Person> persons = (List<Person>)request.getAttribute("person");
		if(persons != null && persons.size() > 0){
	%>
		<hr>
		<br><br>
		
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Position</th>
				<th>Office</th>
				<th>Age</th>
				<th>Start_Date</th>
				<th>Salary</th>
				<th>UPDATE/DELETE</th>
			</tr>
			
			<%
				for(Person person: persons){
			%>
				<tr>
					<td><%= person.getId()%></td>
					<td><%= person.getName()%></td>
					<td><%= person.getPosition()%></td>
					<td><%= person.getOffice() %></td>
					<td><%= person.getAge() %></td>
					<td><%= person.getsDate() %></td>
					<td><%= person.getSalary() %></td>
					<td>
						<a href="edit.do?id=<%= person.getId() %>">UPDATE</a>
						<a  id="adminDelete" href="delete.do?id=<%= person.getId()%>" class="btn btn-danger">DELETE</a>
					</td>
				</tr>
			<%
				}
			%>
		</table>
	<%
		}
	%>
	
</body>
</html>