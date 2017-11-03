<%@ include file="meta.jsp"%>
<%@ include file="header.jsp"%>

<div>
	<c:if test="${empty sessionScope.user.email}">
		<c:redirect url="index" />
	</c:if>
</div>

<body>
	<div id="gallery">
		<c:forEach items="${postList}" var="post">
			<div>
				<a href="path-to-the-image">
					<figure>
						<img src="img/${post.pictureName} " style="width: 40%">
					</figure>
				</a>

			</div>
		</c:forEach>
	</div>
	<hr><%@ include file="footer.jsp"%>
</body>
<html>
</body>
</html>



