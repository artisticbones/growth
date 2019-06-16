<%--
  Created by IntelliJ IDEA.
  User: artisticbones
  Date: 19-6-11
  Time: 下午3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
    <h4>登录成功</h4>
    <a href="<%= request.getContextPath() %>/webpages/shoppingcart/step-1.jsp">购物车</a>
    <br><br>
    <a href="<%= request.getContextPath()%>/webpages/fileupload/upload.jsp">文件上传</a>
    <br><br>
    <a href="<%= request.getContextPath()%>/download/download.pdf">文档说明</a>
</body>
</html>
