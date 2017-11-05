<%@ include file="meta.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
<title>Insert title here</title>
</head>
<body>
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
				<td>
					<form method="get" action="editcomment">
						<input type="hidden" name="commentId" value="${comment.commentId}" />
						<input type="hidden" name="postId" value="${comment.postId}" /> <input
							type="submit" value="Edit Comment"
							class="w3-button w3-theme-d2 w3-margin-bottom"> <input
							type="text" name="content" value=".." />
					</form>
				</td>
				<td>
					<form method="get" action="deletecomment">
						<input type="hidden" name="commentId" value="${comment.commentId}" />
						<input type="hidden" name="postId" value="${comment.postId}" /> <input
							type="submit" value="Delete" />
					</form>
				</td>
			</tr>
		</table>

	</c:forEach>
</body>
</html>