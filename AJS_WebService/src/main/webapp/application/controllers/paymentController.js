app.controller('paymentController',['$scope','$http','dataShare',function($scope,$http,dataShare){
	$scope.header = "Fill Payment Details";
	$scope.errorMsgField = false;
	
	$http.get('application/data/mockData.json').then(function(response){
		$scope.comboData = response.data.paymentComboData;
	});
	
	$scope.onPincodeEnter = function(pincode){
		console.log('pincode entered: '+pincode);
		if(pincode.length != 6){
			$scope.errorMsg = "Pincode length should be of 6 digits";
			$scope.errorMsgField = true;
			console.log('all fine');
		}
		else{
			console.log('inside else blocck');
			$scope.errorMsgField = false;
			console.log($scope.errorMsgField);
		}
	};
	
	$scope.onProceedBtnClick = function(pincode,paymentModeCombo){
		dataShare.sendData(pincode,paymentModeCombo.value);
	};
}]);