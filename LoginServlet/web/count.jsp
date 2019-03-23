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
		Object message = session.getAttribute("success");
		if(message != null && !"".equals(message)){
	%>
		<script type="text/javascript">
			alert("<%=message%>");
		</script>
	<%
			String user = request.getParameter("username");
		} 
	%>
</body>
</html>