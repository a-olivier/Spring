/* Controllers */

var graddleFrontControllerz = angular.module('graddleFrontControllerz',
		[ 'ngResource' ]);

graddleFrontControllerz.controller('gr_controllerz',
		function($scope, Zips) {
			// var getzips = $resource('http://localhost:8080/Gradle/zips/all');
			// var zipreturn = getzips.get({}, function() {
			// $scope.listeZip = zipreturn;
			// console.info("lanc .. ");
			// });
			// });

			$scope.getAllZips = function() {
				var allZips = Zips.query(function(Zips) {
					$scope.listeZip = allZips;
					console.info("lance ");
				});

			};
		});
