<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="cn.swu.edu.javaweb.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- EL 的运算符 -->
	${param.score > 60 ? "及格" : "不及格" }
	<br>
	<%
		List<String> names = new ArrayList<String>();
		names.add("hello");
		request.setAttribute("names", names);
	%>
	
	name is empty: ${empty requestScope.names }
	<br>
	<!-- 其他隐含对象，pageContext -->
	
	pageContext:即PageContext类型，但只能读取,就可以一直取下边的函数“.下去”
	<br>
	contextPath:${pageContext.request.contextPath }
	<br>
	sessionID：${pageContext.session.id }
	<br>
	sessionAttributeNames:${pageContext.session.attributeNames }
	<br>
	
	initParam:${initParam.initName }
	<br>
	
	Accept-Language: ${header["Accept-Language"] }
	<br>
	
	JSESSIONID: ${cookie.JSESSIONID.name } -- ${cookie.JSESSIONID.value }
	<br>
	<!-- 与输入有关的隐含对象：param，paramValues -->
	score: ${param.score }
	<br>
	names:${paramValues.name[0]["class"].name }
	<%--等价代码如下展示 
	<%=
		request.getParameterValues("name")[0].getClass().getName()
	%>
	--%>
	<br>
	<!-- 隐含对象与范围相关的：pageScope，requestScope，sessionScope，applicationScope -->
	time: ${applicationScope.time }
	<br>
	
	<!-- EL可以自动进行类型转换 -->
	score:${param.score + 11}
	<br>
	score:<%=request.getParameter("score") + 11%><br>
	<%
		Student student2 = new Student();
		student2.setAge("23");
		request.setAttribute("student", student2);
	%>
	
	<!-- 没有指定范围的话从小到达 -->
	age:${student.age}
	<br>
	age:${sessionScope.student["age"]}
	
	<%
		Student student = new Student();
		student.setName("HELLO");
		
		session.setAttribute("swu.edu.cn", student);
	%>
	<br>
	name:${sessionScope["swu.edu.cn"].name }

</body>
</html>