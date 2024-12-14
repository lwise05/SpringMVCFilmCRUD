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
				<h3>${film.filmReleaseYear}</h3>
				<h3>${film.filmLangId}</h3>
				<h3>${film.filmLanguageName}</h3>
				<h3>${film.filmRentDur}</h3>
				<h3>${film.filmRentRate}</h3>
				<h3>${film.filmFilmLength}</h3>
				<h3>${film.filmReplCost}</h3>
				<h3>${film.filmFilmRating}</h3>
				<h3>${film.filmSpecFeat}</h3>
			</c:when>
			<c:otherwise>
				<p>No film found.</p>
			</c:otherwise>
		</c:choose>




	</div>


</body>
</html>
