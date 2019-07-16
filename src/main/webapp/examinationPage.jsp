<%@ page import="java.util.List" %>
<%@ page import="main.Module.*" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/7/16
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>考试</title>
    <meta charset="UTF-8">
</head>
<body>
<%
    Examination examination = (Examination) session.getAttribute("drewExamination");
    ExaminationPaper examinationPaper = examination.getExaminationPaper();
    String name = examinationPaper.getName();
%>
<h1 style="text-align: center"><%=name%>
</h1>
<div style="margin: 0 auto">
    <%String note = examinationPaper.getNote();%>
    <textarea cols="50" readonly><%=note%></textarea>
</div>
<div style="margin: 0 auto">
    <table>
        <% List<Question> questionList = examinationPaper.getQuestionList();
            for (int i = 0; i < questionList.size(); ++i) {
                MultipleChoice question = (MultipleChoice) questionList.get(i);%>
        <tr>
            <td colspan="4" style="text-align: left">
                <%=question.getId() + "." + question.getDescribe() + "(" + question.getScore() + " 分)"%>
            </td>
        </tr>
        <%
            for (Options options : question.getOptions()) {
        %>
        <tr>
            <td style="text-align: center">
                <%="" + options.c + "." + options.describe%>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</div>
</body>
</html>
