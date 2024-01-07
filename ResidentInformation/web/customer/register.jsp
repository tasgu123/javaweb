<%--
  Created by IntelliJ IDEA.
  User: hx
  Date: 2023/11/13
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <base href="http://${header.host}${pageContext.request.contextPath}/customer/">
    <title>新顾客注册</title>
</head>
<body>
<form action="register" method="post">
    用户名：<input type="text" name="name"><br>
    密码：<input type="password" name="password"><br>
    <button type="submit">确 定</button>
</form>
<div>
    <span><a href="login.jsp">顾客登录</a></span>
    <span><a href="../admin/login.jsp">管理员登录</a></span>
</div>
</body>
</html>
