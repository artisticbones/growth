<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<font color="red">${message }</font>
	<br><br>
		<form action="b.jsp" method="post">
			username: <input type="text" name="username"><br>
			<input type="submit" value="Submit">
		</form>
	</center>
	
</body>
</html>