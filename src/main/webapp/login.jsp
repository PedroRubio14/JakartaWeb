<%--
  Created by IntelliJ IDEA.
  User: pedro
  Date: 19/11/25
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
    <style>
        :root {
            --pico-font-size: 1rem;
        }
    </style>
</head>
<body>
<main class="container">
    <form action="login" method="POST">
        <input type="hidden" name="__method" value="POST">

        <label for="username">User</label>
        <input type="text" id="username" name="username">

        <label for="passwd">Password</label>
        <input type="password" id="passwd" name="password">

        <button type="submit">Save</button>

    </form>

    <a href="register">No tines cuenta? Registrate</a>
</main>




</body>
</html>
