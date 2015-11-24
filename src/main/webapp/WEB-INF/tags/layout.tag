<!DOCTYPE html>
<%@tag description="Simple Template" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
 
<!-- We need to declare blocks, su_ is a prefix that stands for SoundUp -->
<%@attribute name="su_title"%>
<%@attribute name="su_content" fragment="true" %>
 
<html lang="en">
	<head>
		<title>SoundUp - ${su_title}</title><!-- su_title is a variable which will be declared on each page -->
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
			<jsp:invoke fragment="su_content"/> <!--Invoke/block example-->
		</div>
		<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/public/js/script.js"></script>
	</body>
</html>
