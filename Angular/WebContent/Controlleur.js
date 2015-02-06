/**
 * 
 */



var app  = angular.module('helloApp',[]);


app.controller("bonjourController", function($scope,$myService) {
	$scope.message = "Bonjour";
})