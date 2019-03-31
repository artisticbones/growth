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
	<script type="text/javascript">
		//3秒钟之后跳转到指定的页面
		setTimeout(window.location.href='/MVCTutorial/listAllStudents',5);
	</script>
	<a href="listAllStudents">如果未返回，可以点击这里...</a>
	<%--
		Thread.sleep(3000);
		request.getRequestDispatcher("listAllStudents").forward(request, response);
	--%>
</body>
</html>