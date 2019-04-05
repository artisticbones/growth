<%@page import="cn.swu.edu.domain.Customer"%>
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
	
	<form action="query.action" method="post">
		<table>
			<tr>
				<td>CustomerName:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address"></td>
			</tr><tr>
				<td>Phone:</td>
				<td><input type="text" name="phone"></td>
			</tr><tr>
				<td><input type="submit" name="Query"></td>
				<td><a href="">Create New Customer</a></td>
			</tr>
		</table>
	</form>
	
	<br><br>
	
	<%
		List<Customer> customers = (List<Customer>)request.getAttribute("customer");
		if(customers != null && customers.size() > 0){
	%>
		<hr>
		<br><br>
		
		<table border="1">
			<tr>
				<th>ID</th>
				<th>CustomerName</th>
				<th>Address</th>
				<th>Phone</th>
				<th>UPDATE/DELETE</th>
			</tr>
			
			<%
				for(Customer customer: customers){
			%>
				<tr>
					<td><%= customer.getId()%></td>
					<td><%= customer.getName()%></td>
					<td><%= customer.getAddress()%></td>
					<td><%= customer.getPhone() %></td>
					<td>
						<a href="">UPDATE</a>
						<a href="">DELETE</a>
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