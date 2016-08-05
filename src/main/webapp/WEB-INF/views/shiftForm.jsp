<html>
<head>
<title>New/Edit Shift</title>
<%@ include file="include.jsp"%>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<h1 class="text-center">New/Edit Shift</h1>
			<form:form action="saveShift" method="post" modelAttribute="shift"
				class="" role="form">
				<form:hidden path="shiftId" />
				<div class="form-group">
					<form:input path="shiftName" class="form-control"
						placeholder="Enter Shift Name" maxlength="30"/>
					<form:errors path="shiftName" cssClass="error" />
				</div>
				<div class="form-group">
					<form:input path="shiftDesc" class="form-control"
						placeholder="Enter Shift Description" maxlength="50" />
				</div>
				<input type="submit" value="Save" class="btn btn-primary">
				<a href="cancel" class="btn btn-default">Cancel</a>
			</form:form>
		</div>
	</div>
</div>
<!-- <section class="Login"> -->
<!-- 	<div align="center" class="container"> -->
<!-- 		<div class="loginbox"> -->
<!-- 		<h1>New/Edit Shift</h1> -->
<%-- 		<form:form action="saveShift" method="post" modelAttribute="shift" --%>
<%-- 			class="form-horizontal" role="form"> --%>
<%-- 			<form:hidden path="shiftId" /> --%>
<!-- 			<div class="form-group"> -->
<!-- 				<div class="col-sm-12"> -->
<%-- 					<form:input path="shiftName" class="form-control" --%>
<%-- 						placeholder="Enter Shift Name" maxlength="30"/> --%>
<%-- 					<form:errors path="shiftName" cssClass="error" /> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<div class="col-sm-12"> -->
<%-- 					<form:input path="shiftDesc" class="form-control" --%>
<%-- 						placeholder="Enter Shift Description" maxlength="50" /> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<div class="col-sm-offset-2" align="center"> -->
<!-- 					<input type="submit" value="Save" class="btn btn-primary btn-md"> -->
<!-- 					<a href="cancel" class="btn btn-primary btn-md">Cancel</a> -->
<!-- 				</div> -->
<!-- 			</div> -->
<%-- 		</form:form> --%>
<!-- 	</div> -->
<!-- 	</div> -->
<!-- </section> -->
</body>
</html>