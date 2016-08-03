
<html>
<head>
<title>Student Home</title>
<%@ include file="include.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/meanmenu.css" media="all" />
</head>
<body>
	<%@ include file="header.jsp"%>
	<section class="homebody">
			<div align="right" style="background-color: #DD362D; color: white;">
			<a href="printReport" style="color: white">Daily Report</a> &nbsp;&nbsp;
					<a href="searchStudent" style="color: white">Student Search</a>&nbsp;&nbsp;
					<a href="newEntryTest" style="color: white">Entry Test Registration</a>&nbsp;&nbsp;
					<a href="newCoaching" style="color: white">Coaching Registration</a>&nbsp;&nbsp;
		</div>
		<h4>${message}</h4>
			<a href="exportReport?report=${reportName}">View Report</a>
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