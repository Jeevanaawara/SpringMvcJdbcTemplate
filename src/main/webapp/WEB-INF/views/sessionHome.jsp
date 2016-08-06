<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title>Session Home</title>
<%@ include file="include.jsp"%>
<script type="text/javascript">
	function deleteConfirm() {
		return confirm('Are you sure you want to delete Session?');
	}
	$('#sessionTable').DataTable();
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center">Session List</h1>
				<h4>${message}</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<a href="newSection" class="btn btn-success pull-right">
					<span class="glyphicon glyphicon-plus"></span> Create
				</a>
			</div>
		</div>
		<div class="row" style="margin-top:10px">
			<div class="col-md-12">
				<table id="sessionTable" class="table table-striped">
					<c:if test="${fn:length(listSection) > 0}">
						<thead class="bg-primary">
							<tr>
								<th>S.No</th>
								<th>Session Name</th>
								<th>Session Start Date</th>
								<th>Registration Fee</th>
								<th>Monthly Fee</th>
								<th>Session Fee</th>
								<th>Class</th>
								<th>Action</th>
							<tr>
						</thead>
						<tbody>
							<c:forEach var="section" items="${listSection}" varStatus="status">
								<tr>
									<td>${status.index + 1}</td>
									<td>${section.sectionName}</td>
									<td>${section.sessionStartDate}</td>
									<td>${section.registrationFee}</td>
									<td>${section.monthlyFee}</td>
									<td>${section.sectionFee}</td>
									<td>${section.batchClass.className}</td>
									<td>
										<div class="btn-group">
											<a class="btn btn-danger" href="deleteSection?sectionId=${section.sectionId}" onclick="return deleteConfirm();"><span class="fa fa-trash"></span></a>
											<a class="btn btn-primary" href="editSection?sectionId=${section.sectionId}"><span class="fa fa-edit"></span></a>
										</div>
									</td>		
								</tr>
							</c:forEach>
						</tbody>
					</c:if>
				</table>				
			</div>
<!-- 				<div align="right" class="control-label"> -->
<!-- 					<ul class="list-inline"> -->
<!-- 						<li><a href="newSection"> -->
<!-- 						<img alt="addsession" title="Create New Session" -->
<%-- 										src="${pageContext.request.contextPath}/resources/img/create.png"> --%>
<!-- 						</a></li> -->
<!-- 					</ul> -->
<!-- 				</div> -->
		</div>
	</div>
</body>
</html>
