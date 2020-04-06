<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	操作成功！请等待5秒后自动返回......
	<br><br>
	
	<a href="query.action">如果未返回，可以点击这里...</a>
	<%--
		Thread.sleep(3000);
		request.getRequestDispatcher("listAllStudents").forward(request, response);
	--%>
</body>
<script type="text/javascript">
		//3秒钟之后跳转到指定的页面
		window.setTimeout("location.href='/MVCTutorial/query.action';",5000);
</script>
</html>
