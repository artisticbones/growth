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
		String name = request.getParameter("name");
		
		if (name != null && !name.trim().equals("")){
			Cookie cookie = new Cookie("name",name);
			cookie.setMaxAge(30);
			response.addCookie(cookie);
		}else{
			Cookie [] cookies = request.getCookies();
			if(cookies != null && cookies.length > 0){
				for (Cookie cookie : cookies){
					String cookieName = cookie.getName();
					if("name".equals(cookieName)){
						String val = cookie.getValue();
						name = val;
					}
				}
			}
		}
		
		if(name != null && !name.trim().equals("")){
			out.print("Hello:" + name);
		}else{
			response.sendRedirect("login.jsp");
		}
	%>
	
</body>
</html>