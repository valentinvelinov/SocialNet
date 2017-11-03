<%@ include file="meta.jsp"%>
<%@ include file="header.jsp"%>
<html>
<head>
<style>
div.gallery {
	margin: 5px;
	border: 1px solid #ccc;
	float: left;
	width: 180px;
}

div.gallery:hover {
	border: 1px solid #777;
}

div.gallery img {
	width: 100%;
	height: auto;
}

div.desc {
	padding: 15px;
	text-align: center;
}
</style>
</head>
<body>

	<div class="gallery">
		<a target="_blank" href="cat.jpg"> <img src="jpg/cat.jpg"
			alt="Fjords" width="300" height="200">
		</a>
		<div class="desc">Add a description of the image here</div>
	</div>



	<div class="gallery">
		<a target="_blank" href="dog.jpg"> <img src="jpg/dog.jpg"
			alt="Northern Lights" width="300" height="200">
		</a>
		<div class="desc">Add a description of the image here</div>
	</div>


	<div class="desc">Add a description of the image here</div>
	</div>
	<hr><%@ include file="footer.jsp"%>

</body>
</html>