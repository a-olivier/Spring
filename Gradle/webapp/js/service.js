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
					  params : { action:'states' , details: 'all'}
				  } , 
				  
				  updateZip : {
					  method : 'POST', 
					  params : {action : 'id'},
					  headers: {
				            'Content-Type': 'application/json'
				        }
				  		
				  }
				  
			  }); 
	});
