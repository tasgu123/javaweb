<%--
  Created by IntelliJ IDEA.
  User: hx
  Date: 2023/11/20
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <base href="http://${header.host}${pageContext.request.contextPath}/customer/serviceInformation/">
    <title>添加维修信息</title>
</head>
<body>
<c:if test="${empty customer}">
    <c:redirect url="http://${header.host}${pageContext.request.contextPath}/customer/login.jsp"/>
</c:if>
你好，${customer.username}
<a href="../modPre?id=${customer.residentId}">修改账户信息</a>
<hr>
<h2>故障维修上报</h2>
<a href="../home.jsp">前台首页</a>
<a href="../Info/list">个人信息</a>
<a href="../systemBulletin/list">系统公告列表</a>
<a href="../reset?id=${customer.residentId}">重置密码</a>
<a href="../logout">退出登录</a>
<h1>添加维修信息</h1>
<div>
    <form method="post" action="add">
        维修信息id<input type="text" name="id">
        维修信息名称<input type="text" name="name">
        维修信息提交日期<input type="text" name="date">
        维修信息提交人<input type="text" name="residentName">
        <br>
        <button type="submit">提交</button>
    </form>
</div>
</body>
</html>
