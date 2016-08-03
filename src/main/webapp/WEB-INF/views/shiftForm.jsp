<%@ include file="header.jsp"%>
<html>
<head>
<title>New/Edit Shift</title>
</head>
<body>
<section class="Login">
	<div align="center" class="container">
		<div class="loginbox">
		<h1>New/Edit Shift</h1>
		<form:form action="saveShift" method="post" modelAttribute="shift"
			class="form-horizontal" role="form">
			<form:hidden path="shiftId" />
			<div class="form-group">
				<div class="col-sm-12">
					<form:input path="shiftName" class="form-control"
						placeholder="Enter Shift Name" maxlength="30"/>
					<form:errors path="shiftName" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<form:input path="shiftDesc" class="form-control"
						placeholder="Enter Shift Description" maxlength="50" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2" align="center">
					<input type="submit" value="Save" class="btn btn-primary btn-md">
					<a href="cancel" class="btn btn-primary btn-md">Cancel</a>
				</div>
			</div>
		</form:form>
	</div>
	</div>
</section>
</body>
</html>