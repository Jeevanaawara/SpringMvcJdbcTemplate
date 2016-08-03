<%@ include file="header.jsp"%>
<html>
<head>
<title>Transfer Student</title>
</head>
<body>
<section class="Login">
	<div align="center" class="container">
		<div class="loginbox">
		<h1>Transfer Student</h1>
		<form:form action="studentTransfer" method="post"
			modelAttribute="student" class="form-horizontal" role="form">
				<form:hidden path="studentId" />
		<div class="form-group">
				<div class="col-sm-12">
					<form:select path="classId" class="form-control">
						<form:option value="0" label="Select Class" />
						<form:options items="${listClass}" itemValue="classId"
							itemLabel="className" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<form:select path="sectionId" class="form-control">
						<form:option value="0" label="Select Session" />
						<form:options items="${listSection}" itemValue="sectionId"
							itemLabel="sectionName" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12" align="center">
					<input type="submit" value="Transfer" class="btn btn-primary btn-md">
					<a href="cancel" class="btn btn-primary btn-md">Cancel</a>
				</div>
			</div>
		</form:form>
	</div>
	</div>
</section>
</body>
</html>