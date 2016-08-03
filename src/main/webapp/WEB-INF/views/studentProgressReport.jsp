<html>
<head>
<title>Student Progress Report</title>
<%@ include file="include.jsp"%>
</head>
<body>

	<%@ include file="header.jsp"%>
	<h4>${message}</h4>
	<div align="center" class="container">
	<div class="loginbox">
		<h1>Student Progress</h1>
			<h4>${message}</h4>
		<form:form action="saveStudentProgressReport" method="post"
			modelAttribute="studentProgressReport" class="form-horizontal"
			role="form">
			<form:hidden path="studentId" />
			<div class="form-group">
				<div class="col-sm-12">
					<form:select path="subjectId" class="form-control">
						<form:option value="0" label="Select Subject" />
						<form:option value="2" label="Biology" />
						<form:option value="1" label="Chemistry" />
						<form:option value="5" label="English" />
						<form:option value="4" label="Maths" />
						<form:option value="3" label="Physics" />
						<form:option value="6" label="Pak studies" />
						<form:option value="7" label="Islamiyat" />
						<form:option value="8" label="Urdu" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<form:input path="testName" id="testName"
						class="form-control" placeholder="Enter Test Name" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<form:input path="obtainedMarks" id="obtainedMarks"
						class="form-control" placeholder="Enter obtained Marks" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<form:input path="totalMarks" id="totalMarks" class="form-control"
						placeholder="Enter Total Marks" />
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
	</div>
</body>
</html>
