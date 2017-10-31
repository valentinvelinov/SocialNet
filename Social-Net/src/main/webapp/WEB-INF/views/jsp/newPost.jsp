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


		<div id="newPost">

			<form:form commandName="post" action="makePost" method="post">
				<fieldset class="clearfix">
					<p>
						<span class="fontawesome-user"></span>
						<form:input type="text" path="content" placeholder="Content"
							required="required" />
					</p>
					<p>
						<span class="fontawesome-user"></span>
						<form:input type="text" path="picture_name"
							placeholder="Picture_name" required="required" />
					</p>
				
					<p>
						<input type="submit" value="Save post">
					</p>

				</fieldset>

			</form:form>



		</div>

	</div>



</body>
</html>