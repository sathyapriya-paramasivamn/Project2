'use strict';

app.controller('BlogController',['$scope','BlogService','$location','$rootScope','$cookieStore','$http',function($scope, BlogService, $location, $rootScope,$cookieStore, $http) {
							console.log("BlogController...")
							// var this = this;
							this.blog = {title : '',status: '',description:''};
							this.blog = {title : '',status: '',description:''};
							this.blogs = []; // json array

							$scope.orderByMe = function(x) {  
								$scope.myOrderBy = x;
							}  
							 fetchAllBlogs();
							    reset();
							this.fetchAllBlogs = function() {
								console.log("fetchAllBlogs...")
								BlogService
										.fetchAllBlogs()
										.then(
												function(d) {
													this.blogs = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Blogs');
												});
							};

							// this.fatchAllBlogs();

							this.createBlog = function(blog) {
								console.log("createBlog...")
								BlogService.createBlog(blog)
										.then(
												function(d) {
													alert("Thank you for creating message")
													$location.path("/index")
												},
												function(errResponse) {
													console
															.error('Error while creating Blog.');
												});
							};

							

							

							this.reject = function(id) {
								console.log("reject...")
								var reason = prompt("Please enter the reason");
								BlogService.reject(id, reason).then(
										function(d) {
											this.blog = d;
											this.fetchAllBlogs
											$location.path("/manage_Blogs")
											alert(this.Blog.errorMessage)

										}, null);
							};

							this.updateBlog = function(currentBlog) {
								console.log("updateBlog...")
								BlogService.updateBlog(currentBlog).then(
										this.fetchAllBlogs, null);
							};

							this.update = function() {
								{
									console.log('Update the Blog details',
											$rootScope.currentBlog);
									this.updateBlog($rootScope.currentBlog);
								}
					 			this.reset();
							};

							
							

							// this.fetchAllBlogs(); //calling the method    

							// better to call fetchAllBlogs -> after login ???

							
  
							this.submit = function() {
								{
									console.log('Saving New Blog', this.blog);
									this.createBlog(this.blog);
								}
								this.reset();  
							};

							this.reset = function() {
								this.blog = {id:null,title : '',status: '',description:''};
								$scope.myForm.$setPristine(); // reset Form
							};

						} ]);
