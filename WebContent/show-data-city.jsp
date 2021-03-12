<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Insert city name</h1>
	<form action="city" method="GET">
		<input type="text" name="nameCity" /> <input type="submit"
			value="Show info city" />
	</form>
	<p>${city.id}- ${city.name} - ${city.countryCode} -
		${city.district} - ${city.population}</p>
</body>
</html>