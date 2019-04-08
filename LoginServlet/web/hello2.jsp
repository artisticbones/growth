<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+ "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<%
		Object message = request.getAttribute("message");
		if(message != null && !"".equals(message)){
	%>
		<script type="text/javascript">
			alert("<%= message%>");
		</script>
	<%} %>
	<%
		Date date = new Date();
		out.print(date);
	%>
	<br><br>
	
	<form action="hello" method="post">
		user:<input type="text" name="username"> <br><br>
		pass:<input type="password" name="password"><br><br>
		age:<input type="text" name="age"><br><br>
			<input type="submit" value="submit">
	</form>
	
	
	
	<%!
		void test(){
		
	}
	%>
	
	<%--JSP注释可以注释掉代码 --%>
	<!-- html注释不可以注释JSP代码 -->
	<br>
	<%=date %>
	</center>
</body>
</html>