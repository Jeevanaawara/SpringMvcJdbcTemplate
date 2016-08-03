<%@ include file="header.jsp"%>
<html>
<head>
<title>Registration Entry Test</title>
<script src="${pageContext.request.contextPath}/resources/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function aaa() {
		$("#datepicker").datepicker();
	});
</script>
</head>
<body>
	<h4>${message}</h4>
	<div align="center" class="container">
		<h1 align="center">Student Detail</h1>
		<form:form action="" method="post" modelAttribute="studentOtherInfo"
			class="form-horizontal" role="form">
			<div class="form-group" style="border: 2px solid;">
				<label class="control-label  col-sm-2" for="studentFirstName">First
					Name </label>
				<div class="col-sm-3">
					<c:out value="${ studentOtherInfo.student.studentFirstName}"></c:out>
				</div>
				<label class="control-label  col-sm-2" for="studentRollNo">Roll
					No :</label>
				<div class="col-sm-3">
					<c:out value="${ studentOtherInfo.student.studentRollNo}"></c:out>
				</div>
			</div>
			<%-- 			  <img align="right" alt="Student" src="${pageContext.request.contextPath}/resources/studentImages/${ studentOtherInfo.student.imageName}"
				width="50" height="50">  --%>
			<div class="form-group" style="border: 2px solid;">
				<label class="control-label col-sm-2" for="sectionName">Session
					:</label>
				<div class="col-sm-3">
					<c:out value="${ studentOtherInfo.session.sectionName}"></c:out>
				</div>
				<label class="control-label col-sm-2" for="shiftName">ShiftName
					:</label>
				<div class="col-sm-3">

					<c:out value="${ studentOtherInfo.shift.shiftName}"></c:out>
				</div>
			</div>

			<div class="form-group" style="border: 2px solid;">
				<label class="control-label col-sm-2" for="fatherName">Father
					Name :</label>
				<div class="col-sm-3">
					<c:out value="${ studentOtherInfo.fatherName}"></c:out>
				</div>
				<label class="control-label col-sm-2" for="nationality">Nationality
					:</label>
				<div class="col-sm-3">
					<c:out value="${ studentOtherInfo.nationality}"></c:out>
				</div>
			</div>
			<div class="form-group" style="border: 2px solid;">
				<label class="control-label col-sm-2" for="tempAddress">Present
					Address :</label>

				<div class="col-sm-3">
					<c:out value="${ studentOtherInfo.tempAddress}"></c:out>
				</div>

			</div>
			<div class="form-group" style="border: 2px solid;">
				<label class="control-label col-sm-2" for="studentEmail">Email
					:</label>
				<div class="col-sm-3">
					<c:out value="${ studentOtherInfo.studentEmail}"></c:out>
				</div>
				<label class="control-label col-sm-2" for="mobileNo">Mobile.No
					:</label>
				<div class="col-sm-3">
					<c:out value="${ studentOtherInfo.mobileNo}"></c:out>
				</div>

				<div class="col-sm-3" hidden="true">
					<label class="control-label" for="boarderDayScholar">Boarder
						/DayScholar :</label>
					<c:out value="${ studentOtherInfo.boarderDayScholar}"></c:out>
				</div>
			</div>
			<div class="form-group" style="border: 2px solid;">
				<div class="col-sm-3" align="left" hidden="true">
					<label class="control-label" for="guardian">Guardian/Parent
						:</label>
					<c:out value="${ studentOtherInfo.guardian}" ></c:out>
				</div>
				<label class="control-label col-sm-2" for="guardianName">Guardian
					Name :</label>
				<div class="col-sm-3">
					<c:out value="${ studentOtherInfo.guardianName}"></c:out>
				</div>
				<label class="control-label col-sm-2" for="guardianRelation">Relation
					:</label>
				<div class="col-sm-3">

					<c:out value="${ studentOtherInfo.guardianRelation}"></c:out>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<table border="1" class="table table-striped">
						<thead>
							<tr>
								<th width="160px">Institute</th>
								<th width="160px">Class</th>
								<th width="90px">Passing Year</th>
								<th width="110px">Board</th>
								<th width="90px">Roll.No</th>
								<th width="110px">Total Marks</th>
								<th width="110px">Obtained Marks</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><form:input path="studentEduInfo.instituteName"
										class="form-control" /></td>
								<td><form:select path="classId" class="form-control">
										<form:option value="0" label="Select Class" />
										<form:options items="${listBatchClass}" itemValue="classId"
											itemLabel="className" />
									</form:select></td>
								<td><form:input path="studentEduInfo.passyear"
										class="form-control" /></td>
								<td><form:input path="studentEduInfo.eduBorad"
										class="form-control" /></td>
								<td><form:input path="studentEduInfo.eduRollNo"
										class="form-control" /></td>
								<td><form:input path="studentEduInfo.totalMarks"
										class="form-control" /></td>
								<td><form:input path="studentEduInfo.obtainedmarks"
										class="form-control" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10" align="center">
					<a href="cancel" class="btn btn-primary btn-md">Cancel</a>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>