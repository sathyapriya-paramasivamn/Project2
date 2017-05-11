'use strict';
 
app.service('forumService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	
	console.log("forumService...")
	
	var BASE_URL='http://localhost:8085/CollaborationRestServices/'
		
    return {
         
            fetchAllforums: function() {
            	console.log("calling fetchAllforums ")
                    return $http.get(BASE_URL+'/listAllforumsNotFriends')
                            .then(
                                    function(response){
                                        return response.data;
                                    },  
                                   null
                            );
            },
                                     
            createforum: function(forum){
            	console.log("calling create forum")
                    return $http.post(BASE_URL+'/forum', forum) //1
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating forum');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateforum: function(forum, id){
            	console.log("calling fetchAllforums ")
                    return $http.put(BASE_URL+'/forum/', forum)  //2
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating forum');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
              
         
        
        
            
           
         
    };
 
}]);