<%@ include file="meta.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
<title>Insert title here</title>
</head>
<table>
	<tr>
		<th>User ID</th>
		<th>first name</th>
		<th>last name</th>
		<th>email</th>
	</tr>
	<tr>
			<td>${user.userId}</td>
	
		<td>${user.firstName}</td>
		<td>${user.lastName}</td>
		<td>${user.email}</td>
		<td>
			<form method="post" action="editInfo">
				<input type="submit" value="Edit info" /> <input type="hidden"
					name="userId" value="${user.userId}" />
			</form>
		</td>
	</tr>

</table>