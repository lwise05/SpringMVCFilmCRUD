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
				
			</c:when>
			<c:when test="${! empty SearchFailed }">
				<p>No film found.</p>
			</c:when>
			
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		
		<form action="UpdateFilm.do" method="POST">
	<c:choose>
	<c:when test="${! empty film}">
	<input type="hidden" value="${film.filmId}" name="filmId">
	<label for="filmTitle">Film Title: </label> 
	<input type="text" name="filmTitle" value="${film.filmTitle}"> <br>
	<label for="filmDesc">Film Description: </label> <br>
	<input type="text" name="filmDesc" value="${film.filmDesc}"><br>
	<label for="releaseYear">Release Year: </label>
	<input type="text" name="releaseYear" value="${film.releaseYear}"> <br> 
	<label for="langId">Language Id: </label> 
	<select name="langId" id="langId">
		<option value="1">1: English</option>
		<option value="2">2: Italian</option>
		<option value="3">3: Japanese</option>
		<option value="4">4: Mandarin</option>
		<option value="5">5: French</option>
		<option value="6">6: German</option>
	</select> <br> 
	<label for="rentDur">Rental Duration: </label> 
	<input type="text" name="rentDur" value="${film.rentDur}"> <br> 
	<label for="rentRate">Rental Rate: </label> 
	<input type="text" name="rentRate" value="${film.rentRate}"> <br> 
	<label for="filmLength">Film Length: </label> 
	<input type="text" name="filmLength" value="${film.filmLength}"> <br> 
	<label for="replCost">Replacement Cost: </label> 
	<input type="text" name="replCost" value="${film.replCost}"> <br> 
	<label for="filmRating">Film Rating: </label> 
	<select name="filmRating" id="filmRating">
		<option value="G">G</option>
		<option value="PG">PG</option>
		<option value="PG13">PG13</option>
		<option value="NC17">NC17</option>
		<option value="R">R</option>
	</select><br> 
	<input type="submit" value="Update Film" />
	</c:when>
	</c:choose>
	</form>
	</div>
</body>
</html>