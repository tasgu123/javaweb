<%--
  Created by IntelliJ IDEA.
  User: hx
  Date: 2023/11/7
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <base href="http://${header.host}${pageContext.request.contextPath}/admin/adminUsers/">
    <title>添加管理员</title>
</head>
<body>
<c:if test="${empty admin}">
    <c:redirect url="http://${header.host}${pageContext.request.contextPath}/admin/login.jsp"/>
</c:if>
<div>
    <h1>住户信息后台管理</h1>
    <a href="../home.jsp">前台首页</a>
    <a href="../admin/residents/list">住户信息列表</a>
    <a href="../admin/residents/add.jsp">添加住户信息</a>
    <a href="list">管理员列表</a>
    <a href="../serviceInformation/list">维修信息列表</a>
    <a href="../systemBulletin/list">系统公告列表</a>
    <a href="../systemBulletin/add.jsp">添加系统公告</a>
    <a href="reset?id=${admin.id}">重置密码</a>
    <a href="../logout">退出</a>
    <hr>
    <h2>添加管理员</h2>
    <form method="post" action="add">
        id<input type="text" name="id">
        用户名<input type="text" name="username">
        密码<input type="password" name="password">
        <br>
        <button type="submit">提交</button>
    </form>
</div>
</body>
</html>
