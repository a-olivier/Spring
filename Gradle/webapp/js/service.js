var graddleFrontService = angular.module('graddleFrontService' , []);

//graddleFrontService.factory(
//		'zips', 
//			[ '$resource', 
//              function($resource) {
//				return $resource('http://localhost:8080/Gradle/zips/all',{}, 
//									{
//										query : {
//													method : 'GET',
//													isArray : true, 
//													dataType : 'json'
//										}
//									}
//						);
//} ]);


graddleFrontService.factory('Zips', function($resource) {
	  return $resource('http://localhost:8080/Gradle/zips/all' , 
			  {} , 
			  {
				  query : {
					  method : 'GET',
					  isArray : true
				  }
			  }); 
	});

