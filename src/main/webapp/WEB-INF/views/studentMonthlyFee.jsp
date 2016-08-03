<%@ include file="header.jsp"%>
<html>
<head>
<title>Student Monthly Fee</title>
</head>
<body>
	<div align="center" class="container">
		<h1>Student Monthly Fee</h1>
		<h4>${message}</h4>
		<form:form action="saveStudentMonthlyFee" method="post"
			modelAttribute="fees" class="form-horizontal" role="form">
			
			<form:hidden path="studentId" />
			<div class="form-group">
				<label class="control-label col-sm-2" for="month"> Month </label>
				<div class="col-sm-10">
					<form:select path="monthName" class="form-control">
						<form:option value="0" label="Select Month" />
						<form:option value="JAN" label="JAN" />
						<form:option value="FEB" label="FEB" />
						<form:option value="MAR" label="MAR" />
						<form:option value="APR" label="APR" />
						<form:option value="MAY" label="MAY" />
						<form:option value="JUN" label="JUN" />
						<form:option value="JUL" label="JUL" />
						<form:option value="AUG" label="AUG" />
						<form:option value="SEP" label="SEP" />
						<form:option value="OCT" label="OCT" />
						<form:option value="NOV" label="NOV" />
						<form:option value="DEC" label="DEC" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="feeReceived">Monthly
					Fee</label>
				<div class="col-sm-10">
					<form:input path="tuitionFee" id="tuitionFee" class="form-control"
						placeholder="Enter Monthly Fee" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10" align="center">
					<input type="submit" value="Save" class="btn btn-primary btn-md">
					<a href="cancel" class="btn btn-primary btn-md">Cancel</a>
				</div>
			</div>

		</form:form>

	</div>
</body>
</html>
