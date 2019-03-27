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
			String strAge = request.getParameter("age");
			Integer age = Integer.parseInt(strAge);
			if(age >= 18){
				out.println(user + "," + "You're an adult...");	
			}else{
				out.println(user + "," + "You're underage...");
			}
		} 
	%>
</body>
</html>