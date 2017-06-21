'use strict';
 
app.service('FriendService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	
	console.log("FriendService...")
	
	var BASE_URL='http://localhost:8085/CollaborationRestServices/'
		
    return {
           
            fetchacceptedfriend: function() {
            	console.log("calling fetchAllFriends ")    
                    return $http.get(BASE_URL+'/acceptedfriend')  
                            .then(   
                                    function(response){
                                        return response.data;
                                    }, 
                                   null
                            );  
            },
               
         
            
            accept: function(friendid) {
            	console.log("calling approve ")
                    return $http.get(BASE_URL+'/accept/'+friendid)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while accept friend');
                                       
                                    }
                            );
            },
            
            reject: function(friendid, reason) {
            	console.log("calling reject ")
                    return $http.get(BASE_URL+'/reject/'+friendid+'/'+reason)
                            .then(  
                                    function(response){ 
                                        return response.data;
                                    }, 
                                    null
                            );
            },
             
            createFriend: function(friendUser){
            	console.log("calling create friend")
                    return $http.post(BASE_URL+'friend', friendUser) //1
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating friend');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            
               
          
        
            
	};
 
}]);