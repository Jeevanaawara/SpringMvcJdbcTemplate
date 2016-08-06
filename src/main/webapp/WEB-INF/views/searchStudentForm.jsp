<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title>Search Student</title>
<%@ include file="include.jsp"%>
<script type="text/javascript">
function deleteConfirm() {
	return confirm('Are you sure you want to delete this Student ?');
}

function selectSessionByClass() {

		$('select#sectionId').empty();
		var classId = $("select#classId").val();
		$.ajax({
			url : 'selectSessionByClass',
			data : ({
				classId : classId
			}),
			success : function(data) {
				var html = '';
				var len = data.length;
				for (var i = 0; i < len; i++) {
					html += '<option value="' + data[i].sectionId + '">'
							+ data[i].sectionName + '</option>';
				}
				$('select#sectionId').append(html);
			}
		});
	}
	</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="cotainer">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center">Search Student</h1>
				<h4>${message}</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<form:form action="searchStudentList" method="post"
					modelAttribute="student" class="" role="form">
					<div class="form-group">
						<form:input path="studentFirstName" class="form-control"
							placeholder="Enter Student Name" />
					</div>
					<div class="form-group">
						<form:input path="studentRollNo" class="form-control"
							placeholder="Enter student Roll No" />
					</div>
					<div class="form-group">
						<form:select path="classId" onclick="selectSessionByClass()" class="form-control">
							<form:option value="0" label="Select Class" />
							<form:options items="${listClass}" itemValue="classId"
								itemLabel="className" />
						</form:select>
					</div>
					<div class="form-group">
						<form:select path="sectionId" class="form-control">
							<form:option value="0" label="Select Session" />
							<form:options items="${listSection}" itemValue="sectionId"
								itemLabel="sectionName" />
						</form:select>
					</div>
					<div class="form-group">
						<div class="pull-right">
							<a href="cancel" class="btn btn-default">Cancel</a>
							<input type="submit" value="Search" class="btn btn-primary">
						</div>
					</div>
				</form:form>			
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped table-bordered">
					<c:if test="${fn:length(listStudent) > 0}">
						<thead class="bg-primary">			
							<tr>
								<th>S.No</th>
								<th>Name</th>
								<th>Roll.No</th>
								<th>Class</th>
								<th>Session</th>
								<th>Shift</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="student" items="${listStudent}" varStatus="status">
								<tr>
									<td>${status.index + 1}</td>
									<td>${student.studentFirstName}</td>
									<td>${student.studentRollNo}</td>
									<td>${student.batchClass.className}</td>
									<td>${student.sessionClass.sectionName}</td>
									<td>${student.shift.shiftName}</td>
									<td>
										<div class="btn-group">
											<a class="btn btn-default" href="editStudent?studentId=${student.studentId}" data-toggle="tooltip" title="Edit">
												<span class="fa fa-pencil"></span>
											</a>
											<a class="btn btn-default"  href="deleteStudent?studentId=${student.studentId}" data-toggle="tooltip" title="Delete" onclick="return deleteConfirm();">
												<span class="fa fa-trash"></span>
											</a>
											<a class="btn btn-default"  href="studentTransferForm?studentId=${student.studentId}"  data-toggle="tooltip" title="Transfer">
												<span class="fa fa-exchange"></span>
											</a>
											<a class="btn btn-default"  href="studentMonthlyFee?studentId=${student.studentId}" onclick=" return showDialog();"  data-toggle="tooltip" title="Fee">
												<span class="fa fa-money"></span>
											</a>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</c:if>
				</table>			
			</div>
		</div>
	</div>
</body>
</html>