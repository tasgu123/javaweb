<%--
  Created by IntelliJ IDEA.
  User: hx
  Date: 2023/11/6
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <base url="http://${header.host}${pageContext.request.contextPath}/admin/residents/">
    <title>添加信息</title>
</head>
<body>
<c:if test="${empty admin}">
    <c:redirect url="http://${header.host}${pageContext.request.contextPath}/admin/login.jsp"/>
</c:if>
<h1>住户信息后台管理</h1>
<div>
    <a href="../home.jsp">前台首页</a>
    <a href="list">住户信息列表</a>
    <a href="../adminUsers/list">管理员列表</a>
    <a href="../adminUsers/add.jsp">添加管理员</a>
    <a href="../serviceInformation/list">维修信息列表</a>
    <a href="../systemBulletin/list">系统公告列表</a>
    <a href="../systemBulletin/add.jsp">添加系统公告</a>
    <a href="../adminUsers/reset?id=${admin.id}">重置密码</a>
    <a href="../logout">退出</a>
</div>
<form action="./add" method="post" >
    id:<input type="text" name="residentId" ><br>
    姓名 :<input type="text" name="name"><br>
    性别 :<input type="text" name="gender" ><br>
    电话 :<input type="text" name="telephone" ><br>
    楼号 :<input type="text" name="buildingNo" ><br>
    门牌号 :<input type="text" name="houseNumber" ><br>
    <button type="submit">提 交</button>
    <button type="reset">重 置</button>
    </div>
</form>
</body>
</html>
