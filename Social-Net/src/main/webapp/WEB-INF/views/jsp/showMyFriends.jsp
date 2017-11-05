<%@ include file="meta.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${userList}" var="user">
		<table>
			<tr>
				<th>User ID</th>
				<th>User FirstName</th>
				<th>User LastName</th>
				<th>User email:</th>
				<th></th>
			</tr>
			<tr>
				<td>${user.userId}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
			<td>
		</table>
	</c:forEach>
</body>
</html>