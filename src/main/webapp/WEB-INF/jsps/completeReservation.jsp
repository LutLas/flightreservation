<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Reservation</title>
</head>
<body>
<h3>Complete Reservation</h3>
Airline: ${flight.operatingAirlines}<br/>
Departure City: ${flight.departureCity}<br/>
Arrival City: ${flight.arrivalCity}<br/>

<form action="completeReservation" method="post">
<pre>
<h3>Passenger Details</h3>
First Name:<input type="text" name="passengerFirstName"/>
Last Name:<input type="text" name="passengerLastName"/>
Email:<input type="email" name="passengerEmail"/>
Phone:<input type="number" name="passengerPhone"/>

<h3>Card Details</h3>
Name on the Card: <input type="text" name="nameOnTheCard"/>
Card No: <input type="text" name="cardNumber"/>
Expiry Date: <input type="text" name="expirationDate"/>
Three Digit Security Code <input type="text" name="securityCode"/>

<input type="hidden" name="flightId" value="${flight.id}"/>
<input type="submit" value="confirm"/>
</pre>
</form>
</body>
</html>