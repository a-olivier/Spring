/* Controllers */

var graddleFrontControllerz = angular.module('graddleFrontControllerz',
		[ 'ngResource' ]);

graddleFrontControllerz.controller('gr_controllerz.line', function($scope,
		Zips, $modal) {
	
	// /////////////// MODAL ///////////////////////////////
	$scope.open = function(size) {
		var modalInstance = $modal.open({
			templateUrl : 'myModalContent.html',
			controller : 'ModalModifCtrl',
			size : size,
			resolve : {
				zip : function() {
					console.log($scope.zips);
					return $scope.zip;
				}
			}
		});

	};
});

/////////////////////////////////////////////////////////////////////////////
//
// Controleur de la page principale
//
/////////////////////////////////////////////////////////////////////////////
graddleFrontControllerz.controller('gr_controllerz.main', function($scope,
		Zips, $modal , $timeout) {
	////////////////// INIT ////////////////////////////////
	var allStates = Zips.listeStates( function (data){
		$scope.allStates = allStates;
	});
	
	// /////////////// REMPLIR TABLEAU /////////////////////////
	$scope.getAllZips = function() {
		$scope.showProgress = true;
		$timeout(function(){
			var allZips = Zips.query({details : $scope.stateToFind} , 
				function(Zips) {
				$scope.listeZip = allZips;
				$scope.showProgress = false;
			});			
		} 
		, 2 * 1000 ); 
	};

});
// ////////////////////////////////////////////////////////////////////
//
//  controleur des modals de modification des zips
//
// ////////////////////////////////////////////////////////////////////
angular.module('graddleFrontControllerz').controller('ModalModifCtrl',
		function($scope, $modalInstance, zip) {

			$scope.zip = zip;
			// sauvegarde de la valeur si annulation des changements
			var zipsave = angular.copy(zip);

			$scope.ok = function() {
				$modalInstance.close(zip);
			};

			$scope.cancel = function() {
				console.log(zipsave)
				//rollback du scope
				zip.city = zipsave.city;
				zip.pop = zipsave.pop
				zip.state = zipsave.state
				$modalInstance.dismiss('cancel');
			};
		});
