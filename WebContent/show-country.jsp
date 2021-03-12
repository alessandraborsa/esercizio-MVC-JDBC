<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Insert country and continent</h1>
	<form action="country" method="GET">
		<label>country: <input type="text" name="nameCountry" />
		</label> <label>continent: <input type="text" name="nameContinent" /></label>
		<input type="submit" value="Submit" />
	</form>
	<p>${country.code}-${country.name} - ${country.continent} -
		${country.surfaceArea} - ${country.population}</p>

	<h1>Countries list</h1>
	<form action="list-countries" method="GET">
		<label>Insert continent:</label> <input type="text"
			name="nameContinent" /> <input type="submit" value="submit" />
	</form>
	<ul>
		<c:forEach items="${countryList}" var="country">
			<li>${country.name}</li>
		</c:forEach>
	</ul>
</body>
</html>