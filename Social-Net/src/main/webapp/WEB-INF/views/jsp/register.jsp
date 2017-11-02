<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Social-Net Registration</title>
<link rel="stylesheet" href="css/style.css">


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
					<p>
						<span class="fontawesome-user"></span>
						<form:input type="text" path="firstName" placeholder="First_Name"
							required="required" />
					</p>
					
					<p>
						<span class="fontawesome-user"></span>
						<form:input type="text" path="lastName" placeholder="Last_Name"
							required="required" />
					</p>
					
					<p>
						<span class="fontawesome-user"></span>
						<form:input type="email" path="email" placeholder="Email"
							required="required" />
					</p>
					
					<p>
						<span class="fontawesome-user"></span> 
						<form:input path="birthDate" placeholder="Birthday (mm/dd/yyyy)" />
					</p>
						<form:radiobutton path="gender" value="Male" checked="checked"/>Male
						<form:radiobutton path="gender" value="Female"/>Female
					<p>
						<span class="fontawesome-user"></span>
						<form:input type="password" path="password" placeholder="Password" required="required" />
					</p>
					<p>
						<input type="submit" value="Register">
					</p>
					
				</fieldset>

			</form:form>

			<p>
				Back to login page!<a href="index" class="blue"> Login page</a><span
					class="fontawesome-arrow-right"></span>
			</p>

		</div>
		<!-- end login -->

	</div>



</body>
</html>