
var app = angular.module('myApp',["ngRoute"]);
app.config(function($routeProvider) {
	$routeProvider
	.when('/regis',{
		templateUrl: 'register/register.html',
			controller:'UserController'
	});
});
