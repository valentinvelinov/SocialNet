<%@ include file="meta.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<title>SocialNet</title>
<meta charset="UTF-8">
<script src='https://code.jquery.com/jquery-3.2.1.min.js'></script>
<script src='js/navbar.js'></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
body {
	font-family: "Times New Roman", Georgia, Serif;
}
 .hello{
	positon:absolute;
	right:100px;
	top:10px;
}
</style>
<body>
	<!-- Navbar (sit on top) -->
	<div class="w3-top">
		<div class="w3-bar w3-white w3-padding w3-card"
			style="letter-spacing: 2px;">
			<p class="hello">Hello ,"${sessionScope.user.firstName}"</p>
			<img src="img/VERSION_LOGO.png" width='232px' />
				<input id='user' type="text" placeholder="Search User"
					list="users_list" />
				<datalist id='users_list'></datalist>
			<div class="w3-right w3-hide-small">
				<a href="showAllMyPosts" class="w3-bar-item w3-button">Home</a> <a
					href="userPosts" class="w3-bar-item w3-button">Posts</a> <a
					href="friends" class="w3-bar-item w3-button">Friends</a> <a
					href="showAllMyConversations" class="w3-bar-item w3-button">Messages</a> <a
					href="showAllMyPhotos" class="w3-bar-item w3-button">Gallery</a> <a
					href="#" class="w3-bar-item w3-button">My profile</a> <img
					src="img/people.png" width='70px' />

			</div>
		</div>
	</div>