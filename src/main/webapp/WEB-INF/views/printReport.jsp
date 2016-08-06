<html>
<head>
<title>Daily Report</title>
<%@ include file="include.jsp"%>
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
	<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h4>${message}</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<h1 class="text-center">Daily Report</h1>
				<form:form action="generateReport" method="post"
					modelAttribute="student" class="" role="form">
					<div class="form-group">
						<form:input path="dateCreated" id="datepicker"
							class="form-control" placeholder="Enter startDate" />
					</div>
					<div class="form-group">
						<form:input path="enddateCreated" id="datepicker2"
							class="form-control" placeholder="Enter endDate" />
					</div>
					<div class="form-group">
						<div class="radio-inline">
							<form:radiobutton path="batchClass.classType" value="Coaching"
								label="Coaching" />
						</div>
						<div class="radio-inline">
							<form:radiobutton path="batchClass.classType" value="Entry Test"
								label="Entry Test" />
						</div>
					</div>
					<div class="pull-right">
						<a href="cancel" class="btn btn-default">Cancel</a>
						<input type="submit" value="Print" class="btn btn-primary">
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
