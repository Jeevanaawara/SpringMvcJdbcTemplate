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
// 			"dom":"<lftipr>",
			"aaData" : eval('${listBatchClass}'),
			"aoColumns" : [ {
				"data" : "className"
			}, {
				"data" : "classDesc"
			}, {
				"data" : "classType"
			} ,
			 
			 {"data": "classId",
				"render": function(data,type,row,meta){
					return  "<div class='btn-group' role='group'><a class='btn btn-danger' href='deleteBatchClass?classId="+data+"' onclick='javascript:deleteConfirm();' data-toggle='tooltip' title='delete'><span class='fa fa-trash'></span></a><a class='btn btn-primary' href='editBatchClass?classId="+data+"' data-toggle='tooltip' title='Edit'><span class='fa fa-edit'></span></a></div>"
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
				<h1 class="text-center">Class List</h1>
				<h4>${message}</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
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
				<a href="newBatchClass" class="btn btn-success pull-right">
					<span class="glyphicon glyphicon-plus"></span> Create New
				</a>
			</div>
		</div>
		<div class="row" style="margin-top:10px">
			<div class="col-md-8 col-md-offset-2">
				<table id="classTbl" class="table">
					<c:if test="${fn:length(listBatchClass) > 0}">
						<thead class="bg-primary">
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
