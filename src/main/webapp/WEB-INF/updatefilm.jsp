<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Update film</h2>

	<form action="UpdateFilm.do" method="POST">
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
	</select><br> <input type="submit" value="Update Film" />
	
	</form>
	
</body>
</html>