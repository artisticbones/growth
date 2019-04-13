<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>Book Detail Page</h4>
	
	Book: <%= request.getParameter("book") %>
	
	<br><br>
	
	<a href="books.jsp">Return</a>

	<%
		String book = request.getParameter("book");	
	
		Cookie[] cookies = request.getCookies();
	
		List<Cookie> bookCookies = new ArrayList<Cookie>();
		
		Cookie tempCookie = null;
		if(cookies != null && cookies.length > 0){
			for(Cookie cookie: cookies){
				String cookieName = cookie.getName();
				if(cookieName.startsWith("SWU_BOOK_")){
					bookCookies.add(cookie);
					
					if(cookie.getValue().equals(book)){
						tempCookie = cookie;
					}
				}
			}
		}
		
		if (bookCookies.size() >= 5 && tempCookie == null){
			tempCookie = bookCookies.get(0);
		}
		
		if(tempCookie != null){
			tempCookie.setMaxAge(0);
			response.addCookie(tempCookie);
		}
	
		//2.把从books.jsp传入的book作为一个cookie返回
		
		Cookie cookie = new Cookie("SWU_BOOK_" + book,book);
		response.addCookie(cookie);
		%>

</body>
</html>