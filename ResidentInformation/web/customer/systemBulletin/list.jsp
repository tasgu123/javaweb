<%@ page import="model.SystemBulletin" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hx
  Date: 2023/11/20
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <base href="http://${header.host}${pageContext.request.contextPath}/customer/systemBulletin/">
    <title>系统公告</title>
</head>
<body>
<c:if test="${empty customer}">
    <c:redirect url="http://${header.host}${pageContext.request.contextPath}/customer/login.jsp"/>
</c:if>
你好，${customer.username}
<a href="../modPre?id=${customer.residentId}">修改账户信息</a>
<hr>
<h1>系统公告</h1>
<div>
    <a href="../home.jsp">前台首页</a>
    <a href="../Info/list">个人信息</a>
    <a href="../serviceInformation/add.jsp">故障维修申请</a>
    <a href="../reset?id=${customer.residentId}">重置密码</a>
    <a href="../logout">退出登录</a>
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
    <%
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
