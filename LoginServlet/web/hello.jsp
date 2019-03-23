<%@page import="java.util.Date"%>
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
		Date date = new Date();
		System.out.println("-->" + date);
	%>
	<% 
		String str = date.toString();
		
		String name = request.getParameter("name");
		System.out.println("name:" + name);
		
		Class clazz = response.getClass();
		System.out.println(clazz);
		System.out.println(response instanceof HttpServletResponse);
		
		ServletRequest req = pageContext.getRequest();
		System.out.println(req == request);
		
		System.out.println(session.getId());
		
		System.out.println(application.getInitParameter("password"));
		
		
		System.out.println(config.getServletName());
		
		out.println(request.getParameter("name"));
		
		out.println("<br><br>");
		out.println(request.getParameter("password"));
		out.println("<br><br>");
		out.println(this);
		out.println("<br><br>");
		out.println(page);
	%>
</body>
</html> 