'use strict';
 
app.service('ForumService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	
	console.log("ForumService...")
	
	var BASE_URL='http://localhost:8085/CollaborationRestServices/'
		
    return {
         
            fetchAllForums: function() {
            	console.log("calling fetchAllForums ")
                    return $http.get(BASE_URL+'/forum')
                            .then(
                                    function(response){
                                        return response.data;
                                    },  
                                   null
                            );  
            },
                                     
            createForum: function(Forum){
            	console.log("calling create Forum")
                    return $http.post(BASE_URL+'/forum', Forum) //1
                            .then(
                                    function(response){
                                          return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating Forum');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateForum: function(Forum, id){
            	console.log("calling fetchAllForums ")
                    return $http.put(BASE_URL+'/forum/', Forum)  //2
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating Forum');
                                        return $q.reject(errResponse);
                                    }
                            );
            },    
    };
 
}]);