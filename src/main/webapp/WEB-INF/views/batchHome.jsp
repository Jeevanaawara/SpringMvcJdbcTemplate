<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title>Class Home</title>
<%@ include file="include.jsp"%>
<script type="text/javascript">
	function deleteConfirm() {
		return confirm('Are you sure you want to delete Class?');
	}
	
	$(function() {
		$('#classTbl').DataTable({

			"aaData" : eval('${listBatchClass}'),
			"aoColumns" : [ {
				"data" : "className",
				"width" : "25%"
			}, {
				"data" : "classDesc",
				"width" : "35%"
			}, {
				"data" : "classType",
				"width" : "30%"
			} ,
			 
			 {"data": "classId",
				"render": function(data,type,row,meta){
					return  "<a href='deleteBatchClass?classId="+data+"' onclick='javascript:deleteConfirm();'>Delete</a> / <a href='editBatchClass?classId="+data+"'>Edit</a>"
				 }
			 }],
			"bFilter" : true,
			"bSort" : true,
			"bPaginate" : true,
		});
	});
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">				
				<h1>Class List</h1>
				<h4>${message}</h4>
<!-- 				<div class="control-label"> -->
<!-- 					<ul class="list-inline"> -->
<!-- 						<li> -->
<!-- 							<a href="newBatchClass"> -->
<!-- 							<img alt="addClass" title="Create New Class" -->
<%-- 								src="${pageContext.request.contextPath}/resources/img/create.png"> --%>
<!-- 							</a> -->
<!-- 						</li> -->
<!-- 					</ul> -->
<!-- 				</div> -->
				<button class="btn btn-warning pull-right">
					Create New
				</button>
				<table border="1"  id="classTbl" class="table table-striped">
					<c:if test="${fn:length(listBatchClass) > 0}">
						<thead>
							<tr>
								<th>Class Name</th>
								<th>Class Description</th>
								<th>Class Type</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
		<%-- 					<c:forEach var="batchClass" items="${listBatchClass}"
								varStatus="status">
								<tr>
									<td>${status.index + 1}</td>
									<td>${batchClass.className}</td>
									<td>${batchClass.classDesc}</td>
									<td>${batchClass.classType}</td>
									<td><a href="editBatchClass?classId=${batchClass.classId}">Edit</a>
										&nbsp;&nbsp; / &nbsp;&nbsp; <a
										href="deleteBatchClass?classId=${batchClass.classId}"
										onclick="return deleteConfirm();">Delete</a></td>
		
								</tr>
							</c:forEach>
		
		 --%>				</tbody>
					</c:if>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
