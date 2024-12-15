<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="main.css" rel="stylesheet" type="text/css"/>
<meta charset="UTF-8">
<title>MVC Film Site</title>
</head>

<h1>Welcome to our Film Site</h1>

<body>
	<form action="GetFilmById.do" method="GET">
		Film id: <input type="text" name="filmId" /> <input type="submit"
			value="Get Film Data" />
	</form>
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
	
	<form action="DeleteFilm.do" method="GET">
		Enter film id: <input type="text" name="filmId" /> 
		<input type="submit" value="Delete Film" />
	</form>	</div>

	<form action="CreateFilm.do" method="POST">
	<h1>Add a film to the database</h1>
		<label for="filmTitle">Film Title: </label>
		<input type="text" name="filmTitle">
		<br>
		<label for="filmDesc">Film Description: </label>
		<input type="text" name="filmDesc">
		<br>
		<label for="releaseYear">Release Year: </label>
		<input type="text" name="releaseYear">
		<br>
		<label for="langId">Language Id: </label>
		<select name="langId" id="langId">
			<option value="1">1: English</option>
			<option value="2">2: Italian</option>
			<option value="3">3: Japanese</option>
			<option value="4">4: Mandarin</option>
			<option value="5">5: French</option>
			<option value="6">6: German</option>
		</select>
		<br>
		<label for="rentDur">Rental Duration: </label>
		<input type="text" name="rentDur">
		<br>
		<label for="rentRate">Rental Rate: </label>
		<input type="text" name="rentRate">
		<br>
		<label for="filmLength">Film Length: </label>
		<input type="text" name="filmLength">
		<br>
		<label for="replCost">Replacement Cost: </label>
		<input type="text" name="replCost">
		<br>
		<label for="filmRating">Film Rating: </label>
		<select name="filmRating" id="filmRating">
			<option value="G">G</option>
			<option value="PG">PG</option>
			<option value="PG13">PG13</option>
			<option value="R">R</option>
			<option value="NC17">NC17</option>
		</select><br>
		<input type="submit" value= "Create Film"/>
	</form>


</body>
</html>
