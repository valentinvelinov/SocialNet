<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%--<%@ page session="false" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
</head>
<body>
	<c:if test="${empty sessionScope.user.email}">
		<c:redirect url="index" />
	</c:if>
	<c:out value="${sessionScope.user.email}" />
	<c:out value="${sessionScope.user.userId}" />
	<c:out value="${sessionScope.user.firstName}" />
	<h1>Welcome here!</h1>
	<form:form action="logout" method="post">
		<button type="submit">Click Me!</button>
	</form:form>

	<form:form action="testing" method="get">
	<<button type="submit2">Click Me!</button>
	</form:form>
</body>
</html>