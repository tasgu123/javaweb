<%@ page import="model.SystemBulletin" %>
<%@ page import="java.util.List" %><%--
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
    <title>系统公告</title>
</head>
<body>
<c:if test="${empty admin}">
    <c:redirect url="http://${header.host}${pageContext.request.contextPath}/admin/login.jsp"/>
</c:if>
<h1>系统公告</h1>
<div>
    <a href="../home.jsp">前台首页</a>
    <a href="../residents/list">住户信息列表</a>
    <a href="../residents/add.jsp">添加住户信息</a>
    <a href="../adminUsers/list">管理员列表</a>
    <a href="../adminUsers/add.jsp">添加管理员</a>
    <a href="../serviceInformation/list">维修信息列表</a>
    <a href="add.jsp">添加系统公告</a>
    <a href="../adminUsers/reset?id=${admin.id}">重置密码</a>
    <a href="../logout">退出</a>
</div>
<hr>
<form action="query" method="post">
    系统公告id
    ：<input type="text" name="id">
    系统公告 名称
    ：<input type="text" name="name">
    <button type="submit">查 询</button>
</form>
<table>
    <caption>系统公告列表</caption>
    <tr>
        <td>系统公告id</td>
        <td>系统公告名称</td>
        <td>系统公告发布日期</td>
        <td>系统公告发布人</td>
        <td>操作</td>
    </tr>
    <%
        List<SystemBulletin> res = (List<SystemBulletin>) request.getAttribute("systemBulletin");
        for (SystemBulletin systemBulletin : res) {
            out.print("<tr>");
    %>
    <td>
        <%=systemBulletin.getSystemId()%>
    </td>
    <td>
        <a href="../../notice/notice<%=systemBulletin.getSystemId()%>.jsp">
            <%=systemBulletin.getSystemName()%>
        </a>
    </td>
    <td>
        <%=systemBulletin.getSystemDate()%>
    </td>
    <td>
        <%=systemBulletin.getAdminUserName()%>
    </td>
    <td>
        <a href="del?id=<%=systemBulletin.getSystemId()%>">删除</a>
        <a href="modPre?id=<%=systemBulletin.getSystemId()%>">修改</a>
    </td>
    <%
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
