<html>
<head>
<title>New/Edit Batch Class</title>
<%@ include file="include.jsp"%>
</head>
<body>
<%@ include file="header.jsp"%>
<section class="Login">
	<div align="center" class="container">
		<div class="loginbox">
		<h1>New/Edit Batch</h1>
		<form:form action="saveBatchClass" method="post"
			modelAttribute="batchClass" class="form-horizontal" role="form">
			<form:hidden path="classId" />
			<div class="form-group">
				<div class="col-sm-12">
					<form:input path="className" class="form-control"
						placeholder="Enter class Name" maxlength="30"/>
					<form:errors path="className" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<form:input path="classDesc" class="form-control"
						placeholder="Enter class Description" maxlength="50" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<form:radiobutton path="classType" value="Coaching" label="Coaching" />
					<form:radiobutton path="classType" value="Entry Test"
						label="Entry Test" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10">
					<form:select path="groupId" id="groupId"
						class="form-control">
						<form:option value="0" label="Select Category" />
						<form:options items="${listClassCategory}" itemValue="classCateogryid"
							itemLabel="classCategoryName" />
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