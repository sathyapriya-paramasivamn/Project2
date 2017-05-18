 'use strict';
 
app.service('JobService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	
	console.log("jobService...")
	
	var BASE_URL='http://localhost:8085/CollaborationRestServices/'
		  
    return {
         
            fetchAllJobs: function() {
            	console.log("calling fetchAlljobs ")
                    return $http.get(BASE_URL+'/listAlljobNotFriends')
                            .then(
                                    function(response){
                                        return response.data;
                                    },  
                                   null
                            );  
            },
                                     
            createJob: function(Job){
            	console.log("calling create Job")
                    return $http.post(BASE_URL+'/job', Job) //1
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating Job');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateJob: function(Job, id){
            	console.log("calling fetchAllJobs ")
                    return $http.put(BASE_URL+'/job/', Job)  //2
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating Job');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
              
       
           
         
    };
 
}]);