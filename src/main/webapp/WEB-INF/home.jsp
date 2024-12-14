<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-color: #F0FFFF;
}

h1 {
	color: #2F4F4F;
	margin
	25px;
}

div {
	margin: 50px;
}
</style>
<meta charset="UTF-8">
<title>MVC Film Site</title>
</head>
<body>

	<h1>Welcome to our Film Site</h1>

	<form action="GetFilmById.do" method="GET">
		Film id: <input type="text" name="filmId" /> 
		<input type="submit" value="Get Film Data" />
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
			<option value="NC17">NC17</option>
			<option value="R">R</option>
		</select><br>
		<input type="submit" value= "Create Film"/>
	</form>

</body>
</html>
