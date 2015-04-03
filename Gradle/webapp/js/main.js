/**
 * 
 */



var myApp = angular.module('graddleFront', ['ui.bootstrap', 'ngResource' , 'graddleFrontService' , 'graddleFrontControllerz' ]);
myApp.config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
}
]);