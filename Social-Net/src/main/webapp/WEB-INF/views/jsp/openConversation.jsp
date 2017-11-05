
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
<title>Insert title here</title>
</head>
<body>
	<h1>TESTING</h1>
	<c:forEach items="${listMSG}" var="message">
		<table>
			<tr>
				<th>Message ID</th>
				<th>Conversation ID</th>
				<th>Content</th>
				<th>Date</th>
				<th>UserId</th>
			</tr>
			<tr>
				<td>${message.messageId}</td>
				<td>${message.conversationId}</td>
				<td>${message.content}</td>
				<td>${message.date}</td>
				<td>${message.userId}</td>
			</tr>
		</table>
	</c:forEach>
	<form:form commandName="message" action="newMessage" method="get">
		<form:input type="text" path="content" placeholder="Enter a message.." />
		<input type="hidden" name=conversationId value="${message.conversationId}" />
		<input type="submit" value="Send" />
	</form:form>
</body>
</html>