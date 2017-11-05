<%@ include file="meta.jsp"%>
<%@ include file="header.jsp"%>
<link rel="stylesheet" type="text/css" href="stylePhotos.css"
	media="screen" />

<div class="video-container">
	<video style="width: 100%" autoplay>
		<source src="img/clouds.mp4">
	</video>
</div>
<div class="w3-container w3-card w3-white w3-round w3-margin">

	<a href="newPost" class="w3-bar-item w3-button">Click here to make
		new post</a>

</div>


</div>

<body>

	<c:forEach items="${postList}" var="post">
		<table style="border: 1px solid; text-align: center">
			<div class="w3-container w3-card w3-white w3-round w3-margin">
				<hr class="w3-clear">
				<div class="w3-half">

					<img src="img/${post.pictureName} " style="width: 80%" alt="Nature"
						class="w3-margin-bottom">
				</div>
				<p>${post.content}</p>
				<p>ID: ${post.postId}</p>
				<p>User: ${post.userId}"</p>
				<p>Date: ${post.datePost}</p>
				<p>Number of likes: ${post.likeCount}</p>
				<p>Number of comments: ${post.commentCount}</p>

				<div class="w3-row-padding" style="margin: 0 -16px">

					<form name="test" method="get" action="newLike">
						<input type="hidden" name="postId" value="${post.postId}" /> <input
							type="submit" value="Like"
							class="w3-button w3-theme-d2 w3-margin-bottom">
					</form>

					<form name="test" method="get" action="showAllLikes">
						<input type="hidden" name="postId" value="${post.postId}" /> <input
							type="submit" value="Show likes"
							class="w3-button w3-theme-d2 w3-margin-bottom">
					</form>

					<button type="button"
						class="w3-button w3-theme-d2 w3-margin-bottom">
						<i class="fa fa-comment"> </i>  Comment
					</button>
				</div>
		</table>
	</c:forEach>
	</div>
	</div>
	<hr><%@ include file="footer.jsp"%>
</body>
<html>
</body>
</html>