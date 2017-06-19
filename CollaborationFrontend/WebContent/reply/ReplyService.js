'use strict';
 
app.service('ReplyService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	
	console.log("ReplyService...") 
	
	var BASE_URL='http://localhost:8085/CollaborationRestServices/'
		
    return {
           
            fetchAllReplys: function(id) {  
            	console.log("calling fetchAllReplys ") 
                    return $http.get(BASE_URL+'/reply/'+id) 
                            .then(  
                                    function(response){   
                                        return response.data;
                                    },    
                                   null 
                            );   
            }, 
                                       
            createReply: function(Reply){
            	console.log("calling create Reply")
                    return $http.post(BASE_URL+'/reply', Reply) //1
                            .then(
                                    function(response){
                                          return response.data; 
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating Reply');
                                        return $q.reject(errResponse);
                                    }
                            );
            },   
              
            updateReply: function(Reply, id){
            	console.log("calling fetchAllReplys ")
                    return $http.put(BASE_URL+'/reply/', Reply)  //2
                            .then( 
                                    function(response){
                                        return response.data;  
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating Reply');
                                        return $q.reject(errResponse);
                                    }  
                            );
            },    
    };
   
}]);