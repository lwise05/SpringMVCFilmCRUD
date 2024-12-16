<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	</form>	</div>
	<h3>You deleted the film titled: ${film.filmTitle} (${film.filmId})</h3>
	<form action="DeleteFilm.do" method="POST">
		Delete film by film id: 
		<input type="text" name="filmId" /> 
		<input type="submit" value="Delete Film" /><br>
	<a href="home.do">Return to home page</a>
</body>
</html>