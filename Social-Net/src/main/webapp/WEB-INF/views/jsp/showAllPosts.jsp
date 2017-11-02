<%@page import="com.socialNet.dao.PostDAO"%>
<%@page import="com.socialNet.model.Post"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<title>SocialNet</title>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
			<style>
body {
	font-family: "Times New Roman", Georgia, Serif;
}
</style>
			<body>
				<!-- Navbar (sit on top) -->
				<div class="w3-top">
					<div class="w3-bar w3-white w3-padding w3-card"
						style="letter-spacing: 2px;">
						<img src="img/VERSION_LOGO.png" width='232px' />
						<!-- Right-sided navbar links. Hide them on small screens -->
						<div class="w3-right w3-hide-small">
							<a href="homeUser.jsp" class="w3-bar-item w3-button">Home</a> <a
								href="#" class="w3-bar-item w3-button">My profile</a> <a
								href="#menu" class="w3-bar-item w3-button">My wall</a> <a
								href="#contact" class="w3-bar-item w3-button">Posts</a> <a
								href="#contact" class="w3-bar-item w3-button">Friends</a> <a
								href="#contact" class="w3-bar-item w3-button">Messages</a> <a
								href="#contact" class="w3-bar-item w3-button">Search</a><img
								src="img/people.png" width='70px' />
						</div>

					</div>

				</div>

				<!-- Header -->
				<div class="video-container">
					<video style="width:100%" autoplay> <source
						src="img/clouds.mp4"></video>
				</div>

				</div>
				<c:if test="${empty sessionScope.user.email}">
					<c:redirect url="index" />
				</c:if>
				<body>
					<div id="viewAllPosts">
						<c:forEach items="${postList}" var="post">
							<table style="border: 1px solid; text-align: center">
								<div class="w3-container w3-card w3-white w3-round w3-margin">
									<hr class="w3-clear">
										<div class="w3-half">
											<img src="img/${post.picture_name} " style="width: 50%"
												alt="Nature" class="w3-margin-bottom">
										</div>
										<p>${post.content}</p>
										<p>User: ${post.user_id}"</p>
										<p>Date: ${post.date_post}</p>
										<div class="w3-row-padding" style="margin: 0 -16px">
											<button type="button"
												class="w3-button w3-theme-d1 w3-margin-bottom">
												<i class="fa fa-thumbs-up"></i>  Like
											</button>
											<button type="button"
												class="w3-button w3-theme-d2 w3-margin-bottom">
												<i class="fa fa-comment"></i>  Comment
											</button>
										</div>
							</table>
						</c:forEach>
					</div>
					</div>
					<hr>

						<!-- Footer -->
						<footer class="w3-center w3-light-grey w3-padding-32">
						<p>Created by Valentin & Karamfilia</p>
						</footer>
				</body>
				<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Posts</title>
	<link rel="stylesheet" href="css/style.css">
</head>
			</body>
</html>