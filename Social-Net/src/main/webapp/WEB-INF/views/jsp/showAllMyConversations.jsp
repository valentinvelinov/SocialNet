<%@ include file="meta.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Conversations</title>
</head>
<body>
<form method="get" action="showAllMyPosts">
		<input type="submit" value="Back to Homepage" />
	</form>	
	<c:forEach items="${list}" var="conversation">
		<table>
			<tr>
				<th>Conversation ID</th>
				<th>Title</th>
			</tr>
			<tr>
				<td>${conversation.conversationId}</td>
				<td>${conversation.title}</td>
				<td>
					<form method="get" action="openConversation">
						<input type="submit" value="Open Conversation" /> <input
							type="hidden" name="conversationId"
							value="${conversation.conversationId}" />
					</form>
				</td>
			</tr>

		</table>
	</c:forEach>
</body>
</html>