<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/7/15
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎,${sessionScope.loginUser.name}</title>
</head>
<body>
<p>

</p>
<table>
    <tr>
        <td>
            <a href="">考试布置</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="">习题布置</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="">学生信息管理</a>
        </td>
    </tr>
</table>
</body>
</html>