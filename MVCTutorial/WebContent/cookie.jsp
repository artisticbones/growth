<%@page import="org.apache.el.lang.ELSupport"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%

		Cookie [] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0){
			for (Cookie cookie: cookies){
				out.println(cookie.getName() + ":" + cookie.getValue());
				out.println("<br>");
			}
		}else{
			out.print("您没有一个cookie，正在创建并返回");
			
			Cookie cookie = new Cookie("name","hello");
			cookie.setMaxAge(30);
			response.addCookie(cookie);
		}
	%>

</body>
</html>