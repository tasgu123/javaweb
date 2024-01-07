<%--
  Created by IntelliJ IDEA.
  User: hx
  Date: 2023/11/19
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <base url="http://${header.host}${pageContext.request.contextPath}/customer/">
    <title>修改账户信息</title>
</head>
<body>
<c:if test="${empty customer}">
    <c:redirect url="http://${header.host}${pageContext.request.contextPath}/customer/login.jsp"></c:redirect>
</c:if>
<h2>修改账号信息</h2>
<form action="mod" method="post">
    id <input type="text" name="id" readonly value="${oldCustomer.residentId}">
    用户名 <input type="text" name="username" value="${oldCustomer.username}">
    <input type="text" name="createTime" value="${oldCustomer.createTime}" hidden="hidden">
    <input type="text" name="lastAccessTime" value="${oldCustomer.lastAccessTime}" hidden="hidden">
    <button type="submit">提交</button>
</form>
</body>
</html>
