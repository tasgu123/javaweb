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
    <meta charset="UTF-8">
    <base url="http://${header.host}${pageContext.request.contextPath}/admin/adminUsers/">
    <title>修改管理员信息</title>
</head>
<body>
<c:if test="${empty admin}">
    <c:redirect url="http://${header.host}${pageContext.request.contextPath}/adminUsers/login.jsp"></c:redirect>
</c:if>
<div>
    <h1>住户信息后台管理</h1>
    <a href="../home.jsp">前台首页</a>
    <a href="../residents/list">用户信息列表</a>
    <a href="../residents/add.jsp">添加用户信息列表</a>
    <a href="list">管理员列表</a>
    <a href="add.jsp">添加管理员</a>
    <a href="../serviceInformation/list">维修信息列表</a>
    <a href="../systemBulletin/list">系统公告列表</a>
    <a href="../systemBulletin/add.jsp">添加系统公告</a>
    <a href="reset?id=${admin.id}">重置密码</a>
    <a href="../logout">退出</a>
</div>
<hr>
<h2>修改管理员信息</h2>
<form action="mod" method="post">
    管理员id <input type="text" name="id" readonly value="${oldAdminUser.id}">
    管理员用户名 <input type="text" name="username" value="${oldAdminUser.username}">
    <input type="text" name="createTime" value="${oldAdminUser.createTime}" hidden="hidden">
    <input type="text" name="lastAccessTime" value="${oldAdminUser.lastAccessTime}" hidden="hidden">
    <button type="submit">提交</button>
</form>
</body>
</html>
