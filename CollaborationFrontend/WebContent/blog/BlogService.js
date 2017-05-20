'use strict';
 
app.service('BlogService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	
	console.log("blogService...")
	
	var BASE_URL='http://localhost:8085/CollaborationRestServices/'
		
    return {
         
            fetchAllBlogs: function() {
            	console.log("calling fetchAllblogs ")
                    return $http.get(BASE_URL+'/blog')
                            .then(
                                    function(response){
                                        return response.data;
                                    },  
                                   null
                            );  
            },
                                     
            createBlog: function(Blog){
            	console.log("calling create Blog")
                    return $http.post(BASE_URL+'/blog', Blog) //1
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating Blog');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateBlog: function(Blog, id){
            	console.log("calling fetchAllBlogs ")
                    return $http.put(BASE_URL+'/Blog/', Blog)  //2
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating Blog');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
              
     
           
         
    };
 
}]);