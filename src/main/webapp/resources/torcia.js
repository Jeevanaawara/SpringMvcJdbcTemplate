  function getBalance(){
		var addmissionFee =$('#addmissionFee').val();
		var acCharges =$('#acCharges').val();
		var tuitionFee =$('#tuitionFee').val();
		var feeReceived =$('#feeReceived').val();
		var balance;
		if(acCharges !='0'){
			balance =(feeReceived - (+addmissionFee + +acCharges + +tuitionFee));
		}else{
			acCharges =0;
			balance =(feeReceived - (+addmissionFee + +acCharges + +tuitionFee));
		} 	
		$('#feeBalance').val(balance);
	}  
  
  function getBalanceEntryTest(){
	//	alert('aaaaaaaaaaa');
		var sessionFee =$('#sectionFee').val();
		var feeReceived =$('#feeReceived').val();
		var balance =(feeReceived - sessionFee);
		$('#feeBalance').val(balance);
	//	alert(balance);
	} 
  
  function loginValidation(){
	  var adminName =$('#adminName').val();
	  var password =$('#password').val();
	  if(adminName !=null && password != null){
		  return true;
	  }else{
		  return false;
	  }
	  
  }
  
  function ConfirmDelete()
  {
    var x = confirm("Are you sure you want to delete?");
    if (x)
        return true;
    else
      return false;
  }
  