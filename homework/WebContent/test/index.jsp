<%--
  Created by IntelliJ IDEA.
  User: artisticbones
  Date: 19-6-11
  Time: 上午10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>程飞天的WEB系统</title>
  </head>
  <style>
	body{text-align:center;background-color: #fff}
	#divcss5{margin:0 auto;border:0px solid #000}
  </style>
  <body>
 	<font color="red">
		<%= session.getAttribute("message") == null ? "" : session.getAttribute("message") %>
	</font>
	<div id="divcss5">
	    <form action="<%=request.getContextPath() %>/login.action" method="post">
	      <table>
	        <tr>
	          <td>用户名:</td>
	          <td><input type="text" name="username"></td>
	        </tr>
	        <tr>
	          <td>密  码:</td>
	          <td><input type="password" name="password"></td>
	        </tr>
	        <tr>
	        	<td>验证码:</td>
	        	<td><input type="text" name="CHECK_CODE_PARAM_NAME"/></td>
	        </tr>
	        <tr>
	        	<td><img alt="" src="<%= request.getContextPath()%>/validateColorServlet"><br></td>
	        </tr>
	        <tr>
	          <td><input type="submit" value="登录"></td>
	          <td><a href="<%=request.getContextPath() %>/register.jsp">注册</a></td>
	        </tr>
	      </table>
	    </form>
    </div>
  </body>
</html>
