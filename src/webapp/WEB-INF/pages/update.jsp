<%--
  Created by IntelliJ IDEA.
  User: usupov
  Date: 25.04.2020
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>UserUpdate</title>
<body>
<form action="/admin/update" method="post">
    <input hidden name="id" value=${user.id}>

    <p><label>Email</label>
    <p><input name="email" value=${user.email}>

    <p><label>Name</label>
    <p><input name="name" value=${user.name}>

    <p><label>Password</label>
    <p><input name="pass" value=${user.pass}>

    <p>
        <button name="user" value=${user}>
            Update user
        </button>
</form>
<p>


</body>
</html>
