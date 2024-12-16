<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Films Found With Keyword</title>
</head>
<body>

	<c:choose>

		<c:when test="${! empty films}">
			<c:forEach var="film" items="${films}">
				<h2>Title: ${film.filmTitle}</h2>
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
			
				<h4>Cast in film</h4>
			<c:forEach var="actor" items="${film.actors}">
				<li><strong>${actor.firstName} ${actor.lastName}</strong> (Actor Id: ${actor.actorId})</li>
				
			</c:forEach>
		</c:forEach>
		</c:when>
				
		
		<c:when test="${! empty SearchFailed }">
			<p>No films found.</p>
		</c:when>

		<c:otherwise>
			<p>Invalid entry. Film was not updated</p>
		</c:otherwise>

	</c:choose>
</body>
</html>