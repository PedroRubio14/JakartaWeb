<%--
  Created by IntelliJ IDEA.
  User: pedro
  Date: 12/11/25
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>${movie.name}</h1>
<p>ID: ${movie.id}</p>
<p>Descripción: ${movie.description}</p>

<form action="movie/delete" method="post">
    <input type="hidden" name="id" value="${movie.id}">
    <button type="submit">Eliminar</button>
</form>

<a href="${pageContext.request.contextPath}/movies">Volver a la lista</a>

</body>
</html>
