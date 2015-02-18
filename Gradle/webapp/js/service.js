var graddleFrontService = angular.module('graddleFrontService' , []);

graddleFrontService.factory('Zips', function($resource) {
	  return $resource('http://localhost:8080/Gradle/zips/test/WY' , 
			  {} , 
			  {
				  query : {
					  method : 'GET',
					  isArray : true
				  }
			  }); 
	});

