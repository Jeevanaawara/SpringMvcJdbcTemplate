
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title>Search Student Detail</title>
<%@ include file="include.jsp"%>
<script type="text/javascript">
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
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<h4>${message}</h4>
				<h1>Search Student Detail</h1>
				<form:form action="searchStudentDetailList" method="post"
					modelAttribute="student" class="form-horizontal" role="form">
					<div class="form-group">
						<div class="col-sm-12">
							<form:select path="classId" onclick="selectSessionByClass()"
								class="form-control">
								<form:option value="0" label="Select Class" />
								<form:options items="${listBatchClass}" itemValue="classId"
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
					<input type="submit" value="Search" class="btn btn-primary btn-md pull-right">
				</form:form>
			</div>
		</div>
		<div class="row" style="margin-top:10px;">
			<div class="col-md-8 col-md-offset-2">
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
									<td>
										<div class="btn-group" role="group">
											<a href="addStudentOtherInfo?studentId=${student.studentId}" class="btn btn-default" data-toggle="tooltip" title="Add Student Other Info"><span class="fa fa-user-plus"></span></a>
											<a href="addProgressReport?studentId=${student.studentId}"  class="btn btn-default" data-toggle="tooltip" title="Add Progress Report"><span class="fa fa-bar-chart"></span></a>
											<a href="viewStudentOtherInfo?studentId=${student.studentId}"  class="btn btn-default" data-toggle="tooltip" title="View Student Other Info"><span class="fa fa-info"></span></a>
											<a href="printProgressReport?studentId=${student.studentId}" class="btn btn-default" data-toggle="tooltip" title="Print Progress Report"><span class="fa fa-print"></span></a>
										</div>
<%-- 										<a href="addStudentOtherInfo?studentId=${student.studentId}"> --%>
<!-- 											<img alt="addStudentDetail" title="Add Student Detail" -->
<%-- 											src="${pageContext.request.contextPath}/resources/img/add.png"></a> --%>
<%-- 										/ <a href="addProgressReport?studentId=${student.studentId}"> --%>
<!-- 											<img alt="addProgressReport" title="Add Progress Report" -->
<%-- 											src="${pageContext.request.contextPath}/resources/img/add.png"> --%>
<%-- 										</a> / <a href="viewStudentOtherInfo?studentId=${student.studentId}"> --%>
<!-- 											<img alt="ViewDetail" title="View Detail" -->
<%-- 											src="${pageContext.request.contextPath}/resources/img/viewDetail.png"> --%>
<%-- 										</a> / <a href="printProgressReport?studentId=${student.studentId}"> --%>
<!-- 										<img alt="Print Progress Report" title="Print Progress Report" -->
<%-- 												src="${pageContext.request.contextPath}/resources/img/print.png"></a> --%>
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