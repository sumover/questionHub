<%--

  Created by IntelliJ IDEA.
  author:sumover
  Date: 2019/7/15
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="main.Module.Examination" %>
<%@ page import="java.util.List" %>
<%@ page import="main.Module.ExaminationPaper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>考试列表</title>
</head>
<body>
这里要放在当前日期之后的所有的考试
<%
    List<Examination> examinationList = (List<Examination>) session.getAttribute("examinationList");
    for (int i = 0; i < examinationList.size(); ++i) {
        Examination examination = examinationList.get(i);
        ExaminationPaper examinationPaper = examination.getExaminationPaper();
%>
<table>
    <tr>
        <td>
            <a href="examination?eid=<%=examination.getId()%>"><%=examinationPaper.getName()%>></a>
        </td>
        <td>
            <%=examination.getBeginTime()%>
        </td>
        <td>
            <%=examination.getEndTime()%>
        </td>
    </tr>
</table>

<%}%>
</body>
</html>
