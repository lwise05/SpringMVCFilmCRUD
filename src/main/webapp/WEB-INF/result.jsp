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
				<li>Category:${film.categories}</li>
				
				<h4>Cast in film</h4>
				<c:if test="${empty film.actors}">
					<p>No cast in film</p>
					</c:if>
					<c:forEach var="actor" items="${film.actors}">
						<li><strong>${actor.firstName} ${actor.lastName}</strong> (Actor Id: ${actor.actorId})</li>
					</c:forEach>
					
			</c:when>
			<c:when test="${! empty SearchFailed }">
				<p>No film found.</p>
			</c:when>

		<%-- 	<c:when test="${empty film }">
				<p>No film was found with that id.</p>
			</c:when> --%>
			
		</c:choose>
	</div>


	<form action="UpdateFilm.do" method="POST">
		<c:choose>

			<c:when test="${film.filmId > 1000}">
				<input type="hidden" value="${film.filmId}" name="filmId">
	
	Title: <input type="text" name="filmTitle" value="${film.filmTitle}"
					required>
				<br>
	Description: <input type="text" name="filmDesc"
					value="${film.filmDesc}" required>
				<br>
	Release Year:<input type="text" name="releaseYear"
					value="${film.releaseYear}" required>
				<br> 
	Language Id: <select name="langId" id="langId">
					<option value="1">1: English</option>
					<option value="2">2: Italian</option>
					<option value="3">3: Japanese</option>
					<option value="4">4: Mandarin</option>
					<option value="5">5: French</option>
					<option value="6">6: German</option>
				</select>
				<br> 
	Rental Duration: <input type="number" name="rentDur"
					value="${film.rentDur}" MIN="0" MAX="250" required>
				<br> 
	Rental Rate: <input type="text" name="rentRate"
					value="${film.rentRate}" required>
				<br> 
	Film length: <input type="text" name="filmLength"
					value="${film.filmLength}" required> minutes <br> 
	Replacement Cost: $<input type="text" name="replCost"
					value="${film.replCost}" required>
				<br> 
	Film Rating: <select name="filmRating" id="filmRating">
					<option value="G">G</option>
					<option value="PG">PG</option>
					<option value="PG13">PG13</option>
					<option value="NC17">NC17</option>
					<option value="R">R</option>
				</select>
				<br>
				<input type="submit" value="Update Film" />
			</c:when>



		</c:choose>
	</form>
	</div>

<a href="home.do">Return to home page</a>
</body>
</html>