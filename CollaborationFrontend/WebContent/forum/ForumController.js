'use strict';

app.controller('ForumController',['$scope','ForumService','$location','$rootScope','$cookieStore','$http',function($scope, ForumService, $location, $rootScope,$cookieStore, $http) {
							console.log("ForumController...")
							var self = this;
							self.forum = {forumid:'',name : '',message: ''};
						//self.forum = {forumid:'',name : '',message: ''};
							self.forums = []; // json array

						/*	$scope.orderByMe = function(x) {  
								$scope.myOrderBy = x;
							}  */
							fetchAllForums();
							  reset();
							  function fetchAllForums(){
							    	ForumService.fetchAllForums()
							            .then(
							            function(d) {
							                self.forums = d;
							                console.log(self.forums)
							            },
							            function(errResponse){
							                console.error('Error while fetching Forums');
							            }
							        );
							    }

							// self.fatchAllForums();

							self.createForum = function(forum) {
								console.log("createForum...")
								ForumService.createForum(forum)
										.then(
												function(d) {
													alert("Thank you for creating message")
													$location.path("/index")
												},
												function(errResponse) {
													console
															.error('Error while creating Forum.');
												});
							};

							

							

							self.reject = function(id) {
								console.log("reject...")
								var reason = prompt("Please enter the reason");
								ForumService.reject(id, reason).then(
										function(d) {
											self.forum = d;
											self.fetchAllForums
											$location.path("/manage_Forums")
											alert(self.Forum.errorMessage)

										}, null);
							};

							self.updateForum = function(currentForum) {
								console.log("updateForum...")
								ForumService.updateForum(currentForum).then(
										self.fetchAllForums, null);
							};

							self.update = function() {
								{
									console.log('Update the Forum details',
											$rootScope.currentForum);
									self.updateForum($rootScope.currentForum);
								}
					 			self.reset();
							};

							
							

							// self.fetchAllForums(); //calling the method    

							// better to call fetchAllForums -> after login ???

							
  
							self.submit = function() {
								{
									console.log('Saving New Forum', self.forum);
									self.createForum(self.forum);
								}
								self.reset();  
							};

						
							 function reset(){
							self.forum = {forumid:'',name : '',message: ''};
							       //$scope.myform.$setPristine(); //reset Form
							    }
							    
						} ]);
