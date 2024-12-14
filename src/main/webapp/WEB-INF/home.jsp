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

</style>
<meta charset="UTF-8">
<title>MVC Film Site</title>
</head>
<body>

	<h1>Welcome to our Film Site</h1>

	<form action="GetFilmById.do" method="GET">
		Film id: <input type="text" name="filmId" /> <input type="submit"
			value="Get Film Data" />

	</form>
	<div>
		<c:choose>
			<c:when test="${! empty film}">
				<h3>Title: ${film.filmTitle}</h3>
				<h3>Description: ${film.filmDesc}</h3>
				<h3>Release Year: ${film.releaseYear}</h3>
				<h3>Language: ${film.languageName}</h3>
				<h3>Language ID: ${film.langId}</h3>
				<h3>Rental Duration: ${film.rentDur}</h3>
				<h3>Rental Rate: ${film.rentRate}</h3>
				<h3>Length: ${film.filmLength}</h3>
				<h3>Replacement Cost: ${film.replCost}</h3>
				<h3>Rating: ${film.filmRating}</h3>
				<h3>Special Features: ${film.specFeat}</h3>
			</c:when>
			<c:otherwise>
				<p>No film found.</p>
			</c:otherwise>
		</c:choose>
	</div>



</body>
</html>
