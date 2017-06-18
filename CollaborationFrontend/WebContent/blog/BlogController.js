'use strict';

app.controller('BlogController',['$scope','BlogService','$location','$rootScope','$cookieStore','$http',function($scope, BlogService, $location, $rootScope,$cookieStore, $http) {
							console.log("BlogController...")
							var self = this;
							self.blog = {id:'',title : '',status: '',description:'',};
						//	self.blog = {id:'',title : '',status: '',description:''};
							self.blogs = []; // json array

						/*	$scope.orderByMe = function(x) {  
								$scope.myOrderBy = x;
							}  */
							
							
							
							fetchAllBlogs();
							  reset(); 
							  function fetchAllBlogs(){
							    	BlogService.fetchAllBlogs()
							            .then(
							            function(d) {
							                self.blogs = d; 
							                console.log(self.blogs)
							            },
							            function(errResponse){
							                console.error('Error while fetching Blogs');
							            }
							        );
							    }
   
							// self.fatchAllBlogs(); 
							  self.notAcceptedBlogs = function() {
									console.log("notAcceptedBlogs...")
									BlogService.notAcceptedBlogs()
											.then(
													function(d) {
														//alert("Thank you for creating message")
														self.blogss = d;
													},
													function(errResponse) {
										  				console
																.error('Error while creating notAcceptedBlogs.');
													});
								};	
							self.createBlog = function(blog) {
								console.log("createBlog...")
								BlogService.createBlog(blog)
										.then(
												function(d) {
													alert("Thank you for creating message")
													$location.path("/viewblog")
												},
												function(errResponse) {
													console
															.error('Error while creating Blog.');
												});
							};

							self.reject = function(id) {
						 		console.log("reject...")
								var reason = prompt("Please enter the reason");
								BlogService.reject(id, reason).then(
										function(d) {
											self.blog = d;
											self.fetchAllBlogs
											$location.path("/manage_Blogs")
											alert(self.Blog.errorMessage)

										}, null);
							};

							self.updateBlog = function(currentBlog) {
								console.log("updateBlog...")
								BlogService.updateBlog(currentBlog).then(
										self.fetchAllBlogs, null);
							};

							self.update = function() {
								{
									console.log('Update the Blog details',
											$rootScope.currentBlog);
									self.updateBlog($rootScope.currentBlog);
								}
					 			self.reset();
							};
  
							
							

							// self.fetchAllBlogs(); //calling the method    

							// better to call fetchAllBlogs -> after login ???

							self.get=function (blog){  
								$scope.bc=blog;
								console.log($scope.bc);
								$rootScope.viewblog=$scope.bc;
								$location.path("/viewb");   
							};  
							self.getBlogAdmin=function (blogs){  
								$scope.bc=blogs;   
								console.log($scope.bc);
								console.log("hai");    
								$rootScope.adminvb=$scope.bc;
								$location.path("/adminviewblog");   
							};  
        
							self.submit = function() {
								{
									console.log('Saving New Blog', self.blog);
									self.createBlog(self.blog); 
								}
								self.reset();  
							};
							 function reset(){
								 self.blog = {id:null,title : '',status: '',description:''};
							       //$scope.myform.$setPristine(); //reset Form
							    }
							      
						} ]);
