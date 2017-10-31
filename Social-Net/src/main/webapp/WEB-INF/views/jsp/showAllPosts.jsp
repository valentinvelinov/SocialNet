<%@page import="com.socialNet.dao.PostDAO"%>
<%@page import="com.socialNet.model.Post"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Posts</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>

	<c:forEach items="${postList}" var="post">
		<table style="border: 1px solid;">

			<tr>
				<td>
					<h1>Post content: ${post.content}</h1>
				</td>
			</tr>
			</br>
			<tr>
				<td>
					<h1>Post id: ${post.post_id}</h1>
				</td>
			</tr>
			</br>
			<tr>
				<td>
					<h1>User id: ${post.user_id}</h1>
				</td>
			</tr>
			<tr>
				<td>
					<h1>
						<img src="img/${post.picture_name}">
					</h1>
				</td>
			</tr>
			<tr>
				<td>
					<h1>
						<h1>Date: ${post.date_post}</h1>
					</h1>
				</td>

			</tr>

			<p>
				Comment this post ---> <a href="comment" class="blue"> Comment </a><span
					class="fontawesome-arrow-right"></span>
			</p>
			<p>
				Like this post ---> <a href="comment" class="blue"> Like </a><span
					class="fontawesome-arrow-right"></span>

			</p>


			<p>
				<a href="viewLikes" class="blue"> View likes </a><span
					class="fontawesome-arrow-right"></span> <a href="viewComments"
					class="blue"> View comments </a><span
					class="fontawesome-arrow-right"></span>
			</p>
		</table>
	</c:forEach>


</body>

</html>