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
	<h1>Insert city name</h1>
	<form action="city" method="GET">
		<input type="text" name="nameCity" /> <input type="submit"
			value="Show info city" />
	</form>
	<p>${city.id}-${city.name}-${city.countryCode} - ${city.district} -
		${city.population}</p>
	<ul>
		<c:forEach items="${cityList}" var="city">
			<li><a href="/esercizioMVC-JDBC/city?nameCity=${city.name}">${city.name}</a></li>
		</c:forEach>
	</ul>

</body>
</html>