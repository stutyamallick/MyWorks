app.factory('dataShare',function($rootScope){
	var service = {};
	 service.sendData = function(pincode,paymentMode){
	     this.pincode = pincode;
	     this.paymentMode = paymentMode;
	 };
	 service.getPincode = function(){
	       return this.pincode;
	 };
	 service.getPaymentMode = function(){
		   return this.paymentMode;
	 };
	 return service;
});