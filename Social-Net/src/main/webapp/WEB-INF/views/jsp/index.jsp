<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<meta charset="UTF-8">
<title>Social-Net</title>



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

			<form:form commandName="user" action="login" method="post">
				<img src="img/VERSION_LOGO.png" />
				<fieldset class="clearfix">
					<p>
						<c:out value="${error}" />
						<span class="fontawesome-user"></span>
						<form:input type="email" path="email" placeholder="Email"
							required="required" />
					</p>
					<!-- JS because of IE support; better: placeholder="Username" -->
					<p>
						<span class="fontawesome-lock"></span>
						<form:input type="password" path="password" placeholder="Password"
							required="required" />
					</p>
					<!-- JS because of IE support; better: placeholder="Password" -->
					<p>
						<input type="submit" value="Log In">
					</p>

					<form:hidden path="firstName" value="FirstNameExample" />
					<form:hidden path="lastName" value="LastNameExample" />
					<form:hidden path="birthDate" value="12/12/2012" />
					<form:hidden path="profilePicUrl" value="people.png" />
					<form:hidden path="gender" value="Male" />
				</fieldset>

			</form:form>

			<p>
				Don't have registration? Click here to create one. <a
					href="register" class="blue"> Register here </a><span
					class="fontawesome-arrow-right"></span>
			</p>

		</div>
		<!-- end login -->

	</div>



</body>
</html>
