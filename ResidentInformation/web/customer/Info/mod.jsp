<%--
  Created by IntelliJ IDEA.
  User: hx
  Date: 2023/11/13
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <base url="http://${header.host}${pageContext.request.contextPath}/customer/Info">
    <title>修改个人信息</title>
</head>
<body>
<c:if test="${empty customer}">
    <c:redirect url="http://${header.host}${pageContext.request.contextPath}/customer/login.jsp"/>
</c:if>
你好，${customer.username}
<a href="../modPre?id=${customer.residentId}">修改账户信息</a>
<hr>
<h2> 住户信息管理 - 修改信息</h2>
<a href="../home.jsp">前台首页</a>
<a href="list">个人信息</a>
<a href="../serviceInformation/add.jsp">故障维修申请</a>
<a href="../systemBulletin/list">系统公告列表</a>
<a href="../reset?id=${customer.residentId}">重置密码</a>
<a href="../logout">退出登录</a>
<form action="mod" method="post" >
    账号:<input type="text" name="id" readonly value="${oldResident.residentId}"><br>
    姓名 :<input type="text" name="name" value="${oldResident.name}"><br>
    性别 :<input type="text" name="gender" value="${oldResident.gender}"><br>
    电话 :<input type="text" name="telephone" value="${oldResident.telephone}"><br>
    楼号 :<input type="text" name="buildingNo" value="${oldResident.buildingNo}"><br>
    门牌号 :<input type="text" name="houseNumber" value="${oldResident.houseNumber}"><br>
    <button type="submit">提 交</button>
</form>
</body>
</html>
