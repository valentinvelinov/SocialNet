<%@ include file="meta.jsp"%>
<%@ include file="header.jsp"%>
<div class="video-container">
	<video style="width: 100%" autoplay>
		<source src="img/clouds.mp4">
	</video>
</div>
</div>
<c:if test="${empty sessionScope.user.email}">
	<c:redirect url="index" />
</c:if>
<body>
	<div id="showAllConversations">
		<c:forEach items="${conversationList}" var="conversation">
			<table style="border: 1px solid; text-align: center">
				<div class="w3-container w3-card w3-white w3-round w3-margin">
					<hr class="w3-clear">
					<p>Conversation ID: ${conversation.conversationId}"</p>
					<p>Content: ${conversation.contentConversation}</p>
					<div class="w3-row-padding" style="margin: 0 -16px">
						<button type="button"
							class="w3-button w3-theme-d1 w3-margin-bottom">
							<i class="fa fa-thumbs-up"></i>  Delete conversation
						</button>
					</div>
			</table>
		</c:forEach>
	</div>
	</div>
	<hr><%@ include file="footer.jsp"%>
</body>
</html>