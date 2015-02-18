/* Controllers */

var graddleFrontControllerz = angular.module('graddleFrontControllerz',
		[ 'ngResource' ]);

graddleFrontControllerz.controller('gr_controllerz', function($scope, Zips, $modal) {
	// /////////////// MODAL ///////////////////////////////
	$scope.items = [ 'item1', 'item2', 'item3' ];
	$scope.open = function(size) {
		var modalInstance = $modal.open({
			templateUrl : 'myModalContent.html',
			controller : 'ModalDemoCtrl',
			size : size,
			resolve : {
				items : function() {
					return $scope.items;
				}
			}
		});

		modalInstance.result.then(function(selectedItem) {
			$scope.selected = selectedItem;
		}, function() {
			$log.info('Modal dismissed at: ' + new Date());
		});
	};
	// /////////////// REMPLIR TABLEAU /////////////////////////
	$scope.getAllZips = function() {
		var allZips = Zips.query(function(Zips) {
			$scope.listeZip = allZips;
			console.info("lance ");
		});

	};

});
//////////////////////////////////////////////////////////////////////
/// controleur des modals de modification des zips 
//////////////////////////////////////////////////////////////////////
angular.module('graddleFrontControllerz').controller('ModalDemoCtrl',
		function($scope, $modalInstance, items) {

			// Please note that $modalInstance represents a modal window
			// (instance)
			// dependency.
			// It is not the same as the $modal service used above.

			$scope.items = items;
			$scope.selected = {
				item : $scope.items[0]
			};

			$scope.ok = function() {
				$modalInstance.close($scope.selected.item);
			};

			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};
		});
