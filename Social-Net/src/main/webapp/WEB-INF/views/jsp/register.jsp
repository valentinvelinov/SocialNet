<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
<script src=" https://use.fontawesome.com/64905ac2c6.js"></script>
<link rel="stylesheet" href="css/style.css">


<title>Social-Net Registration</title>
</head>

<body>
	<div id="clouds">
		<div class="cloud x1"></div>
		<!-- Time for multiple clouds to dance around -->
		<div class="cloud x2"></div>
		<div class="cloud x3"></div>
		<div class="cloud x4"></div>
		<div class="cloud x5"></div>
	</div>

	<div class="container">


		<div id="login">

			<form:form commandName="user" action="register" method="post">

				<fieldset class="clearfix">
					<img src="img/VERSION_LOGO.png" name="logo" id="logo">

					<p>
						<span class="fa fa-user-o"></span>
						<form:input type="text" path="firstName" placeholder="First Name"
							required="required" />
					</p>
					<p>
						<span class="fontawesome-user"></span>
						<form:input type="text" path="lastName" placeholder="Last_Name"
							required="required" />
					</p>
					<p>
						<span class="fontawesome-envelope"></span>
						<form:input type="email" path="email" placeholder="Email"
							required="required" />
					</p>
					<p>
						<span class="fontawesome-calendar"></span>
						<form:input id="datepicker" path="birthDate" placeholder="Click here to set date!" />
					</p>
					<p>
						<span class="fontawesome-lock"></span>
						<form:input type="password" path="password" placeholder="Password"
							required="required" />
					</p>

					<label class="form-label">Gender</label>
					<div class="gender-selector">

						<form:radiobutton id="genderFemale" path="gender" value="Female"
							checked="checked" />
						<label for="genderFemale"> <span class="fa-stack fa-lg">
								<i class="fa fa-circle fa-stack-2x female"></i> <i
								class="fa fa-venus fa-stack-1x fa-inverse"></i>
						</span>
						</label>
						<form:radiobutton id="genderMale" path="gender" value="Male" />
						<label for="genderMale"> <span class="fa-stack fa-lg">
								<i class="fa fa-circle fa-stack-2x male"></i> <i
								class="fa fa-mars fa-stack-1x fa-inverse"></i>
						</span>
						</label>
					</div>

					<p>
						<input type="submit" value="Register">
					</p>

				</fieldset>
			</form:form>
		</div>
		<!-- end login -->

	</div>

</body>
</html>

