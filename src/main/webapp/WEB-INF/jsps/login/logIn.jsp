<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h3>Log-In</h3>
<form action="login" method="post">
<pre>
Email: <input type="email" name="email" value="${email}"/><font color="red">${emailLoginError}</font> 
Password: <input type="password" name="password"/><font color="red">${passwordLoginError}</font> 
<input type="submit" name="Log In"/>
</pre>
</form>
<font color="red">${error}</font> 

</body>
</html>