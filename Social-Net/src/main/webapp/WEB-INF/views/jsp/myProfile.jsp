<%@ include file="meta.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<style>
table, th, td {
	border: 1px solid black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<div id="clouds">
		<div class="cloud x1"></div>
		<!-- Time for multiple clouds to dance around -->
		<div class="cloud x2"></div>
		<div class="cloud x3"></div>
		<div class="cloud x4"></div>
		<div class="cloud x5"></div>
		<c:if test="${empty sessionScope.user.email}">
			<c:redirect url="index" />
		</c:if>
		<form action="showAllMyPosts" method="get">
			<input type="submit" value="Back to homepage." />
		</form>
		<c:out value="Your email is: ${sessionScope.user.email}" />

		<p>
			<c:out value="Your firstname is: ${sessionScope.user.firstName}" />
		<form action="changeFirstName" method="get">
			<input type="text" name="firstName" placeholder="Enter new name"
				required="required" /> <input type="submit"
				value="change your firstname" />
		</form>
		<p>

			<c:out value="Your lastname is: ${sessionScope.user.lastName}" />
		<form action="changeLastName" method="get">
			<input type="text" name="lastName" placeholder="Enter new name"
				required="required" /> <input type="submit"
				value="change your lastname" />
		</form>
		<p>
			<c:out value="You are born on: ${sessionScope.user.birthDate}" />
		</p>
	</div>
</body>
</html>