<%--
  Created by IntelliJ IDEA.
  User: Varsha
  Date: 28-04-2020
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success Page</title>
</head>
<body>
<h1>hii <%=request.getAttribute("user") %>,Login Successful </h1>
<a href="login.html">Login page</a>
</body>
</html>
