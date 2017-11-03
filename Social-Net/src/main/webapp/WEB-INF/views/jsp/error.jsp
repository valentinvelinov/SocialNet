<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
</head>
<body>
	<h1>Error PAGE!</h1>
	<c:out value="${errorMSG}" />
	<p>Please log your self!</p>
	<img src="img/ErrorPhoto.jpg">
	
	<form method="get" action="index">
    <button type="Submit">Back to login page!</button>
</form>
</body>
</html>