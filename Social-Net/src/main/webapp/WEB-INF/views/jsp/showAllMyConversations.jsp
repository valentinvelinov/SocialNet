<%@ include file="meta.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Conversations</title>
</head>
<body>
	<h1>TESTING</h1>
	<c:forEach items="${list}" var="conversation">
		<table>
			<tr>
				<th>Conversation ID</th>
				<th>Title</th>
			</tr>
			<tr>
				<td>${conversation.conversationId}</td>
				<td>${conversation.title}</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>