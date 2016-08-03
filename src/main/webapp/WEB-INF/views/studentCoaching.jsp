<%@ include file="header.jsp"%>
<html>
<head>
<title>Registration Coaching</title>
<script src="${pageContext.request.contextPath}/resources/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery-ui.js"></script>
<script type="text/javascript">
    function doAjax() {
  var classId = $("#classId").val();
      $.ajax({
        url: 'time',
        data: ({classId : classId}),
        success: function(response) {
        	var obj = JSON.parse(response);
          $("#studentRollNo").val(response);
     //     alert(classId +"-----------"+obj);
        }
      });
      selectSessionByClass();
    }
    function doSessionPrice() {
    	  var sectionId = $("#sectionId").val();
    	      $.ajax({
    	        url: 'sessionFee',
    	        data: ({sectionId : sectionId}),
    	        success: function(response) {
    	          $("#addmissionFee").val(response.registrationFee);
    	          $("#tuitionFee").val(response.monthlyFee);
    	          $("#acCharges").val(response.acChargres);
    	//          alert(sectionId +"-----------"+response.registrationFee);
    	        }
    	      });
    	      doTotalSeats();
    	    }
    $(document).ready(  function aaa() {
        $("#datepicker").datepicker();
      });
  function selectSessionByClass() {
    	
    	$('select#sectionId').empty();
    	  var classId = $("select#classId").val();
    	      $.ajax({
    	        url: 'selectSessionByClass',
    	        data: ({classId : classId}),
    	        success: function(data) {
    	        	var html = '';
                    var len = data.length;
                    for(var i=0; i<len; i++){
                         html += '<option value="' + data[i].sectionId + '">' + data[i].sectionName + '</option>';
                     }
                    $('select#sectionId').append(html);
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
				alert(response - maxRollNo);
			}
		});
		selectSessionByClass();
	}
  </script>
</head>
<body>
	<div class="container">
		<h1 align="center">Student Registration (Coaching)</h1>
		<br>
		<form:form action="saveStudentCoaching${_csrf.parameterName}=${_csrf.token}" method="post"
			modelAttribute="student" class="form-horizontal" role="form"
			enctype="multipart/form-data">

			<form:hidden path="studentId" />
			<div class="form-group">
				<label class="control-label col-sm-2" for="studentFirstName">First
					Name </label>
				<div class="col-sm-8">
					<form:input path="studentFirstName" class="form-control"
						placeholder="Enter First Name" maxlength="50" />
					<form:errors path="studentFirstName" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="board">Board</label>
				<div class="col-sm-3">
					<form:radiobutton path="board" value="Federal" label="Federal" />
					<form:radiobutton path="board" value="Rawalpindi"
						label="Rawalpindi" />
				</div>
				<label class="control-label col-sm-2" for="class">Class</label>
				<div class="col-sm-3">
					<form:select path="classId" id="classId" onchange="doAjax()" class="form-control">
						<form:option value="0" label="Select Class" />
						<form:options items="${listBatchClass}" itemValue="classId"
							itemLabel="className" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="studentRollNo">Student
					Roll# </label>
				<div class="col-sm-3">
					<form:input path="studentRollNo" id="studentRollNo" class="form-control"
						placeholder="Enter studentRollNo" maxlength="2" />
				</div>
				<label class="control-label col-sm-2" for="month"> Month </label>
				<div class="col-sm-3">
					<form:select path="fees.monthName" class="form-control">
						<form:option value="0" label="Select Month" />
						<form:option value="JAN" label="JAN" />
						<form:option value="FEB" label="FEB" />
						<form:option value="MAR" label="MAR" />
						<form:option value="APR" label="APR" />
						<form:option value="MAY" label="MAY" />
						<form:option value="JUN" label="JUN" />
						<form:option value="JUL" label="JUL" />
						<form:option value="AUG" label="AUG" />
						<form:option value="SEP" label="SEP" />
						<form:option value="OCT" label="OCT" />
						<form:option value="NOV" label="NOV" />
						<form:option value="DEC" label="DEC" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="shift">Shift</label>
				<div class="col-sm-3">
					<form:select path="shiftId" class="form-control">
						<form:option value="0" label="Select Shift" />
						<form:options items="${listShift}" itemValue="shiftId"
							itemLabel="shiftName" />
					</form:select>
				</div>
				<label class="control-label col-sm-2" for="section">Session</label>
				<div class="col-sm-3">
					<form:select path="sectionId" id="sectionId" onclick="doSessionPrice()" class="form-control">
						<form:option value="0" label="Select Session" />
						<form:options items="${listSection}" itemValue="sectionId"
							itemLabel="sectionName" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="admissionFees">Registration
					Fee</label>
				<div class="col-sm-3">
					<form:input path="fees.addmissionFee" id="addmissionFee"
						class="form-control" placeholder="Enter admission Fees" maxlength="5" />
				</div>
				<label class="control-label col-sm-2" for="tuitionFees">Tuition
					Fee</label>
				<div class="col-sm-3">
					<form:input path="fees.tuitionFee" id="tuitionFee"
						class="form-control" placeholder="Enter tuition Fees" maxlength="5" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="acCharges">A.C
					Charges</label>
				<div class="col-sm-3">
					<form:input path="fees.acCharges" id="acCharges"
						class="form-control" placeholder="Enter AC Charges" maxlength="5" />
				</div>
				<label class="control-label col-sm-2" for="feeReceived">Amount
					Received</label>
				<div class="col-sm-3">
					<form:input path="fees.feeReceived" id="feeReceived"
						class="form-control" onfocusout="return getBalance();"
						placeholder="Enter Amount Received"  maxlength="5"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="balance"> Balance
					Amount</label>
				<div class="col-sm-3">
					<form:input path="fees.feeBalance" id="feeBalance"
						class="form-control" placeholder="Fee Balance " maxlength="5" />
				</div>
				<label class="control-label col-sm-2" for="totalSeats">Total
					Seats </label>
				<div class="col-sm-3">
					<form:input path="sessionClass.totalSeats" id="totalSeats"
						class="form-control" readonly="true" maxlength="2" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="balanceDueDate">Balance
					Date</label>
				<div class="col-sm-3" onclick="aaa();">
					<form:input path="fees.balanceDueDate" id="datepicker"
						class="form-control" placeholder="Enter balanceDueDate" />
				</div>
				<label class="control-label col-sm-2" for="imageName">Image</label>
				<div class="col-sm-3">
					<input type="file" name="file">
					<form:hidden path="imageName" class="form-control"
						placeholder="Enter imageName" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="remarks">Remarks</label>
				<div class="col-sm-8">
					<form:textarea path="remarks" class="form-control"
						placeholder="Enter Remarks"  maxlength="100"/>
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