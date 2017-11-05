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
	
	<c:forEach items="${postList}" var="post">
		<table>
			<tr>
				<th>Pot ID</th>
				<th>Post content</th>
				<th>USER:</th>
				<th>DATE:</th>
				<th></th>
			</tr>
			<tr>
				<td>${post.postId}</td>
				<td>${post.content}</td>
				<td>${post.userId}</td>
				<td>${post.datePost}</td>
				<c:if test="${sessionScope.user.userId == post.userId}">
					<td>
						<form method="get" action="editPosts">
							<input type="hidden" name="postId"
								value="${post.postId}" /> <input type="hidden"
								name="postId" value="${post.postId}" /> <input type="submit"
								value="Edit Post"
								class="w3-button w3-theme-d2 w3-margin-bottom"> <input
								type="text" name="content" value=".." />
						</form>
					</td>
					<td>
						
				</c:if>
				<td></td>
			</tr>
		</table>

	</c:forEach>
</body>
</html>