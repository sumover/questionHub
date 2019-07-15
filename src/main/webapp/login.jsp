<%@ page import="main.Module.MessageBoard" %><%--
Created by IntelliJ IDEA
User : yuanyuan
Date : 2019/7.14
Time : 12:45
--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <link rel="stylesheet" href="CSS/loginCSS.css">
</head>
<body>
<div>
    <div class="messageBoardDiv">
        <fieldset>
            <table class="messageBoardTable">
                <tr>
                    <td>
                        考试信息
                    </td>
                    <td>
                        <a href="examinationList">more>>></a>
                    </td>
                </tr>
                <%
                    MessageBoard messageBoard = (MessageBoard) session.getAttribute("loginPageMessageBoard");
                    int length = messageBoard.getMessageNum();
                    for (int i = 0; i < length; ++i) {
                        String message = messageBoard.getMessageTextAt(i);
                        String url = messageBoard.getMessageUrlAt(i);
                %>
                <tr>
                    <td>
                        <a href="${url}">${message}</a>
                    </td>
                    <td>

                    </td>
                </tr>
                <%
                    }
                %>
            </table>
        </fieldset>
    </div>
    <div class="loginFormDiv">
        <form action="loginDispatcher" method="post">
            <fieldset>
                <table class="loginTable">
                    <tr>
                        <td>
                            <label for="loginFormUserNameText">
                                用户名:
                            </label>
                        </td>
                        <td>
                            <input type="text" id="loginFormUserNameText" name="loginFormUserNameText" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="loginFormPasswordText">
                                密码:
                            </label>
                        </td>
                        <td>
                            <input type="password" id="loginFormPasswordText" name="loginFormPasswordText" required>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td id="tdLoginSubmitButton">
                            <input type="submit" id="loginFormSubmitButton" name="loginFormSubmitButton"
                                   value="    登    录    ">
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>
</div>
<script type="text/javascript" src="JavaScript/loginJS.js" charset="UTF-8"/>
</body>
</html>