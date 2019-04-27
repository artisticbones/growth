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
	
	<jsp:useBean id="student" class="cn.swu.edu.javaweb.Student" scope="request"></jsp:useBean>
	<!-- 
	<jsp:setProperty property="age" value="10" name="student"/>
	<jsp:getProperty property="age" name="student"/>
	 -->
	 
	 <jsp:useBean id="student2" beanName="cn.swu.edu.javaweb.Student"
	 type="java.lang.Object" scope="request"></jsp:useBean>
	 
	 <%--
	 	Object student3 = request.getAttribute("student3");
	 	if(student3){
	 		student3 = Class.forName("cn.swu.edu.javaweb.Student").newInstance();
	 		request.setAttribute("student3", student3);
	 	}
	 --%>
	 
	 <jsp:setProperty property="*" name="student"/>
	 
	 age:<jsp:getProperty property="age" name="student"/>
	 
	 name:<jsp:getProperty property="name" name="student"/>
	 
	 id:<jsp:getProperty property="id" name="student"/>
	<%-- 
	<%= student.getAge() %>
	--%>
	<%--
	<%=student.setAge() %>
	 --%>
	<%--
		//1.从scope(session)中获取id(customer)属性值，赋值给class(cn.swu.edu.javaweb.Student)
		//类型的id(customer)变量
		Student student2 = (Student)session.getAttribute("student2");
		
		//2.若属性为null，则利用反射创建一个新的对象，把该对象赋值给id(customer),并以id（customer）
		//为属性名到scope（session）中。
		if (student2 == null){
			student2 = (Student)Class.forName("cn.swu.edu.javaweb.Student").newInstance();
			session.setAttribute("student2", student2);
		}
	--%>
</body>
</html>