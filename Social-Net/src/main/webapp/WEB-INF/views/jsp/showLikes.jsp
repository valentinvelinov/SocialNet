<%@ include file="meta.jsp"%>
<%@ include file="header.jsp"%>
<link rel="stylesheet" type="text/css" href="stylePhotos.css"
	media="screen" />

<div class="video-container">
	<video style="width: 100%" autoplay>
		<source src="img/clouds.mp4">
	</video>
</div>
<div class="w3-container w3-card w3-white w3-round w3-margin"></div>


</div>
<c:if test="${empty sessionScope.user.email}">
	<c:redirect url="index" />
</c:if>

<body>
	<c:forEach items="${likeList}" var="like">
		<table style="border: 1px solid; text-align: center">
			<div class="w3-container w3-card w3-white w3-round w3-margin">
				<hr class="w3-clear">

				<p>Like id: ${like.likeId}</p>
				<p>User: ${like.userId}"</p>
				<p>Post: ${like.postId}</p>

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