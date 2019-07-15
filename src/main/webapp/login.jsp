<%--
  Created by IntelliJ IDEA.
  User: yuanyuan
  Date: 2019/7/14
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="CSS/loginCSS.css">
</head>
<body>
<div>
    <div class="loginFormDiv">
        <form action="loginDispatcher" method="post">
            <fieldset>
                <table class="loginTable">
                    <tr>
                        <td>
                            <label for="loginFormUserNameText">用户名:</label>
                        </td>
                        <td>
                            <input type="text" id="loginFormUserNameText" name="loginFormUserNameText" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="loginFormPasswordText">密码:</label>
                        </td>
                        <td>
                            <input type="password" id="loginFormPasswordText" name="loginFormPasswordText"
                                   required>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td id="tdLoginSubmitButton">
                            <input type="submit" id="loginFormSubmitButton" name="loginFormSubmitButton"
                                   value="     登    录     ">
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>
</div>
<script type="text/javascript" src="JavaScript/loginJS.js"></script>
</body>
</html>
