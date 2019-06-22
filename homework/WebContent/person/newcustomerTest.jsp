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
	
	<form action="<%=request.getContextPath() %>/addCustomer.do" method="post">
	
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="<%= request.getParameter("name") == null ? "" : request.getParameter("name")%>"></td>
			</tr>
			<tr>
				<td>Position:</td>
				<td><input type="text" name="position" value="<%= request.getParameter("position") == null ? "" : request.getParameter("position")%>"></td>
			</tr>
			<tr>
				<td>Office:</td>
				<td><input type="text" name="office" value="<%= request.getParameter("office") == null ? "" : request.getParameter("phone")%>"></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input type="text" name="age" value="<%= request.getParameter("age") == null ? "" : request.getParameter("age")%>"></td>
			</tr>
			<tr>
				<td>Start_Date:</td>
				<td><input type="text" name="sDate" value="<%= request.getParameter("sDate") == null ? "" : request.getParameter("sDate")%>"></td>
			</tr>
			<tr>
				<td>Salary:</td>
				<td><input type="text" name="salary" value="<%= request.getParameter("salary") == null ? "" : request.getParameter("salary")%>"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
	
</body>
</html>