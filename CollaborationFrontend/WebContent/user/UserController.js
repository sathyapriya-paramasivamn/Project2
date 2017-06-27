'use strict';

app.controller('UserController',['$scope','UserService','FriendService','$location','$rootScope','$cookieStore','$http',function($scope, UserService,FriendService, $location, $rootScope,$cookieStore, $http) {
							console.log("UserController...")
							var self = this;
						
							self.user = {id:'',name : '',mailid : '',password : '',role : '',mobileno: '',residential : '',pincode: ''};

							self.currentUser = {id:'',name : '',mailid : '',password : '',role : '',mobileno: '',residential : '',pincode: ''};
                            self.friend={fid:'',friendid:'',friendname:'',status:'',userid:'',username:''};
							self.users = []; // json array
							self.friends = []; // json array
							var arr=[]; 
							var i=0;
							var j=0;
							  
 
							$scope.orderByMe = function(x) {
								$scope.myOrderBy = x;
							}  
							
						
   
							self.fetchAllUsers = function() {
								self.asd = null;
								self.us = '';  
								console.log("fetchAllUsers...")
								$scope.loginUser =$rootScope.currentUser;
								console.log("fetchUserList...")
								UserService.fetchAllUsers()
										.then(function(d) {
												self.users = d;
												for(i=0; i<self.users.length; i++)
												{
												if(self.users[i].role!='ADMIN'){
														arr.push(self.users[i])
																										
											}
												 }
												self.us=arr;
												console.log(self.us)
												console.log("fetchAllRequestedFriend...")
												FriendService.fetchAllRequestedfriends($scope.loginUser.id).then(function(d) {
										        self.friends = d;
										        console.log(self.friends)	
											//	$location.path("/friend")
										        for(j=0; j<self.us.length; j++){
													for(i=0; i<self.friends.length; i++){
													if(self.friends[i].friendid === self.us[j].id){
														self.us.splice(j, 1);
														console.log(self.us)
													}
												}
											}
											self.asd = self.us;
											
											 
												}, 
												function(errResponse) {
													console.error('Error while fetching Friends');
												} );
								
								
							},
												function(errResponse) {
													console.error('Error while fetching Users');
												});
							};

							// self.fatchAllUsers();

							self.createUser = function(user) {
								console.log("createUser...")  
								UserService.createUser(user)
										.then(
												function(d) {
													alert("Thank you for registration")
													$location.path("/login")
												}, 
												function(errResponse) {
													console.error('Error while creating User.');
												});
							};

							self.myProfile = function() {
								console.log("myProfile...")
								UserService.myProfile()
										.then(function(d) {
													self.user = d;
													$location.path("/myProfile")
												},
												function(errResponse) {
													console.error('Error while fetch profile.');
												});
							};

							self.accept = function(id) {
								console.log("accept...")
								UserService.accept(id)
										.then(function(d) {
													self.user = d;  
													self.fetchAllUsers
													$location.path("/manage_users")
													alert(self.user.errorMessage)

												}, 

												function(errResponse) {
													console.error('Error while updating User.');
												});
							};

							self.reject = function(id) {
								console.log("reject...")
								var reason = prompt("Please enter the reason");
								UserService.reject(id, reason).then(
										function(d) {
											self.user = d;
											self.fetchAllUsers
											$location.path("/manage_users")
											alert(self.user.errorMessage)

										}, null);
							};

							self.updateUser = function(currentUser) {
								console.log("updateUser...")
								UserService.updateUser(currentUser).then(
										self.fetchAllUsers, null);
							};

							self.update = function() {
								{
									console.log('Update the user details',
											$rootScope.currentUser);
									self.updateUser($rootScope.currentUser);
								}
								self.reset();
							};

						
  
							self.login = function() {
								UserService.login(self.user).then(function(response) {
									console.log(response.status)
									$scope.user = response.data;
								 
									$rootScope.currentUser = response.data;  
									$cookieStore.put("currentUser", response.data);
									 if($scope.user.role == 'STUDENT'){ 
										 $location.path('/home')
									  }else if($scope.user.role == 'ADMIN'){
										  $location.path('/adminPage')
									}else{
										 $location.path('/blog')
									}
									
								}, function(response) {  
									console.log(response.status)
									$scope.message = response.data.message
									$location.path('/login')
								})  
							};
							self.logout = function() {
								console.log("logout")
								$rootScope.currentUser = {};  
								$cookieStore.remove('currentUser');
								UserService.logout()
								$location.path('/login');

							}
    
						self.sendreq = function(friendUser){  
                            console.log("sending friend request...")
                            FriendService.createFriend(friendUser).then(function(d) {
                                console.log(d)                    
                                  $location.path("/friend")
                                    },
                                              function(errResponse) {
                                                console.error('Error while creating friend..');
                                            });} 
                          
						self.requestedFriend = function() {
							$rootScope.loginUser =$rootScope.currentUser;
							console.log("GetAllRequestedFriends...")
							FriendService.fetchRequestedfriends($rootScope.loginUser.name).then(function(d) {
												self.reqFriend = d;
												console.log(self.reqFriend)
											},function(errResponse) {  
												console.error('Error while fetching By Friend Name');
											});
						};
						
						self.acceptFriend = function(reqFriend) {
							
								
									console.log('accept the friend request')
									FriendService.updateFriendReq(reqFriend);
									
									console.log('Accepted')
								$location.path("/friend")
								
								
							};
							
							self.AcceptedFriendCurrentUser = function() {
								$rootScope.loginUser =$rootScope.currentUser;
								console.log("GetAllAcceptedFriendCurrentUser...")
								FriendService.fetchAcceptedFriends($rootScope.loginUser.name).then(function(d) {
													self.accFriend = d;
													
													console.log(self.accFriend)
								 					console.error('Error while fetching Accepted list');
												});
							};  
							
							
							
							 
 
							self.submit = function() {
								{
									console.log('Saving New User', self.user); 
									self.createUser(self.user);
								}
						 		self.reset(); 
							};  
        
							self.reset = function() {
								self.user = {id:null,name : '',mailid : '',password : '',role : '',mobileno: '',residential : '',pincode: ''};
								self.friend={fid:null,friendid:'',friendname:'',status:'',userid:'',username:''};
								$scope.myForm.$setPristine(); // reset Form
							};
  
						} ]);
