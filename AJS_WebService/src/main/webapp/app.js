var app = angular.module('paymentApp',["ngRoute"]);

app.config(function($routeProvider){
	$routeProvider
	.when('/home',{
		templateUrl: 'application/templates/home.html'
	})
	.when('/payment',{
		templateUrl: 'application/templates/payment.html',
		controller: 'paymentController'
	})
	.when('/paymentConfirmation',{
		templateUrl: 'application/templates/paymentConfirmation.html',
		controller: 'confirmationController'
	})
});