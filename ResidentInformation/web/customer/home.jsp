<%--
  Created by IntelliJ IDEA.
  User: hx
  Date: 2023/11/20
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <base href="http://${header.host}${pageContext.request.contextPath}/customer/">
    <title>社区信息系统</title>
</head>
<body>
<c:if test="${empty customer}">
    <c:redirect url="http://${header.host}${pageContext.request.contextPath}/customer/login.jsp"/>
</c:if>
<h1>欢迎来到社区信息管理平台</h1>
你好，${customer.username}
<a href="modPre?id=${customer.residentId}">修改账户信息</a>
<hr>
<a href="Info/list">个人信息</a>
<a href="systemBulletin/list">系统公告列表</a>
<a href="serviceInformation/add.jsp">故障维修申请</a>
<a href="customer/reset?id=${customer.residentId}">重置密码</a>
<a href="logout">退出登录</a>
</body>
</html>
