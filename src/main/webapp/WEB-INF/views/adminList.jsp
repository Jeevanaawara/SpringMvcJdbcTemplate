<%@ include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title>List Admin</title>


<script type="text/javascript">
	function deleteConfirm() {
		return confirm('Are you sure you want to delete User?');
	}
	$(function() {
		$('#adminTbl')
				.DataTable(
						{

							"aaData" : eval('${listAdmin}'),
							"aoColumns" : [
									{
										"data" : "adminName",
										"width" : "35%"
									},
									{
										"data" : "email",
										"width" : "35%"
									},

									{
										"data" : "adminName",
										"width" : "30%",
										"render" : function(data, type, row,
												meta) {
											return "<a href='deleteAdmin?adminName="
													+ data
													+ "'>Delete</a> / <a href='editAdmin?adminName="
													+ data + "'>Edit</a>"
										}
									} ],
							"bFilter" : true,
							"bSort" : true,
							"bPaginate" : true,
						});
	});
</script>
</head>
<body>
	<div align="center" class="container">
		<h1>Admin List</h1>
		<h4>${message}</h4>
		<div align="right" class="control-label">
			<ul class="list-inline">
				<li><a href="newAdmin"> <img alt="addAdmin"
						title="Create new Admin User"
						src="${pageContext.request.contextPath}/resources/img/create.png">
				</a></li>
			</ul>
		</div>
		<table id="adminTbl" border="1" class="table table-striped">
			<c:if test="${fn:length(listAdmin) > 0}">
				<thead>
					<tr>
						<th>Name</th>
						<th>Admin Email</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</c:if>
		</table>
	</div>
</body>
</html>