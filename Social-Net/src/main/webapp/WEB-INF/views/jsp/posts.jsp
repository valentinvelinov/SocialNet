<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Social-Net Registration</title>
<link rel="stylesheet" href="css/style.css">


</head>

<body>
	<div id="clouds">
		<div class="cloud x1"></div>
		<!-- Time for multiple clouds to dance around -->
		<div class="cloud x2"></div>
		<div class="cloud x3"></div>
		<div class="cloud x4"></div>
		<div class="cloud x5"></div>
	</div>

	<div class="container">

		<body>
			<table style="border: 1px solid;">

				<tr>
					<td>
						<h1>Post content: ${post.content}</h1>
					</td>
				</tr>
				</br>
				<tr>
					<td>
						<h1>Post id: ${post.post_id}</h1>
					</td>
				</tr>
				</br>
				<tr>
					<td>
						<h1>Post user id: ${post.user_id}</h1>
					</td>
				</tr>
				<tr>
					<td>
						<h1>
							<img src="img/post1.jpg">
						</h1>
					</td>
				</tr>
			</table>

		</body>
	</div>
</html>