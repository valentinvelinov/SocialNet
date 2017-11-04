<%@ include file="meta.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>TESTING</h1>
	<c:forEach items="${commentList}" var="comment">
		<p>${comment}</p>
	</c:forEach>
</body>
</html>