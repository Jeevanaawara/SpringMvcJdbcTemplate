
<html>
<head>
<title>Student Home</title>
<%@ include file="include.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/meanmenu.css" media="all" />
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<ul class="nav navbar-nav">
					<li><a href="exportReport?report=${reportName}">View Report</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="printReport">Daily Report</a></li>
					<li><a href="searchStudent">Student Search</a></li>
					<li><a href="newEntryTest">Entry Test Registration</a></li>
					<li><a href="newCoaching">Coaching Registration</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<section class="homebody">
			<div align="right" style="background-color: #DD362D; color: white;">
		</div>
		<h4>${message}</h4>
		<div class="container">
			<div class="homeimg text-center">
				<img src="${pageContext.request.contextPath}/resources/img/logo.jpg" alt="logo of Torcia" />
			</div>
		</div>
	</section>

	<script src="${pageContext.request.contextPath}/resources/jquery-1.10.2.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/jquery.meanmenu.js"></script>
	<script>
		jQuery(document).ready(function() {
			jQuery('header nav').meanmenu();
		});
	</script>
	

</body>
</html>