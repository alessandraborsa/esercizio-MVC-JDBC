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

	<h5>Logged User: ${logged_user}</h5>
	<a href="/esercizioMVC-JDBC/logout">LOGOUT</a>
	<h1>Insert country and continent</h1>
	<ul>
		<c:forEach items="${continents}" var="continent">
			<li><a
				href="/esercizioMVC-JDBC/country?nameContinent=${continent}">${continent}</a></li>
		</c:forEach>
	</ul>
	<form action="country" method="GET">
		<label>country: <input type="text" name="nameCountry" />
		</label> <label>continent: <input type="text" name="nameContinent" /></label>
		<input type="submit" value="Submit" />
	</form>

	<p></p>

	<ul>
		<c:forEach items="${countryList}" var="country">
			<li><a href="/esercizioMVC-JDBC/citylist?code=${country.code}">${country.name}</a>
				Population: ${country.population} Cod: ${country.code} Continent:
				${country.continent} Area: ${country.surfaceArea}</li>
		</c:forEach>
	</ul>
	

</body>
</html>