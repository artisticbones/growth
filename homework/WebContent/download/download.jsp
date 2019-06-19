<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/homework/scripts/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/homework/scripts/jquery.media.js"></script>
</head>
<body style="height: 100%;width: 100%;overflow: hidden;margin: 0px;background-color: rgb(82,86,89)">
	<embed width="100%" height="100%" name="plugin" src="<%=request.getContextPath() %>/download/template.pdf" type="application/pdf">
</body>
</html>