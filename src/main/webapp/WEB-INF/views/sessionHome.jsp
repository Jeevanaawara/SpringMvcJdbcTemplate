<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title>Session Home</title>
<%@ include file="include.jsp"%>
<script type="text/javascript">
	function deleteConfirm() {
		return confirm('Are you sure you want to delete Session?');
	}
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<h1>Session List</h1>
				<h4>${message}</h4>
				<div align="right" class="control-label">
					<ul class="list-inline">
						<li><a href="newSection">
						<img alt="addsession" title="Create New Session"
										src="${pageContext.request.contextPath}/resources/img/create.png">
						</a></li>
					</ul>
				</div>
				<table border="1" class="table table-striped">
					<c:if test="${fn:length(listSection) > 0}">
						<thead>
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
									<td><a href="editSection?sectionId=${section.sectionId}">Edit</a>
										&nbsp;&nbsp; / &nbsp;&nbsp; <a
										href="deleteSection?sectionId=${section.sectionId}"
										onclick="return deleteConfirm();">Delete</a></td>
		
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
