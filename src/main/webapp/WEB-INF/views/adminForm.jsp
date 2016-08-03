<%@ include file="header.jsp"%>
<html>
<head>
<title>New/Edit Admin</title>
</head>
<body>
<section class="Login">
<h4>${message}</h4>
	<div align="center" class="container">
	<div class="loginbox">
		<h1>New/Edit Admin</h1>
		
		<form:form action="saveAdmin" method="post" modelAttribute="admin"
			class="form-horizontal" role="form">
			<div class="form-group">
				<div class="col-sm-12">
					<form:input path="adminName" class="form-control"
						placeholder="Enter admin Name" maxlength="30" />
					<form:errors path="adminName" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<form:input path="email" class="form-control"
						placeholder="Enter email" maxlength="30" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<form:input path="password" class="form-control"
						placeholder="Enter password" maxlength="10" />
				</div>
			</div>
				<div class="form-group">
				<div class="col-sm-12">
					<form:select path="roleName" class="form-control">
						<form:option value="0" label="Select Role" />
						<form:options items="${listRole}" itemValue="roleName"
							itemLabel="roleName" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12" align="center">
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