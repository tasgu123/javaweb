<%@ page import="model.Customer" %>
<%@ page import="model.Resident" %><%--
  Created by IntelliJ IDEA.
  User: hx
  Date: 2023/11/13
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <base href="http://${header.host}${pageContext.request.contextPath}/customer/Info/">
    <title>个人信息列表</title>
</head>
<body>
<c:if test="${empty customer}">
    <c:redirect url="http://${header.host}${pageContext.request.contextPath}/customer/login.jsp"/>
</c:if>
你好，${customer.username}
<a href="../modPre?id=${customer.residentId}">修改账户信息</a>
<hr>
<a href="../home.jsp">前台首页</a>
<a href="../serviceInformation/add.jsp">故障维修申请</a>
<a href="../systemBulletin/list">系统公告列表</a>
<a href="../reset?id=${customer.residentId}">重置密码</a>
<a href="../logout">退出登录</a>
<table>
    <caption>个人信息列表</caption>
    <tr>
        <th style="width: 50px">帐号</th>
        <th style="width: 60px">姓名</th>
        <th style="width: 60px">性别</th>
        <th style="width: 60px">电话</th>
        <th style="width: 60px">楼号</th>
        <th style="width: 180px">门牌号</th>
        <th style="width: 180px">操作</th>
    </tr>
    <tr>
    <td>${resident.residentId}
    </td>
    <td>${resident.name}
    </td>
    <td>${resident.gender}
    </td>
    <td>${resident.telephone}
    </td>
    <td>${resident.buildingNo}
    </td>
    <td>${resident.houseNumber}
    </td>
    <td><a href="modPre?id=${resident.residentId}">修改</a>
    </td>
    </tr>
</table>
</body>
</html>
