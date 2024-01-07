<%@ page import="model.ServiceInformation" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hx
  Date: 2023/11/20
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <base href="http://${header.host}${pageContext.request.contextPath}/admin/serviceInformation/">
    <title>维修信息统计</title>
</head>
<body>
<c:if test="${empty admin}">
    <c:redirect url="http://${header.host}${pageContext.request.contextPath}/admin/login.jsp"/>
</c:if>
<h1>维修信息统计</h1>
<div>
    <a href="../home.jsp">前台首页</a>
    <a href="../residents/list">住户信息列表</a>
    <a href="../residents/add.jsp">添加住户信息</a>
    <a href="../adminUsers/list">管理员列表</a>
    <a href="../adminUsers/add.jsp">添加管理员</a>
    <a href="../systemBulletin/list">系统公告列表</a>
    <a href="../systemBulletin/add.jsp">添加系统公告</a>
    <a href="../adminUsers/reset?id=${admin.id}">重置密码</a>
    <a href="../logout">退出</a>
</div>
<hr>
<form action="query" method="post">
    维修信息id
    ：<input type="text" name="id">
    维修信息名称
    ：<input type="text" name="name">
    <button type="submit">查 询</button>
</form>
<table>
    <caption>维修信息列表</caption>
    <tr>
        <td>维修信息id</td>
        <td>维修信息名称</td>
        <td>维修信息提交日期</td>
        <td>维修信息提交人</td>
        <td>操作</td>
    </tr>
    <%
        List<ServiceInformation> res = (List<ServiceInformation>) request.getAttribute("serviceInformation");
        for (ServiceInformation serviceInformation : res) {
            out.print("<tr>");
    %>
    <td>
        <%=serviceInformation.getServiceId()%>
    </td>
    <td>
        <%=serviceInformation.getServiceName()%>
    </td>
    <td>
        <%=serviceInformation.getServiceDate()%>
    </td>
    <td>
        <%=serviceInformation.getResidentName()%>
    </td>
    <td>
        <a href="del?id=<%=serviceInformation.getServiceId()%>">已维修，删除</a>
    </td>
    <%
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
