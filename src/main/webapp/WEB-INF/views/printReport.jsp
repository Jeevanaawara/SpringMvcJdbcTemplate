<%@ include file="header.jsp"%>
<html>
<head>
<title>Daily Report</title>
<script src="${pageContext.request.contextPath}/resources/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery-ui.js"></script>
<script>
	$(document).ready(function aaa() {
		$("#datepicker").datepicker();
	});
	$(document).ready(function aaa() {
		$("#datepicker2").datepicker();
	});
</script>
</head>
<body>
	<h4>${message}</h4>
	<section class="Login">
		<div align="center" class="container">
			<div class="loginbox">
				<h1>Daily Report</h1>
				<form:form action="generateReport" method="post"
					modelAttribute="student" class="form-horizontal" role="form">
					<div class="form-group">
						<div class="col-sm-12">
							<form:input path="dateCreated" id="datepicker"
								class="form-control" placeholder="Enter startDate" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<form:input path="enddateCreated" id="datepicker2"
								class="form-control" placeholder="Enter endDate" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<form:radiobutton path="batchClass.classType" value="Coaching"
								label="Coaching" />
							<form:radiobutton path="batchClass.classType" value="Entry Test"
								label="Entry Test" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2" align="center">
							<input type="submit" value="Print" class="btn btn-primary btn-md">
							<a href="cancel" class="btn btn-primary btn-md">Cancel</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</section>

</body>
</html>
