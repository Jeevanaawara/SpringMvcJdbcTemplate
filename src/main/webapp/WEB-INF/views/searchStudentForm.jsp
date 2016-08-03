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
	<h4>${message}</h4>
	<section class="Login">
		<div align="center" class="container">
			<div class="loginbox">
				<h1>Search Student</h1>
				<form:form action="searchStudentList" method="post"
					modelAttribute="student" class="form-horizontal" role="form">
					<div class="form-group">
						<div class="col-sm-12">
							<form:input path="studentFirstName" class="form-control"
								placeholder="Enter Student Name" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<form:input path="studentRollNo" class="form-control"
								placeholder="Enter student Roll No" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<form:select path="classId" onclick="selectSessionByClass()" class="form-control">
								<form:option value="0" label="Select Class" />
								<form:options items="${listClass}" itemValue="classId"
									itemLabel="className" />
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<form:select path="sectionId" class="form-control">
								<form:option value="0" label="Select Session" />
								<form:options items="${listSection}" itemValue="sectionId"
									itemLabel="sectionName" />
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12" align="center">
							<input type="submit" value="Search"
								class="btn btn-primary btn-md"> <a href="cancel"
								class="btn btn-primary btn-md">Cancel</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</section>
	<table border="1" class="table table-striped">
		<c:if test="${fn:length(listStudent) > 0}">
			<thead>

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
						<td><a href="editStudent?studentId=${student.studentId}">
						<img alt="Edit" title="Edit Student" src="${pageContext.request.contextPath}/resources/img/edit.png">
						</a>
							/  <a
							href="deleteStudent?studentId=${student.studentId}" onclick="return deleteConfirm();">
							<img alt="delete" title="Delete Student" src="${pageContext.request.contextPath}/resources/img/delete.png"></a> /
							 <a
							href="studentTransferForm?studentId=${student.studentId}">
							<img alt="Transfer" title="Transfer Student" src="${pageContext.request.contextPath}/resources/img/transfer.png"></a>
							/  <a
							href="studentMonthlyFee?studentId=${student.studentId}" onclick=" return showDialog();">
							<img alt="MonthlyFee" title="Pay Monthly Fee" src="${pageContext.request.contextPath}/resources/img/payment.png"></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</c:if>
	</table>
</body>
</html>