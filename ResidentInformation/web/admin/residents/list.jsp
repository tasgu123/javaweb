<%@ page import="model.Resident" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hx
  Date: 2023/11/4
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <base url="http://${header.host}${pageContext.request.contextPath}/admin/residents/">
    <title>住户信息列表</title>
    <link rel="stylesheet" href="../../css/resident_list.css">
</head>
<body>
<c:if test="${empty admin}">
    <c:redirect url="http://${header.host}${pageContext.request.contextPath}/admin/login.jsp"/>
</c:if>
<div>
    <h1>住户信息管理平台</h1>
</div>
<div>
    <a href="../home.jsp">前台首页</a>
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
<form action="./query" method="post">
    住户id
    ：<input type="text" name="id">
    姓名
    ：<input type="text" name="name">
    <button type="submit">查 询</button>
</form>
<table>
    <tr>
        <th style="width: 50px">帐号</th>
        <th style="width: 60px">姓名</th>
        <th style="width: 60px">性别</th>
        <th style="width: 60px">电话</th>
        <th style="width: 60px">楼号</th>
        <th style="width: 180px">门牌号</th>
    </tr>
    <%
        List<Resident> res = (List<Resident>) request.getAttribute("residents");
        for (Resident resident : res) {
            out.print("<tr>");
    %>
    <td><%=resident.getResidentId() %>
    </td>
    <td><%=resident.getName() %>
    </td>
    <td><%=resident.getGender() %>
    </td>
    <td><%=resident.getTelephone() %>
    </td>
    <td><%=resident.getBuildingNo() %>
    </td>
    <td><%=resident.getHouseNumber() %>
    </td>
    <td><a href="uptPro?id=<%=resident.getResidentId() %>">修改</a>
        <a href="del?id=<%=resident.getResidentId()%>">删除</a>
    </td>
    <%
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
