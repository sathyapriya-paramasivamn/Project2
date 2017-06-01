'use strict';

app.controller('UserController',['$scope','UserService','$location','$rootScope','$cookieStore','$http',function($scope, UserService, $location, $rootScope,$cookieStore, $http) {
							console.log("UserController...")
							var self = this;
							self.user = {name : '',mailid : '',password : '',role : '',mobileno: '',residential : '',pincode: ''};

							self.currentUser = {name : '',mailid : '',password : '',role : '',mobileno: '',residential : '',pincode: ''};

							this.users = []; // json array

							$scope.orderByMe = function(x) {
								$scope.myOrderBy = x;
							}

							this.fetchAllUsers = function() {
								console.log("fetchAllUsers...")
								UserService  
										.fetchAllUsers()
										.then(function(d) {
												self.users = d;
												},
												function(errResponse) {
													console.error('Error while fetching Users');
												});
							};

							// this.fatchAllUsers();

							this.createUser = function(user) {
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

							this.myProfile = function() {
								console.log("myProfile...")
								UserService
										.myProfile()
										.then(function(d) {
													self.user = d;
													$location.path("/myProfile")
												},
												function(errResponse) {
													console.error('Error while fetch profile.');
												});
							};

							this.accept = function(id) {
								console.log("accept...")
								UserService
										.accept(id)
										.then(function(d) {
													self.user = d;
													this.fetchAllUsers
													$location.path("/manage_users")
													alert(this.user.errorMessage)

												}, 

												function(errResponse) {
													console.error('Error while updating User.');
												});
							};

							this.reject = function(id) {
								console.log("reject...")
								var reason = prompt("Please enter the reason");
								UserService.reject(id, reason).then(
										function(d) {
											self.user = d;
											this.fetchAllUsers
											$location.path("/manage_users")
											alert(this.user.errorMessage)

										}, null);
							};

							this.updateUser = function(currentUser) {
								console.log("updateUser...")
								UserService.updateUser(currentUser).then(
										this.fetchAllUsers, null);
							};

							this.update = function() {
								{
									console.log('Update the user details',
											$rootScope.currentUser);
									this.updateUser($rootScope.currentUser);
								}
								this.reset();
							};

							/*this.authenticate = function(user) { 
								console.log("authenticate...")
								UserService.authenticate(user)
										.then(function(d) {
													this.user = d;
													
														console.log("Valid credentials. Navigating to home page")
													
															console.log("You are admin")
															this.fetchAllUsers();
															console.log("Valid credentials. Navigating to admin page")
														
													
												},
												function(errResponse) {
													console.error('Error while authenticate Users');
												});
							};*/
  
							this.login = function() {
								UserService.login(this.user).then(function(response) {
									console.log(response.status)
									$scope.user = response.data
									$rootScope.currentUser = response.data;
									$cookieStore.put("currentUser", response.data);
									$location.path('/blog')
								}, function(response) {
									console.log(response.status)
									$scope.message = response.data.message
									$location.path('/login')
								})  
							};
							this.logout = function() {
								console.log("logout")
								$rootScope.currentUser = {};
								$cookieStore.remove('currentUser');
								UserService.logout()
								$location.path('/');

							}

							// this.fetchAllUsers(); //calling the method    

							// better to call fetchAllUsers -> after login ???  

						/*	this.login = function() {
								{
									console.log('login validation????????',
											this.user);
									this.authenticate(this.user);
								}

							};*/

							this.submit = function() {
								{
									console.log('Saving New User', this.user);
									this.createUser(this.user);
								}
								this.reset();
							};

							this.reset = function() {
								self.user = {userid:null,name : '',mailid : '',password : '',role : '',mobileno: '',residential : '',pincode: ''};
								$scope.myForm.$setPristine(); // reset Form
							};

						} ]);
