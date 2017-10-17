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
		<h1>Registration</h1>
	</div>
	<div class="rerun">
		<a href="">Return Pen</a>
	</div>
	<div class="container">
		<div class="card"></div>
		<div class="card">
			<form>
				<div class="input-container">
					<input type="type" id="label" required="required" /> <label
						for="label">First name</label><input name="firstName">
					<div class="bar"></div>
				</div>
				<div class="input-container">
					<input type="type" id="label" required="required" /> <label
						for="label">Last name</label><input name="lastName">
					<div class="bar"></div>
				</div>
				<div class="input-container">
					<input type="type" id="label" required="required" /> <label
						for="label">Mobile number of email</label><input name="email">
					<div class="bar"></div>
				</div>
				<div class="input-container">
					<input type="password" id="label" required="required" /> <label
						for="label">Password</label><input name="password">
					<div class="bar"></div>
				</div>
				<div class="input-container">
					<label for="birthday">Birthday:</label> <input name="birthday"
						size="1" type="date" required="required" id="birthday"
						form="repsignup" />
				</div>
				<div class="input-container">
					<label for="gender">Gender:</label> <select name="gender" size="1"
						id="gender" form="repsignup">
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select>
				</div>

				<div class="button-container">
					<button>
						<span>Next</span>
					</button>
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