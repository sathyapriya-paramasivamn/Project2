'use strict';

app.controller('FriendController',['$scope','FriendService','$location','$rootScope','$cookieStore','$http',function($scope, FriendService, $location, $rootScope,$cookieStore, $http) {
							console.log("FriendController...")
							var self = this;
						    self.friend={fid:'',friendid:'',friendname:'',status:'',userid:'',username:''};
						
							self.friends = []; // json array   
							 
							 

							self.submit = submit;
						    self.update = update;
						    self.get = get;  
						     
							 
							fetchAllFriends(); 
							reset();
						   
							 
							function fetchAllFriends() {
								console.log("fetchAllFriends...")
								FriendService.fetchAllFriends().then(function(d) {
													self.friends = d;
													console.log(self.friends)
												},function(errResponse) {  
													console.error('Error while fetching friends');
												});
							};
							 
							function fetchAllUserId(friend) {
								console.log("fetchAllFriends...")
								FriendService.fetchAllUser().then(function(d) {
													self.friendss = d;
													console.log(self.friendss)
												},function(errResponse) {  
													console.error('Error while fetching By User Id');
												});
							};

							// this.fatchAllJobs();

							function createFriend(friend){
								console.log("createfriend...")
								FriendService.createFriend(friend).then(function(d) {
													alert("Thank you for creating friend")
													$location.path("/home")
												},  
												function(errResponse) {
													console.error('Error while creating Friend.');
												});
							};

							

							 

							function reject(id){
								console.log("reject...")
								var reason = prompt("Please enter the reason");
								FriendService.reject(id, reason).then(function(d) {
											self.friend = d;
											self.fetchAllFriends
											$location.path("/manage_Friends")
											alert(self.Friend.errorMessage)

										}, null);
							};
 
							function updateFriend(currentFriend){
								console.log("updateFriend...")  
								FriendService.updateFriend(currentFriend).then(
										self.fetchAllFriends, null);
							};

							function update() {
								{
									console.log('Update the Friend details',
											$rootScope.currentFriend);
									updateFriend($rootScope.currentFriend);
								}
					 			reset();
							};

							
							

							// this.fetchAllJobs(); //calling the method    

							// better to call fetchAllJobs -> after login ???
						/*	function get(friend){
								$scope.frnd=friend;
								console.log($scope.frnd);
								$rootScope.viewFriend=$scope.frnd;
								console.log('viewFriend')
								$location.path("/viewFriend");
	 							
								
							};*/
							 
  
							 function submit() {
								{
									console.log('Saving New Friend', self.friend);
									createFriend(self.friend);
								}   
								reset();  
							};
 
          
							self.reset = function() { 
								
								self.friend={fid:null,friendid:'',friendname:'',status:'',userid:'',username:''};
								$scope.myForm.$setPristine(); // reset Form
							};   
 
						} ]);
