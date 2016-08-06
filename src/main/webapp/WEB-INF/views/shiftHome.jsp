<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title>Shift Home</title>
<%@ include file="include.jsp"%>
<script type="text/javascript">
	function deleteConfirm() {
		return confirm('Are you sure you want to delete Shift?');
	}
	
	$(function() {
		$('#shiftTbl').DataTable({

			"aaData" : eval('${listShift}'),
			"aoColumns" : [ {
				"data" : "shiftName",
				"width" : "35%"
			}, {
				"data" : "shiftDesc",
				"width" : "35%"
			} ,
			 
			 {"data": "shiftId",
				"render": function(data,type,row,meta){
					return  "<div class='btn-group'><a class='btn btn-danger' href='deleteShift?shiftId="+data+"'><span class='fa fa-trash'></span></a><a class='btn btn-primary' href='editShift?shiftId="+data+"'><span class='fa fa-edit'></span></a></div>"
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
				<h1 class="text-center">Shift List</h1>
				<h4>${message}</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<a href="newShift" class="btn btn-success pull-right">
					<span class="glyphicon glyphicon-plus"></span> Create New Shift
				</a>
<!-- 				<div align="right" class="control-label"> -->
<!-- 					<ul class="list-inline"> -->
<!-- 						<li><a href="newShift"> -->
<!-- 						<img alt="addshift" title="Create New Shift" -->
<%-- 										src="${pageContext.request.contextPath}/resources/img/create.png"></a></li> --%>
<!-- 					</ul> -->
<!-- 				</div> -->
			</div>
		</div>
		<div class="row" style="margin-top:10px">
			<div class="col-md-8 col-md-offset-2">
				<table id ="shiftTbl" class="table table-striped">
					<c:if test="${fn:length(listShift) > 0}">
						<thead class="bg-primary">
							<tr>
								<th>Shift Name</th>
								<th>Shift Description</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
		<%-- 					<c:forEach var="shift" items="${listShift}" varStatus="status">
								<tr>
		
									<td>${status.index + 1}</td>
									<td>${shift.shiftName}</td>
									<td>${shift.shiftDesc}</td>
									<td><a href="editShift?shiftId=${shift.shiftId}">Edit</a>
										&nbsp;&nbsp; / &nbsp;&nbsp; <a
										href="deleteShift?shiftId=${shift.shiftId}"
										onclick="return deleteConfirm();">Delete</a></td>
								</tr>
							</c:forEach> --%>
						</tbody>
					</c:if>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
