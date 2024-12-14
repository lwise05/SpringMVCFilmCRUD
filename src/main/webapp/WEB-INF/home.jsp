<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {background-color: #F0FFFF;}
h1 {color: #2F4F4F; margin 25px;}
div {margin: 50px;}
li {}
</style>
<meta charset="UTF-8">
<title>MVC Film Site</title>
</head>

	<h1>Welcome to our Film Site</h1>

<body>
	<form action="GetFilmById.do" method="GET">
		Film id: <input type="text" name="filmId" /> 
				 <input type="submit" value="Get Film Data" />

	</form>
	<div>
		<c:choose>
			<c:when test="${! empty film}">
				<li>Title: ${film.filmTitle}</li>
				<li>Description: ${film.filmDesc}</li>
				<li>Release Year: ${film.releaseYear}</li>
				<li>Language: ${film.languageName}</li>
				<li>Language ID: ${film.langId}</li>
				<li>Rental Duration: ${film.rentDur}</li>
				<li>Rental Rate: ${film.rentRate}</li>
				<li>Length: ${film.filmLength}</li>
				<li>Replacement Cost: ${film.replCost}</li>
				<li>Rating: ${film.filmRating}</li>
				<li>Special Features: ${film.specFeat}</li>
				<li>Actors from film: </li>
				<ul>
				<c:forEach var="actor" items="${film.actors}">
				<li>${actor.firstName} ${actor.lastName}</li>
				<li>Actor ID: ${actor.actorId}</li></c:forEach>
				</ul>
			</c:when>
			  <c:when test="${! empty SearchFailed }">
				<p>No film found.</p>
			  </c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>
