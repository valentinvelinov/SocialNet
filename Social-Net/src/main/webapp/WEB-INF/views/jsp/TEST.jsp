<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src='https://code.jquery.com/jquery-3.2.1.min.js'></script>
<script src='js/navbar.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajax Demo</title>
</head>
<body>
	<input id='user' type="text" placeholder="Search User" list="users_list"/>
	<datalist id='users_list'></datalist>
	<button id='search'>Search</button>
	<table id='users'>
		<thead>
			<tr>
				<th> User </th>
				<th> Email </th>
				<th> FirstName </th>
			</tr>
		</thead>
		<tbody>
			<tr>
			<td> test</td>
			<td> test2</td>
			<td> test3</td>
			</tr>
		</tbody>
	</table>
	<script src='js/navbar.js'></script>
</body>
</html>