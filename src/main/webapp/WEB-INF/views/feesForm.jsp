<%@ include file="header.jsp"%>
<html>
<head>
<title>New/Edit Fees Form</title>
</head>
<body>
	<div class="container" align="center">
		<h1>New/Edit Contact</h1>
		<form:form action="saveContact" method="post" modelAttribute="contact"
			class="form-horizontal" role="form">

			<form:hidden path="id" />
			<div class="form-group">
				<label class="control-label col-sm-2" for="Name">Name </label>
				<div class="col-sm-10">
					<form:input path="name" class="form-control"
						placeholder="Enter  Name" />
					<form:errors path="name" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="Email">Email </label>
				<div class="col-sm-10">
					<form:input path="email" class="form-control"
						placeholder="Enter email" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="Address">Address
				</label>
				<div class="col-sm-10">
					<form:input path="address" class="form-control"
						placeholder="Enter address" />
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