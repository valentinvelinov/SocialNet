<%@ include file="meta.jsp"%>
<%@ include file="header.jsp"%>

<c:if test="${empty sessionScope.user.email}">
	<c:redirect url="index" />
</c:if>
<body>
	<div id="viewAllFriends">
		<c:forEach items="${friendList}" var="friend">
			<table style="border: 1px solid; text-align: center">
				<div class="w3-container w3-card w3-white w3-round w3-margin">
					<hr class="w3-clear">
					<p>${friend.userId}</p>
					<p>${friend.friendId}</p>
					<button type="button"
						class="w3-button w3-theme-d1 w3-margin-bottom">
						<i class="fa fa-thumbs-up"></i>  Delete friend
					</button>
				</div>
			</table>
		</c:forEach>
	</div>
	<hr><%@ include file="footer.jsp"%>
</body>
<html>
</body>
</html>