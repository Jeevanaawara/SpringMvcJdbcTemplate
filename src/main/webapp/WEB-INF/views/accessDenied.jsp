<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>AccessDenied page</title>
</head>
<body>
	Dear <strong>${user}</strong>, You are not authorized to access this page
	<a href="<c:url value="/logout" />">Logout</a>
		<div class="container" align="center">
			<div class="homeimg text-center">
				<img src="${pageContext.request.contextPath}/resources/img/logo.jpg" style="height: 50%;" alt="logo of Torcia" />
			</div>
		</div>
</body>
</html>