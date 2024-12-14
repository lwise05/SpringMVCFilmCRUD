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
				<h3>${film.filmTitle}</h3>
				<h3>${film.filmDesc}</h3>
				<h3>${film.releaseYear}</h3>
				<h3>${film.langId}</h3>
				<h3>${film.languageName}</h3>
				<h3>${film.rentDur}</h3>
				<h3>${film.rentRate}</h3>
				<h3>${film.filmLength}</h3>
				<h3>${film.replCost}</h3>
				<h3>${film.filmRating}</h3>
				<h3>${film.specFeat}</h3>
			</c:when>
			<c:otherwise>
				<p>No film found.</p>
			</c:otherwise>
		</c:choose>
	</div>



</body>
</html>
