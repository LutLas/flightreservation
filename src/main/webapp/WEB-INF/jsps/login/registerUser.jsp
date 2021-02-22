<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
<h3>Sign Up</h3>
<form action="registerUser" method="post">
<pre>
First Name: <input type="text" name="firstName" value="${firstName}"/>
Last Name: <input type="text" name="lastName" value="${lastName}"/>
Email Address: <input type="email" name="email" value="${email}"/><font color="red">${emailError}</font> 
Password: <input type="password" name="password" value="${password}"/><font color="red">${passwordError}</font> 
Confirm Password: <input type="password" name="confirmPassword" value="${confirmPassword}"/><font color="red">${passwordMissedError}</font> 
<input type="submit" value="Register"/>
</pre>
</form>
<font color="red">${error}</font> 
</body>
</html>