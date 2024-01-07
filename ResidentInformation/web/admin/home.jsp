<%--
  Created by IntelliJ IDEA.
  User: hx
  Date: 2023/11/20
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <base href="http://${header.host}${pageContext.request.contextPath}/admin/">
    <title>管理员社区管理平台</title>
</head>
<body>
<c:if test="${empty admin}">
    <c:redirect url="http://${header.host}${pageContext.request.contextPath}/admin/login.jsp"/>
</c:if>
<h1>欢迎来到社区信息管理平台</h1>
<p>你好，${admin.username}</p>
<a href="adminUsers/add">添加管理员</a>
<a href="adminUsers/list">管理员信息列表</a>
<a href="residents/add">添加住户信息</a>
<a href="residents/list">住户信息列表</a>
<a href="serviceInformation/list">维修信息列表</a>
<a href="systemBulletin/list">系统公告列表</a>
<a href="systemBulletin/add.jsp">添加系统公告</a>
<a href="adminUsers/reset?id=${admin.id}">重置密码</a>
<a href="logout">退出登录</a>
</body>
</html>
