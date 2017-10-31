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
						<span class="fontawesome-user"></span>
						<form:input type="text" path="email" placeholder="Email" required="required" />
					</p>
					<!-- JS because of IE support; better: placeholder="Username" -->
					<p>
						<span class="fontawesome-lock"></span>
						<form:input type="password" path="password" placeholder="Password" required="required" />
					</p>
					<!-- JS because of IE support; better: placeholder="Password" -->
					<p>
						<input type="submit" value="Log In">
					</p>
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
