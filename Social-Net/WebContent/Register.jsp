<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<title>Register</title>
</head>
<body>
	<form method="get" action="Controller">
		<p>
			<b>Social-Net</b>
		</p>
		<br>
		<br>
		<p>
			Enter First Name: <input type="text" name="FirstName"
				value="${param.FirstName}">
		</p>
		<p>
			Enter Last Name: <input type="text" name="LastName"
				value="${param.LastName}">
		</p>
		<p>
			Enter Mail-id: <input type="text" name="MailId"
				value="${param.MailId}">
		</p>
		<p>
			Enter PhoneNo: <input type="text" name="PhoneNo"
				value="${param.PhoneNo}">
		</p>
		<p>
			<input type="submit" name="confirmButton" value="confirm">
		</p>
	</form>
</body>
</html>
