<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
	<head>
		<title>Sound hosting - Group 26</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/style.css">
	</head>
	<body>
		<div class="wrapper">
			<header>
				<h1>SoundUp</h1>
				<h2>Share your sounds with your friends!</h2>
			</header>
			<main>
				<article>
					<p>A website that will dominate the market by 2017.</p>
					<p>Sævör grét áðan því úlpan var ónýt.</p>
					<p>Klukkan er:</p>
				</article>
				<form method="POST" enctype="multipart/form-data" action="/upload">
					File to upload: <input type="file" name="file">
					Name: <input type="text" name="name">
					<input type="submit" value="Upload">
				</form>
				<button>
					<a href="./upload">Upload a Sound File</a>
				</button>
				<button>
					<a href="./user">To Users</a>
				</button>
			</main>
			<nav>
				<p>NAV</p>
				<ul></ul>
			</nav>
			<aside>
				<p>ASIDE</p>
			</aside>
			<footer>
				<p>HBV501G group 26, University of Iceland, Fall 2015</p>
			</footer>
		</div>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/public/js/script.js"></script>
	</body>
</html>
