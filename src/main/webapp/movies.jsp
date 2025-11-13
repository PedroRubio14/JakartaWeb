<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: lemr
  Date: 9/11/25
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
    <style>
        :root {
            --pico-font-size: 1rem;
        }
    </style>
</head>
<body>
<main class="container">
    <section>
        <hgroup>
            <h2>Movies</h2>
            <p>List of movies</p>
        </hgroup>
        <article>
            <table>
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Synopsis</th>
                    <th>Year</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${movies != null}">
                    <c:forEach var="movie" items="${movies}">
                        <tr>
                            <td>${movie.id}</td>
                            <td><a href="${pageContext.request.contextPath}/movies?id=${movie.id}">${movie.name}</a></td>
                            <td>${movie.description}</td>
                            <td>${movie.year}</td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${movies == null}">
                    <tr>
                        <td colspan="4">No movie found.</td>
                    </tr>
                </c:if>
                </tbody>
            </table>
        </article>
    </section>
    <br>
    <section>
        <hgroup>
            <h2>Add movie</h2>
            <p>Insert new movie</p>
        </hgroup>
        <article>
            <form action="movies" method="POST">
                <input type="hidden" name="__method" value="POST">
                <label> Movie title
                    <input type="text" name="name">
                </label>

                <label> Short synopsis
                    <textarea name="description"></textarea>
                </label>

                <label> year
                    <input type="number" name="year">
                </label>

                <button type="submit">Save</button>
            </form>
        </article>
    </section>
</main>
<footer class="container">
    <small>Pedro Rubio Rigo</small>
</footer>
</body>
</html>
