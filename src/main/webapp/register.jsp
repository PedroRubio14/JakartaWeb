<%--
  Created by IntelliJ IDEA.
  User: pedro
  Date: 19/11/25
  Time: 23:14
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
    <form action="register" method="POST">

        <label for="username">User</label>
        <input type="text" id="username" name="username">

        <label for="passwd">Password</label>
        <input type="password" id="passwd" name="password">

        <label for="firstName">Nombre</label>
        <input type="text" id="firstName" name="firstName">

        <label for="lastName">Apellido</label>
        <input type="text" id="lastName" name="lastName">

        <button type="submit">Save</button>

    </form>

    <a href="login">Ya tienes cuenta? inicia sesion.</a>
</main>




</body>
</html>
