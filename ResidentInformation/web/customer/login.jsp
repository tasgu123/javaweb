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
    <title>顾客登录</title>
</head>
<body>
<h1>顾客登录</h1>
<form method="post" action="login">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    验证码：<input type="text" name="inputCode">
    <img src="validCode" id="vCode" onclick="refreshCode()"><br>
    <button type="submit">登 录</button>
</form>
<div>
    <span><a href="register.jsp">新顾客注册</a></span>
    <span><a href="../admin/login.jsp">管理员登录</a></span>
</div>
</body>
</html>
<script>
    function refreshCode() {
        document.getElementById("vCode").src = "validCode?r=" + Math.random();
    }
</script>
