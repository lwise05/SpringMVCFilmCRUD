<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie Result</title>
</head>
<body>
	<div>
		<c:choose>
			<c:when test="${! empty film}">
				<h4>Title: ${film.filmTitle}</h4>
				<li>Film Id: ${film.filmId}</li>
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
				<li>Actors from film:</li>
				<ul>
					<c:forEach var="actor" items="${film.actors}">
						<li><strong>${actor.firstName} ${actor.lastName}</strong></li>
						<li>Actor ID: ${actor.actorId}</li>
					</c:forEach>
				</ul>
				<a href="UpdateFilm.do">Update film</a>
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