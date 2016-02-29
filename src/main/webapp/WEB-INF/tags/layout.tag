<!DOCTYPE html>
<%@ tag description="Simple Template" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="su_title"%>
<%@attribute name="su_header"%>
<%@attribute name="su_content" fragment="true" %>
 
<html lang="en">
	<head>
		<title>SoundUp - ${su_title}</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta content="A meta search engine for entertainment programs." name=
		"description">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/style.css">
	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/Modules/modals.jsp"/>
			<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/Modules/nav.jsp"/>
			<div class="container">
				<div class="jumbotron">
					<h1>${su_header}</h1>
					<jsp:invoke fragment="su_content"/>
				</div>
			</div>
		</div>
		<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/public/js/script.js"></script>
	</body>
</html>
