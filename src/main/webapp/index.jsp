<%@ page contentType="text;html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <head>
        <meta charset="UTF-8"/>
    </head>
    <body>
        <%
            response.encodeRedirectURL("UTF-8");
            response.sendRedirect("login");
        %>

    </body>
</html>

