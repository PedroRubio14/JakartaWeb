<%--
  Created by IntelliJ IDEA.
  User: pedro
  Date: 12/11/25
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form action="movies" method="POST">
    <input type="hidden" name="id" value="${movie.id}">
    <input type="hidden" name="__method" value="PUT">
    <label> Movie title
        <input type="text" name="name" value="${movie.name}">
    </label>

    <label> Short synopsis
        <textarea name="description">${movie.description}</textarea>
    </label>

    <label> year
        <input type="number" name="year" value="${movie.year}">
    </label>

    <button type="submit">Update</button>
</form>
<form action="movies" method="POST">
    <input type="hidden" name="__method" value="DELETE">
    <input type="hidden" name="id" value="${movie.id}">
    <button type="submit">Eliminar</button>
</form>


<section class="comments-section">
    <h2>Comments (${comments.size()})</h2>

    <c:choose>
        <c:when test="${not empty comments}">
            <div class="comments-list">
                <c:forEach var="comment" items="${comments}">
                    <div class="comment-item">
                        <p><strong>Comment:</strong> ${comment.comment_text}</p>
                        <small>
                            <strong>Posted:</strong>
                            <c:choose>
                                <c:when test="${not empty comment.created_at}">
                                    ${comment.created_at}
                                </c:when>
                                <c:otherwise>
                                    No date available
                                </c:otherwise>
                            </c:choose>
                        </small>
                    </div>
                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
            <article>
                <p>No comments found for this movie.</p>
            </article>
        </c:otherwise>
    </c:choose>
</section>



<a href="${pageContext.request.contextPath}/movies">Volver a la lista</a>

</body>
</html>
