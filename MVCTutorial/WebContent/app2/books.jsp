<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="book.jsp?book=JavaWeb">Java WEB</a><br>
	<a href="book.jsp?book=Java">Java</a><br>
	<a href="book.jsp?book=Oracle">Oracle</a><br>
	<a href="book.jsp?book=Ajax">Ajax</a><br>
	<a href="book.jsp?book=JavaScript">JavaScript</a><br>
	<a href="book.jsp?book=Android">Android</a><br>
	<a href="book.jsp?book=Spring">Spring</a><br>
	<a href="book.jsp?book=Hibernate">Hibernate</a><br>
	
	<br><br>
	<%
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0){
			for(Cookie cookie: cookies){
				String cookieName = cookie.getName();
				if(cookieName.startsWith("SWU_BOOK_")){
					out.println(cookie.getValue());
				}
			}
		}
		
	%>
	
</body>
</html>