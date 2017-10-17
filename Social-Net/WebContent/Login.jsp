<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Material Login Form</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

<link rel='stylesheet prefetch'
	href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch'
	href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

<link rel="stylesheet" href="style.css">

</head>
<body>

	<!-- Mixins-->
	<!-- Pen Title-->
	<div class="pen-title">
		<h1>Login</h1>
	</div>
	<div class="rerun">
		<a href="">Return Pen</a>
	</div>


	<div class="container">
		<div class="card"></div>
		<div class="card">
			<form>
				<div class="input-container">
					<input type="text" id="label" required="required" /> <label
						for="label">Username</label><input name="username">
					<div class="bar"></div>
				</div>
				<div class="input-container">
					<input type="password" id="label" required="required" /> <label
						for="label">Password</label><input name="password">
					<div class="bar"></div>
				</div>
				<div class="button-container">
					<button>
						<span>Go</span>
					</button>
				</div>
				<div class="footer">
					<a href="Register.jsp">You don't have an account?</a>
				</div>

			</form>
		</div>
		<div class="card alt">
			<div class="toggle"></div>
			<h1 class="title">
				Register
				<div class="close"></div>
			</h1>

		</div>
	</div>

	<script src="js/index.js"></script>

</body>
</html>