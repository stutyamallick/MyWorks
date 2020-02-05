app.controller('confirmationController',['$scope','$http','dataShare',function($scope,$http,dataShare){
	$scope.finalMsg = false;
	$scope.header = "Confirm Payment Mode";
	$scope.pincodeEnteredForCnf = dataShare.getPincode();
	$scope.paymentModeSelectedForCnf = dataShare.getPaymentMode();
		
	$scope.onConfirmClick = function(confirmedPaymentMode,confirmedPincode){
		
		var param = {
				paymentMode : confirmedPaymentMode,
				pincode : confirmedPincode
		};
		$http.post('/AJS_WebService/service/getDeliveryStatus', param).success(function(response){
			$scope.message = response.message;
			$scope.finalMsg = true;
		});
	};
	
}]);