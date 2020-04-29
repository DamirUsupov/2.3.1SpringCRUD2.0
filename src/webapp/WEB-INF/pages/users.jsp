<%--
  Created by IntelliJ IDEA.
  User: usupov
  Date: 25.04.2020
  Time: 1:36
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>

<html>
<head>
    <title>Users</title>
    <style type="text/css">
        .formSize {
            height: 5px;
            width: 90px;
        }

        #left {
            position: absolute;
            left: 0;
            top: 0;
            width: 10%;
        }

        #right {
            position: absolute;
            right: 0;
            top: 0;
            width: 90%;
        }

        p {
            padding-left: 10px;
        }

        button {
            width: 90px;
        }

    </style>
</head>
<body>

<div id="left">

    <form action="/admin/users" method="post" name="1">
        <p><label>Email</label></p>
        <p><input name="email"></p>
        <p><label>Name</label></p>
        <p><input name="name"></p>
        <p><label>Password</label></p>
        <p><input name="pass"></p>


        <p>
            <button>
                Register
            </button>

    </form>

    <form action="/logout">
        <p> <button>Exit</button>
    </form>

</div>

<div id="right">

    <p><label>UsersTable</label></p>
    <p>
    <table border='1'>
        <tr>
            <td>Id</td>
            <td>Email</td>
            <td>Name</td>
            <td>Pass</td>
            <td></td>
            <td></td>
        </tr>
        <c:forEach var="user" items="${users}" varStatus="st">

            <tr>

                <td> ${user.id} </td>
                <td> ${user.email} </td>
                <td> ${user.name} </td>
                <td> ${user.pass} </td>

                <td>
                    <form class="formSize" method="post" action="/admin/delete">
                        <button name="id" value=${user.id}>Delete user</button>
                    </form>

                </td>
                <td>

                    <form class="formSize" method="get" action="/admin/update">
                        <button name="id" value=${user.id}>Update user</button>
                    </form>

                </td>

            </tr>
        </c:forEach>
    </table>


</div>

</body>

</html>

