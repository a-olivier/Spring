/* Controllers */

var graddleFrontControllerz = angular.module('graddleFrontControllerz',
		[ 'ngResource' ]);

graddleFrontControllerz.controller('gr_controllerz.line', function($scope, Zips, $modal) {
	// /////////////// MODAL ///////////////////////////////
	$scope.items = [ 'item1', 'item2', 'item3' ];
	
	
	$scope.test = 'controleur général'; 
	
	$scope.open = function(size) {
		var modalInstance = $modal.open({
			templateUrl : 'myModalContent.html',
			controller : 'ModalDemoCtrl',
			size : size,
			resolve : {
				zip : function() {
					console.log( $scope.zips);
					return $scope.zip;
				}
			}
		});

		modalInstance.result.then(function(zip) {
			$scope.zip  = zip;
		}, function() {
			console.info('Modal dismissed at: ' + new Date());
		});
	};
});	



graddleFrontControllerz.controller('gr_controllerz.main', function($scope, Zips, $modal) {
	// /////////////// REMPLIR TABLEAU /////////////////////////
	$scope.getAllZips = function() {
		$scope.showProgress = true;
		var allZips = Zips.query(function(Zips) {
			$scope.listeZip = allZips;
			console.info("lance ");
		});
		$scope.showProgress = false;

	};

});
//////////////////////////////////////////////////////////////////////
/// controleur des modals de modification des zips 
//////////////////////////////////////////////////////////////////////
angular.module('graddleFrontControllerz').controller('ModalDemoCtrl',
		function($scope, $modalInstance, zip) {

			// Please note that $modalInstance represents a modal window
			// (instance)
			// dependency.
			// It is not the same as the $modal service used above.

			$scope.zip = zip;
			var zipsave = angular.copy(zip);
			
			$scope.test = 'dans le controleur de modal'; 

			$scope.ok = function() {
				$modalInstance.close(zip);
			};

			$scope.cancel = function() {
				console.log(zipsave)
				zip.city = zipsave.city;
				zip.pop = zipsave.pop
				zip.state = zipsave.state
				$modalInstance.dismiss('cancel');
			};
		});
