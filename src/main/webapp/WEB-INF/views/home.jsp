<html>
<head>
<title>Torcia Home</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/meanmenu.css" media="all" />
	<%@ include file="include.jsp"%>
</head>
<body>
<%@ include file="header.jsp"%>
	<section class="homebody">
		<div class="container">
			<div class="homeimg text-center">
				<img src="${pageContext.request.contextPath}/resources/img/logo.jpg" alt="logo of Torcia" />
			</div>
		</div>
	</section>
<!-- </div> -->
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