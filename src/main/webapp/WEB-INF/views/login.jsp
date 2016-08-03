<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login</title>
<link rel="shortcut icon" href="favicon.ico" />
<%@ include file="include.jsp"%>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
			<div class="loginbox">
				<h1>User Login</h1>
				<font color="red">${message}</font>
				<c:url var="loginUrl" value="/login" />
				<form action="${loginUrl}" method="post" class="form-horizontal">
					<c:if test="${param.error != null}">
						<div class="alert alert-danger">
							<p>Invalid username and password.</p>
						</div>
					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert alert-success">
							<p>You have been logged out successfully.</p>
						</div>
					</c:if>
					<div class="form-group">
						<div class="col-sm-12">
							<input type="text" id="username" name="ssoId" class="form-control"
								placeholder="Username" />
						</div>
					</div>
	
					<div class="form-group">
						<div class="col-sm-12">
							<input type="password" id="password" name="password"
								placeholder="Enter Password" class="form-control" />
						</div>
					</div>
	
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<input type="submit" value="Login" class="btn btn-primary btn-block">
					<a href="forgetPassword" class="" style="display:inline-block;margin-top:15px">Forget Password</a>	
<!-- 					<div class="form-group"> -->
<!-- 						<div class="" align="center"> -->
<!-- 						</div> -->
<!-- 					</div> -->
				</form>
			</div>
			</div>
		</div>
	</div>
</body>
</html>