<%--
  Created by IntelliJ IDEA.
  User: usupov
  Date: 29.04.2020
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input hidden name="id" value=${user}>

<form method="get" action="/logout">

    <p><label>Id: ${user.id}</label>

    <p><label>Email: ${user.email}</label>

    <p><label>Name: ${user.name}</label>

    <p><label>Password: ${user.pass}</label>

    <p>

        <button> Exit</button>
</form>
</body>

</html>
