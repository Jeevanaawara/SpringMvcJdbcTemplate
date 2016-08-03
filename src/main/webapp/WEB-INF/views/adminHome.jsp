<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login</title>
<%@ include file="include.jsp"%>
<link rel="shortcut icon" href="favicon.ico" />
</head>
<body>
<section class="Login">
	<div align="center" class="container">
		<div class="loginbox">
			<h1>User Login</h1>
			<font color="red">${message}</font>
			<form:form id="loginForm" method="post" action="login"
				modelAttribute="admin">
				<div class="form-group">
					<div class="col-sm-12">
						<form:input id="adminName" name="adminName" path="adminName"
							class="form-control" placeholder="Username" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<form:password id="password" name="password" path="password"
							class="form-control" placeholder="Password" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10" align="center">
						<input type="submit" value="Login" class="btn btn-primary btn-md" onclick="return loginValidation();">
					</div>
				</div>
			</form:form>
		</div>
	</div>	
</section>
</body>
</html>
