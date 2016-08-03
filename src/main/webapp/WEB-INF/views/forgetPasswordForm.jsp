<%@ include file="include.jsp"%>
<html>
<head>
<title>PassWord Change</title>
</head>
<body>
<section class="Login">
<h4>${message}</h4>
	<div align="center" class="container">
	<div class="loginbox">
		<form:form action="saveforgetPassword" method="post" modelAttribute="admin"
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
					<form:input path="password" class="form-control"
						placeholder="Enter password" maxlength="10" />
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