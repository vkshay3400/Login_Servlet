<%--
  Created by IntelliJ IDEA.
  User: akshay
  Date: 25/04/20
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Login Success Page</title>
</head>
<body>
<h6>Hi <%= request.getAttribute("user")%> , Login Successful.</h6>
<a href="Login.html">Login Page</a>
</body>
</html>
