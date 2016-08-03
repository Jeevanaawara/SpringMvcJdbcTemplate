<%@ include file="header.jsp"%>
<html>
<head>
<title>New/Edit Session</title>
<script src="${pageContext.request.contextPath}/resources/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".desc").hide();
		$("input[name$='classType']").click(function() {
			var test = $(this).val();
			$(".desc").hide();
			$("#" + test).show();
		});
	});
	$(document).ready(function aaa() {
		$("#datepicker").datepicker();
	});
	function selectSessionByClass() {

		$('select#classId').empty();
		var classType = $('input[type="radio"]:checked').val();
		$.ajax({
			url : 'listClassByClassType',
			data : ({
				classType : classType
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
</script>
</head>
<body>

	<div align="center" class="container">

		<h1>New/Edit Session</h1>
		<form:form action="saveSection" method="post" modelAttribute="session"
			class="form-horizontal" role="form">
			<form:hidden path="sectionId" />
			<div class="form-group">
				<label class="control-label col-sm-2" for="classType">Class
					Type </label>
				<div class="col-sm-3">
					<form:radiobutton path="batchClass.classType" id="classType"
						name="classType" value="Coaching" label="Coaching" onclick="selectSessionByClass()"  />
					<form:radiobutton path="batchClass.classType" id="classType"
						name="classType" value="Entry" label="Entry Test" onclick="selectSessionByClass()" />
				</div>
				<label class="control-label col-sm-2" for="class">Class </label>
				<div class="col-sm-3">
					<form:select path="batchClass.classId" id="classId"
						class="form-control">
						<form:option value="0" label="Select Class" />
						<form:options items="${listBatchClass}" itemValue="classId"
							itemLabel="className" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="sessionName">Session
					Name </label>
				<div class="col-sm-8">
					<form:input path="sectionName" class="form-control"
						placeholder="Enter Session Name" maxlength="50" />
					<form:errors path="sectionName" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="sessionDesc">Session
					Description </label>
				<div class="col-sm-8">
					<form:input path="sectionDesc" class="form-control"
						placeholder="Enter Session Description" maxlength="100" />
				</div>
			</div>
			<div id="Coaching" class="desc">
				<div class="form-group">
					<label class="control-label col-sm-2" for="registrationFee">Registration
						Fee </label>
					<div class="col-sm-3">
						<form:input path="registrationFee" class="form-control"
							placeholder="Enter Registration  Fee" maxlength="5" />
					</div>
					<label class="control-label col-sm-2" for="monthlyFee">Monthly
						Fee </label>
					<div class="col-sm-3">
						<form:input path="monthlyFee" class="form-control"
							placeholder="Enter Monthly Fee" alt="Enter Monthly Fee"  maxlength="5"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="acCharges">AC
						Charges </label>
					<div class="col-sm-3">
						<form:input path="acChargres" class="form-control"
							placeholder="Enter AC Chargres" maxlength="5"/>
					</div>
				</div>
			</div>
			<div id="Entry" class="desc">
				<div class="form-group">
					<label class="control-label col-sm-2" for="sessionFee">Session
						Fee</label>
					<div class="col-sm-3">
						<form:input path="sectionFee" class="form-control"
							placeholder="Enter session Fee" maxlength="5" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="sessionStartDate">Session
					Start Date </label>
				<div class="col-sm-3">
					<form:input path="sessionStartDate" id="datepicker"
						class="form-control" placeholder="Enter Session Start Date" />
				</div>
				<label class="control-label col-sm-2" for="totalSeats">Total
					Seats </label>
				<div class="col-sm-3">
					<form:input path="totalSeats" id="totalSeats" class="form-control"
						placeholder="Enter Total Seats" maxlength="2" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10" >
					<input type="submit" value="Save" class="btn btn-primary btn-md">
					<a href="cancel" class="btn btn-primary btn-md">Cancel</a>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>