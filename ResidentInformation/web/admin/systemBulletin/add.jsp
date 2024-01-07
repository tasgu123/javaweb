<%--
  Created by IntelliJ IDEA.
  User: hx
  Date: 2023/11/20
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <base href="http://${header.host}${pageContext.request.contextPath}/admin/systemBulletin/">
    <title>添加系统公告</title>
</head>
<body>
<c:if test="${empty admin}">
    <c:redirect url="http://${header.host}${pageContext.request.contextPath}/admin/login.jsp"/>
</c:if>
<div>
    <h1>添加系统公告</h1>
    <a href="../home.jsp">前台首页</a>
    <a href="../residents/list">住户信息列表</a>
    <a href="../residents/add.jsp">添加住户信息</a>
    <a href="../adminUsers/list">管理员列表</a>
    <a href="../adminUsers/add.jsp">添加管理员</a>
    <a href="../serviceInformation/list">维修信息列表</a>
    <a href="list">系统公告列表</a>
    <a href="../adminUsers/reset?id=${admin.id}">重置密码</a>
    <a href="../logout">退出</a>
</div>
<hr>
<div>
<form method="post" action="add">
    系统公告id<input type="text" name="id">
    系统公告名称<input type="text" name="name">
    系统公告发布日期<input type="text" name="date">
    系统公告发布人<input type="text" name="adminName">
    <br>
    <button type="submit">提交</button>
</form>
</div>
</body>
</html>
