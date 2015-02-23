var graddleFrontService = angular.module('graddleFrontService' , []);

graddleFrontService.factory('Zips', function($resource ) {
	  return $resource('http://localhost:8080/Gradle/zips/:action/:details' , 
			  {} , 
			  {
				  query : {
					  method : 'GET',
					  isArray : true ,
					  params : {action:'all'}
				  } , 
				  
				  listeStates : {
					  method : 'GET' ,
					  isArray : true, 
					  params : { action:'state' , details: 'all'}
				  }
			  }); 
	});

