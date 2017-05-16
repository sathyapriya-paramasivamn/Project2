'use strict';

app.controller('ForumController',['$scope','ForumService','$location','$rootScope','$cookieStore','$http',function($scope, ForumService, $location, $rootScope,$cookieStore, $http) {
							console.log("ForumController...")
							// var this = this;
							this.forum = {name : '',message: ''};
							this.forum = {name : '',message: ''};
							this.forums = []; // json array

							$scope.orderByMe = function(x) {
								$scope.myOrderBy = x;
							}

							this.fetchAllForums = function() {
								console.log("fetchAllForums...")
								ForumService
										.fetchAllForums()
										.then(
												function(d) {
													this.forums = d; 
												},
												function(errResponse) {
													console
															.error('Error while fetching Forums');
												});
							};

							 //this.fatchAllForums();

							this.createForum = function(forum) {
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

							

							

							this.reject = function(id) {
								console.log("reject...")
								var reason = prompt("Please enter the reason");
								ForumService.reject(id, reason).then(
										function(d) {
											this.Forum = d;
											this.fetchAllForums
											$location.path("/manage_Forums")
											alert(this.Forum.errorMessage)

										}, null);
							};

							this.updateForum = function(currentForum) {
								console.log("updateForum...")
								ForumService.updateForum(currentForum).then(
										this.fetchAllForums, null);
							};

							this.update = function() {
								{
									console.log('Update the Forum details',
											$rootScope.currentForum);
									this.updateForum($rootScope.currentForum);
								}
								this.reset();
							};

							
							

							// this.fetchAllForums(); //calling the method    

							// better to call fetchAllForums -> after login ???

							

							this.submit = function() {
								{
									console.log('Saving New Forum', this.forum);
									this.createForum(this.forum);
								}
								this.reset();  
							};

							this.reset = function() {  
								this.forum = {forumid:null,name : '',message: ''};
								$scope.myForm.$setPristine(); // reset Form
							};

						} ]);
