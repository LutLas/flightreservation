<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flights</title>
</head>
<body>
<h3>Find Flights</h3>
<form action="findFlights" method="post">
<pre>
To: <input type="text" name="to"/>
From: <input type="text" name="from"/>
Departure Date: <input type="text" name="departureDate"/>
<input type="submit" value="Search"/>
</pre>
</form>
</body>
</html>