<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	body{text-align:center;background-color: #fff}
	#divcss5{margin:0 auto;border:0px solid #000}
</style>
<body>
	<font color="red">
		<%= session.getAttribute("message") == null ? "" : session.getAttribute("message") %>
	</font>
	<div id="divcss5">
	<form action="<%=request.getContextPath() %>/checkCodeServlet" method="post">
		
		
		name:<input type="text" name="name"/><br><br>
		checkcode: <input type="text" name="CHECK_CODE_PARAM_NAME"/><br>
		<img alt="" src="<%= request.getContextPath()%>/validateColorServlet"><br>
		<input type="submit" value="submit"/>
	</form>
	</div>
</body>
</html>