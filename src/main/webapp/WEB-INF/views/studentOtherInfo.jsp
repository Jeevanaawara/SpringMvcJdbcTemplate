<html>
<head>
<title>Registration Entry Test</title>
	<%@ include file="include.jsp"%>
<script src="${pageContext.request.contextPath}/resources/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function aaa() {
		$("#datepicker").datepicker();
	});
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<h4>${message}</h4>
	<div align="center" class="container">
		<h1 align="center">Student Detail Registration</h1>
		<form:form action="saveStudentOtherInfo" method="post"
			modelAttribute="studentOtherInfo" class="form-horizontal" role="form">
			<form:hidden path="studentId" />

			<h2 align="left">Student Details</h2>
			<div class="form-group">
	<label class="control-label col-sm-2" for="classType">Father Name </label>
				<div class="col-sm-8">
					<form:input path="fatherName" class="form-control"
						placeholder="Enter Father Name" maxlength="50" />
				</div>
			</div>
			<div class="form-group">
							<label class="control-label col-sm-2" for="classType">DOB </label>
				<div class="col-sm-3">
					<form:input path="studentDob" id="datepicker"
						placeholder="Enter Dob" class="form-control" />
				</div>
			<label class="control-label col-sm-2" for="classType">Class
					Type </label>
				<div class="col-sm-3">
					<form:input path="nationality" placeholder="Enter Nationality"
						class="form-control" maxlength="20" />
				</div>
			</div>
			<div class="form-group">
		<label class="control-label col-sm-2" for="classType">Present Address </label>
				<div class="col-sm-8">
					<form:input path="tempAddress" class="form-control"
						placeholder="Enter Present Address" maxlength="100" />
					<form:errors path="tempAddress" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
			<label class="control-label col-sm-2" for="classType">Perminent Address </label>
				<div class="col-sm-8">
					<form:input path="perminentAddress" class="form-control"
						placeholder="Enter Permanent Address" maxlength="100" />
					<form:errors path="perminentAddress" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
		<label class="control-label col-sm-2" for="classType">Contact.No </label>
				<div class="col-sm-3">
					<form:input path="phoneNo" placeholder="Enter Phone No"
						class="form-control" maxlength="11" />
				</div>
	<label class="control-label col-sm-2" for="classType">MObile.No </label>
				<div class="col-sm-3">
					<form:input path="mobileNo" placeholder="Enter Mobile No"
						class="form-control" maxlength="11" />
				</div>
			</div>
			<div class="form-group">
		<label class="control-label col-sm-2" for="classType">Email </label>
				<div class="col-sm-3">
					<form:input path="studentEmail" placeholder="Enter  Email"
						class="form-control" maxlength="50" />
				</div>
				<div class="col-sm-6" align="left">
					<div class="col-sm-3">
						<form:radiobutton path="boarderDayScholar" value="Boarder"
							label="Boarder" />
					</div>
					<div class="col-sm-4">
						<form:radiobutton path="boarderDayScholar" value="DayScholar"
							label="DayScholar" />
					</div>
				</div>

			</div>

			<h2 align="left">Parent/Guardian Details</h2>
			<div class="form-group">
				<div class="col-sm-5" align="left">
					<div class="col-sm-4">
						<form:radiobutton path="guardian" value="Parent" label="Parent" />
					</div>
					<div class="col-sm-4">
						<form:radiobutton path="guardian" value="Guardian"
							label="Guardian" />
					</div>
				</div>
		<label class="control-label col-sm-2" for="classType">Relation </label>
				<div class="col-sm-3">
					<form:input path="guardianRelation"
						placeholder="Enter Guardian Relation" class="form-control" maxlength="20" />
				</div>
			</div>

			<div class="form-group">
		<label class="control-label col-sm-2" for="classType">Guardian.Name </label>
				<div class="col-sm-3">
					<form:input path="guardianName" class="form-control"
						placeholder="Enter Guardian Name" maxlength="50" />
					<form:errors path="guardianName" cssClass="error" />
				</div>
			<label class="control-label col-sm-2" for="classType">Guardian.CNIC
					Type </label>
				<div class="col-sm-3">
					<form:input path="guardianCNIC" class="form-control"
						placeholder="Enter Guardian CNIC" maxlength="15" />
					<form:errors path="guardianCNIC" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-3">
					<form:input path="guardianContact"
						placeholder="Enter Guardian Contact" class="form-control" maxlength="11" />
				</div>
				<div class="col-sm-3">
					<form:input path="guardianCell" placeholder="Enter Cell No "
						class="form-control" maxlength="11" />
				</div>
				<div class="col-sm-4">
					<form:input path="guardianEmail" placeholder="Enter Guardian Email"
						class="form-control" maxlength="30" />
				</div>
			</div>

			<h2 align="left">Education Information</h2>

			<div class="form-group">
				<div class="col-sm-10">
					<table border="1" class="table table-striped">
						<thead>
							<tr>
								<th width="150px">Institute</th>
								<th width="150px">Class</th>
								<th width="80px">Passing Year</th>
								<th width="100px">Board</th>
								<th width="80px">Roll.No</th>
								<th width="100px">Total Marks</th>
								<th width="100px">Obtained Marks</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><form:input path="studentEduInfo.instituteName"
										class="form-control"  maxlength="50"/></td>
								<td><form:select path="classId" class="form-control">
										<form:option value="0" label="Select Class" />
										<form:options items="${listBatchClass}" itemValue="classId"
											itemLabel="className" />
									</form:select></td>
								<td><form:input path="studentEduInfo.passyear"
										class="form-control" maxlength="4"/></td>
								<td><form:input path="studentEduInfo.eduBorad"
										class="form-control" maxlength="10" /></td>
								<td><form:input path="studentEduInfo.eduRollNo"
										class="form-control" maxlength="10" /></td>
								<td><form:input path="studentEduInfo.totalMarks"
										class="form-control" maxlength="6" /></td>
								<td><form:input path="studentEduInfo.obtainedmarks"
										class="form-control" maxlength="6" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10" align="center">
					<input type="submit" value="Save" class="btn btn-primary btn-md">
					<a href="cancel" class="btn btn-primary btn-md">Cancel</a>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>