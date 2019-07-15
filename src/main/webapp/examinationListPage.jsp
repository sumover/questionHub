<%--

  Created by IntelliJ IDEA.
  author:sumover
  Date: 2019/7/15
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="main.Module.Examination" %>
<%@ page import="java.util.List" %>
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
        String beginTime = Examination.parseFromDate(examinationList.get(i).getBeginTime());
        String endTime = Examination.parseFromDate(examinationList.get(i).getEndTime());
        String name = examinationList.get(i).getExaminationPaper().getName();
        int eid = examinationList.get(i).getId();
%>
<table>
    <tr>
        <td>
            <a href="examination?eid=${eid}">${name}</a>
        </td>
        <td>
            ${beginTime}
        </td>
        <td>
            ${endTIme}
        </td>
    </tr>
</table>
<%
    }
%>
</body>
</html>
