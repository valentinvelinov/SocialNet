<%@ include file="meta.jsp"%>
<%@ include file="header.jsp"%>
<div class="video-container">
	<video style="width: 100%" autoplay loop>
		<source src="img/clouds.mp4">
	</video>
</div>
<div class="w3-container w3-card w3-white w3-round w3-margin"></div>


</div>
<c:if test="${empty sessionScope.user.email}">
	<c:redirect url="index" />
</c:if>

<body>

	<c:forEach items="${postList}" var="post">
		<table style="border: 1px solid; text-align: center">
			<div class="w3-container w3-card w3-white w3-round w3-margin">
				<hr class="w3-clear">
				<div class="w3-half">

					<img src="img/${post.pictureName} " style="width: 80%" alt="Nature"
						class="w3-margin-bottom">
				</div>
				<p>User first name: ${user.firstName}</p>
				<p>User last name: ${user.lastName}"</p>
				<p>Date: ${post.datePost}</p>
				<p>Content: ${post.content}</p>


				<div class="w3-row-padding" style="margin: 0 -8px">
					<button type="button"
						class="w3-button w3-theme-d1 w3-margin-bottom">
						<i class="fa fa-thumbs-up"></i>  Like
					</button>
					<form name="test" method="get" action="showPostComments">
						<input type="hidden" name="postId" value="${post.postId}" /> <input
							type="submit" value="Show Comments"
							class="w3-button w3-theme-d2 w3-margin-bottom">
					</form>

					<button type="button"
						class="w3-button w3-theme-d2 w3-margin-bottom">
						<form method="get" action="deletePost">
							<input type="hidden" name="postId" value="${post.postId}" /> <input
								type="submit" value="Delete post"
								class="w3-button w3-theme-d2 w3-margin-bottom" />
						</form>
					</button>


					<form name="test" method="get" action="editPost">
						<input type="hidden" name="postId" value="${post.postId}" /> <input
							type="submit" value="Edit post"
							class="w3-button w3-theme-d2 w3-margin-bottom">
					</form>

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