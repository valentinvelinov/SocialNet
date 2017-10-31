<%@page import="com.socialNet.dao.PostDAO"%>
<%@page import="com.socialNet.model.Post"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Posts</title>
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
	
<body>
	<div id="showAllPosts">
		<table class="table table-striped">
			<tbody>
				<c:forEach var="post" items="${listOfPosts}">
					<tr>
						<td>${post.content}</td>
						<td>${post.post_id}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>

</html>