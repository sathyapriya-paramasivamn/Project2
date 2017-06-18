'use strict';
 
app.service('CommentService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	
	console.log("CommentService...")
	
	var BASE_URL='http://localhost:8085/CollaborationRestServices/'
		
    return {
          
            fetchAllComments: function(forumid) { 
            	console.log("calling fetchAllComments ")
                    return $http.get(BASE_URL+'/comment/'+forumid) 
                            .then(  
                                    function(response){   
                                        return response.data;
                                    },  
                                   null 
                            );  
            }, 
                                       
            createComment: function(Comment){
            	console.log("calling create Comment")
                    return $http.post(BASE_URL+'/comment', Comment) //1
                            .then(
                                    function(response){
                                          return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating Comment');
                                        return $q.reject(errResponse);
                                    }
                            );
            },   
              
            updateComment: function(Comment, id){
            	console.log("calling fetchAllComments ")
                    return $http.put(BASE_URL+'/comment/', Comment)  //2
                            .then( 
                                    function(response){
                                        return response.data;  
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating Comment');
                                        return $q.reject(errResponse);
                                    }
                            );
            },    
    };
 
}]);