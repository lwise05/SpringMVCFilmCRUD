<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC Film Site</title>
</head>
<body>

<h1>Welcome to our Film Site</h1>

<form action="GetFilmById.do" method = "GET">
Film id:
<input type = "text" name = "filmId"/>
<input type= "submit" value = "Get Film Data"/>

</form>
<div>
<c:choose>
<c:when test="${! empty film}">
<h1>${film.filmTitle}</h1>
</c:when>


</c:choose>




</div>


</body>
</html>
