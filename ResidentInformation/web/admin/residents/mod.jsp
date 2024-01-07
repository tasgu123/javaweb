<%@ page import="model.Resident" %>
<%@ page import="model.Resident" %><%--
  Created by IntelliJ IDEA.
  User: hx
  Date: 2023/11/5
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <base url="http://${header.host}${pageContext.request.contextPath}/admin/residents/">
    <title>修改住户信息</title>
</head>
<body>
<c:if test="${empty admin}">
    <c:redirect url="http://${header.host}${pageContext.request.contextPath}/admin/login.jsp"/>
</c:if>
<div>
    <h1>住户信息后台管理平台</h1>
    <a href="../home.jsp">前台首页</a>
    <a href="list">住户信息列表</a>
    <a href="add.jsp">添加住户信息</a>
    <a href="../adminUsers/list">管理员列表</a>
    <a href="../adminUsers/add.jsp">添加管理员</a>
    <a href="../serviceInformation/list">维修信息列表</a>
    <a href="../systemBulletin/list">系统公告列表</a>
    <a href="../systemBulletin/add.jsp">添加系统公告</a>
    <a href="../adminUsers/reset?id=${admin.id}">重置密码</a>
    <a href="../logout">退出</a>
</div>
<hr>
<h2> 住户信息管理 - 修改信息</h2>
<%Resident resident = (Resident) request.getAttribute("residents");%>
<form action="./upt" method="post">
    账号:<input type="text" name="id" readonly value="<%=resident.getResidentId() %>"><br>
    姓名 :<input type="text" name="name" value="<%=resident.getName() %>"><br>
    性别 :<input type="text" name="gender" value="<%=resident.getGender() %>"><br>
    电话 :<input type="text" name="telephone" value="<%=resident.getTelephone() %>"><br>
    楼号 :<input type="text" name="buildingNo" value="<%=resident.getBuildingNo() %>"><br>
    门牌号 :<input type="text" name="houseNumber" value="<%=resident.getHouseNumber() %>"><br>
    <button type="submit">提 交</button>
</form>
</body>
</html>
