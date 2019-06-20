<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h4>Step1:选择要购买的书籍</h4>
	
	<form action="<%=request.getContextPath() %>/processStep1Servlet" method="post">
		<table border="1">
			<tr>
				<td>书名</td>
				<td>购买</td>
			</tr>
			
			<tr>
				<td>Java</td>
				<td><input type="checkbox" name="book" value="Java"/></td>
			</tr>
			
			<tr>
				<td>Linux</td>
				<td><input type="checkbox" name="book" value="Linux"/></td>
			</tr>
			
			<tr>
				<td>Javaweb</td>
				<td><input type="checkbox" name="book" value="Javaweb"/></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="submit"/></td>
			</tr>
		</table>
	</form>
	<a href="<%=request.getContextPath() %>/listBookServlet">新购物车</a>
	
</body>
</html>