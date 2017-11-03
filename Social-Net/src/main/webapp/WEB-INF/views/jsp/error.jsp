<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<body id="bd">
	<div id="clouds">
		<center>
			<h1 class="back">ERROR PAGE!</h1>
		</center>
		<div class="cloud x1"></div>
		<center>
			<img src="img/error.gif" name="cute-error" width="362" height="291"
				id="cute-error" />
		</center>
		<center>
			<h2 class="back">Return to login page!</h2>
		</center>
		<center>
			<form method="get" action="index">
				<button class="button" type="Submit">Login page</button>
		</center>
		<!-- Time for multiple clouds to dance around -->
		<div class="cloud x2"></div>
		<div class="cloud x3"></div>
		<div class="cloud x4"></div>
		<div class="cloud x5"></div>
	</div>
</body>
</html>