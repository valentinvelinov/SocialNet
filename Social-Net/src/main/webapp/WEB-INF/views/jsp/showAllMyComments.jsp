<%@ include file="meta.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="css/style.css">
<style>
table, th, td {
	border: 1px solid black;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div id="clouds">
		<div class="cloud x1"></div>
		<!-- Time for multiple clouds to dance around -->
		<div class="cloud x2"></div>
		<div class="cloud x3"></div>
		<div class="cloud x4"></div>
		<div class="cloud x5"></div>
		<h1>TESTING</h1>
		<form:form commandName="comment" action="newComment" method="get">
			<form:input type="text" path="text" placeholder="Enter a comment.." />
			<input type="hidden" name="postId" value="${comment.postId}" />
			<input type="submit" value="Create Comment" />
		</form:form>
		<c:forEach items="${commentList}" var="comment">
			<table>
				<tr>
					<th>Comment ID</th>
					<th>Post ID</th>
					<th>Comment TEXT</th>
					<th>USER:</th>
					<th>DATE:</th>
					<th></th>
				</tr>
				<tr>
					<td>${comment.commentId}</td>
					<td>${comment.postId}</td>
					<td>${comment.text}</td>
					<td>${comment.userId}</td>
					<td>${comment.dateComment}</td>
					<c:if test="${sessionScope.user.userId == comment.userId}">
						<td>
							<form method="get" action="editcomment">
								<input type="hidden" name="commentId"
									value="${comment.commentId}" /> <input type="hidden"
									name="postId" value="${comment.postId}" /> <input
									type="submit" value="Edit Comment"
									class="w3-button w3-theme-d2 w3-margin-bottom"> <input
									type="text" name="content" value=".." />
							</form>
						</td>
						<td>
							<form method="get" action="deleteComment">
								<input type="hidden" name="commentId"
									value="${comment.commentId}" /> <input type="hidden"
									name="postId" value="${comment.postId}" /> <input
									type="submit" value="Delete"
									class="w3-button w3-theme-d2 w3-margin-bottom" />
							</form>
					</c:if>
					<td></td>
				</tr>
			</table>

		</c:forEach>
	</div>
</body>
</html>