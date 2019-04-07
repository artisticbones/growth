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
	
	<div style="position:fixed;z-index:-1;width:100%;height:100%;left:0px;top:0px">
		<img src="../images/city.jpg" width="100%" height="100%"/>
	</div>
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
	<div style="background-color:#80ffff;border:2px;solid:#fff;padding:30;width:30%;margin-top:10%;margin-right:0%;float:right;border-radius:25px">
	<form action="hello" method="post">
		<p>user:<input type="text" name="username"></p>
		<p>pass:<input type="password" name="password"></p>
		<p>age:<input type="text" name="age"></p>
		<p>	<input type="submit" value="submit"></p>
		<p><%=date %></p>
	</form>
	</div>
	
	
	<%!
		void test(){
		
	}
	%>
	
	<%--JSP注释可以注释掉代码 --%>
	<!-- html注释不可以注释JSP代码 -->
	<br>
	
	</center>
</body>
</html>
