<%--
  Created by IntelliJ IDEA.
  User: hx
  Date: 2023/11/7
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <base url="http://${header.host}${pageContext.request.contextPath}/admin/adminUsers/">
    <title>管理员列表</title>
</head>
<body>
<c:if test="${empty admin}">
    <c:redirect url="http://${header.host}${pageContext.request.contextPath}/adminUsers/login.jsp"></c:redirect>
</c:if>
<div>
    <h1>住户信息后台管理</h1>
    <a href="../home.jsp">前台首页</a>
    <a href="../residents/list">用户信息列表</a>
    <a href="../residents/add.jsp">添加住户信息</a>
    <a href="add.jsp">添加管理员</a>
    <a href="../serviceInformation/list">维修信息列表</a>
    <a href="../systemBulletin/list">系统公告列表</a>
    <a href="../systemBulletin/add.jsp">添加系统公告</a>
    <a href="reset?id=${admin.id}">重置密码</a>
    <a href="../logout">退出</a>
</div>
<hr>
<h2>管理员用户列表</h2>
<form method="post" action="query">
    用户名：<input type="text" name="adminUsername">
    <button type="submit">查询</button>
</form>
<table>
    <tr>
        <td>id</td>
        <td>用户名</td>
        <td>创建时间</td>
        <td>最后一次访问时间</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${AdminUser}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>
                <jsp:useBean id="timestamp" class="java.util.Date"/>
                <jsp:setProperty name="timestamp" property="time" value="${user.createTime}"/>
                <fmt:formatDate value="${timestamp}" pattern="yyyy/MM/dd HH:mm:ss"/>
            </td>
            <td>
                <jsp:setProperty name="timestamp" property="time" value="${user.lastAccessTime}"/>
                <fmt:formatDate value="${timestamp}" pattern="yyyy/MM/dd HH:mm:ss"/>
            </td>
            <td>
                <a href="reset?id=${user.id }">重置密码</a>
                <a href="modPre?id=${user.id }">修改</a>
                <a href="del?id=${user.id }">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
