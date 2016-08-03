<%@ include file="header.jsp"%>
<html>
<head>
<title>Registration Entry Test</title>
<script src="${pageContext.request.contextPath}/resources/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery-ui.js"></script>
<script type="text/javascript">
	function doAjax() {
		var classId = $("#classId").val();
		$.ajax({
			url : 'time',
			data : ({
				classId : classId
			}),
			success : function(response) {
				var obj = JSON.parse(response);
				$("#studentRollNo").val(response);
			}
		});
		selectSessionByClass();
	}

	function doSessionPrice() {
		var sectionId = $("select#sectionId").val();
		$.ajax({
			url : 'sessionFee',
			data : ({
				sectionId : sectionId
			}),
			success : function(response) {
				//	var obj = JSON.parse(response);
				$("#sectionFee").val(response.sectionFee);
				//    alert(sectionId +"-----------"+response.sectionFee);
			}
		});
		doTotalSeats();
	}
	$(document).ready(function aaa() {
		$("#datepicker").datepicker();
	});

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

	function selectClassByCategory() {

		$('select#classId').empty();
		var classCategory = $('input[type="radio"]:checked').val();
		$.ajax({
			url : 'listClassByClassCategory',
			data : ({
				classCategory : classCategory
			}),
			success : function(data) {
				var html = '';
				var len = data.length;
				for (var i = 0; i < len; i++) {
					html += '<option value="' + data[i].classId + '">'
							+ data[i].className + '</option>';
				}
				$('select#classId').append(html);
			}
		});
	}
	function doTotalSeats() {
		var sectionId = $("select#sectionId").val();
		var maxRollNo =$("#studentRollNo").val();
		$.ajax({
			url : 'getTotalSeats',
			data : ({
				sectionId : sectionId
			}),
			success : function(response) {
				$("#totalSeats").val(response - maxRollNo);
			//	alert(response - maxRollNo);
			}
		});
		selectSessionByClass();
	}
</script>
</head>
<body>
	<div class="container">
		<h1 align="center">Student Registration (Entry Test)</h1>
		<br>
		<form:form action="saveStudent?${_csrf.parameterName}=${_csrf.token}" method="post" modelAttribute="student"
			class="form-horizontal" role="form" enctype="multipart/form-data">

			<form:hidden path="studentId" />
			<div class="form-group" align="center">
				<label class="control-label col-sm-2" for="studentFirstName">First
					Name </label>
				<div class="col-sm-7">
					<form:input path="studentFirstName" class="form-control"
						placeholder="Enter First Name" maxlength="50" />
					<form:errors path="studentFirstName" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="program">Program</label>
				<div class="col-sm-4">
					&nbsp;&nbsp;
					<form:radiobutton path="program" value="3"
						onclick="selectClassByCategory()" label="Medical" />
					&nbsp;&nbsp;
					<form:radiobutton path="program"
						onclick="selectClassByCategory()" value="4" label="Engg" />
					&nbsp;&nbsp;
					<form:radiobutton path="program"
						onclick="selectClassByCategory()" value="5" label="Other" />
				</div>
				<label class="control-label" style="float: left;" for="class">Class &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label>
				<div class="col-sm-2">
					<form:select path="classId" id="classId" onchange="doAjax()"
						class="form-control">
						<form:option value="0" label="Select Class" />
						<form:options items="${listBatchClass}" itemValue="classId"
							itemLabel="className" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="studentRollNo">Student
					Roll# </label>
				<div class="col-sm-4">
					<form:input path="studentRollNo" value="" id="studentRollNo"
						class="form-control" placeholder="Enter studentRollNo" maxlength="2" />
				</div>
				<label class="control-label" style="float: left;" for="shift">Shift &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
				<div class="col-sm-2">
					<form:select path="shiftId" class="form-control">
						<form:option value="0" label="Select Shift" />
						<form:options items="${listShift}" itemValue="shiftId"
							itemLabel="shiftName" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="section">Session</label>
				<div class="col-sm-4">
					<form:select path="sectionId" id="sectionId"
						onclick="doSessionPrice()" class="form-control">
						<form:option value="0" label="Select Session" />
						<form:options items="${listSection}" itemValue="sectionId"
							itemLabel="sectionName" />
					</form:select>
				</div>
				<label class="control-label" style="float: left;" for="sessionFee">Session
					Fee</label>
				<div class="col-sm-2">
					<form:input path="fees.sessionFee" id="sectionFee"
						class="form-control" placeholder="Enter Session Fee" maxlength="5" />
				</div>
			</div>
			<form:hidden path="fees.tuitionFee" />
			<form:hidden path="fees.acCharges" />
			<div class="form-group">
				<label class="control-label  col-sm-2" style="float: left;" for="feeReceived">Amount
					Received</label>
				<div class="col-sm-4">
					<form:input path="fees.feeReceived" id="feeReceived"
						class="form-control" onfocusout="return getBalanceEntryTest();"
						placeholder="Enter Amount Received" maxlength="5" />
				</div>
			<label class="control-label" style="float: left;" for="balance"> Bal.
					Amount</label>
				<div class="col-sm-2">

					<form:input path="fees.feeBalance" id="feeBalance"
						class="form-control" placeholder="Fee Balance " maxlength="5" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="totalSeats">Total
					Seats </label>
				<div class="col-sm-4">
					<form:input path="sessionClass.totalSeats" id="totalSeats"
						class="form-control" readonly="true" maxlength="2" />
				</div>
				<label class="control-label" style="float: left;" for="balanceDueDate">Balance
					Date</label>
				<div class="col-sm-2">
					<form:input path="fees.balanceDueDate" id="datepicker"
						class="form-control" placeholder="Enter balanceDueDate" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="imageName">Image</label>
				<div class="col-sm-8">
					<input type="file" name="file"><br />
					<form:hidden path="imageName" class="form-control"
						placeholder="Enter imageName" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="remarks">Remarks</label>
				<div class="col-sm-7">
					<form:textarea path="remarks" class="form-control"
						placeholder="Enter Remarks" maxlength="100" />
				</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10" align="center">
					<input type="submit" value="Save" class="btn btn-primary btn-md">
					<a href="cancel" class="btn btn-primary btn-md">Cancel</a>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>