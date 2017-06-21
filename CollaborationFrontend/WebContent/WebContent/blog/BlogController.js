'use strict';

app.controller('BlogController',['$scope','BlogService','ReplyService','$location','$rootScope','$cookieStore','$http',function($scope, BlogService,ReplyService, $location, $rootScope,$cookieStore, $http) {
							console.log("BlogController...")
							var self = this;
							self.blog = {id:'',title : '',status: '',description:''};
							self.reply={replyId:'',replymsg:'',mailid:'',Id:'',title:''}
							/*self.reply= {replyId:'',replymsg:'',mailid:'',Id:'',title''}; */
						//	self.blog = {id:'',title : '',status: '',description:''}; 
							self.blogs = []; // json array

						/*	$scope.orderByMe = function(x) {  
								$scope.myOrderBy = x;  
							}  */
							$scope.rpl = {};
							self.replys = []; 
							self.submit = submit;   
							self.update = update;  
							self.get = get;
							self.getReply = getReply;  
							self.createReply = createReply;
							self.createBlog=createBlog;  
							self.notAcceptedBlogs=notAcceptedBlogs;
							self.accept=accept;
							self.getBlogAdmin=getBlogAdmin;
							self.accept=accept;
							
							fetchAllBlogs();       
							 
							fetchAllBlogs();
							  reset();  
							  function fetchAllBlogs() {
									BlogService.fetchAllBlogs().then(function(d) {
										self.blogs = d; 
										console.log(self.blogs)
									}, function(errResponse) { 
										console.error('Error while fetching blogs');
									});  
								}
   
							// self.fatchAllBlogs(); 
							  function notAcceptedBlogs() {
									console.log("notAcceptedBlogs...")  
									BlogService.notAcceptedBlogs()     
											.then( 
													function(d) {
														//alert("Thank you for creating message")
								  						self.blogss = d;
													},   
													function(errResponse) {
										  				console
																.error('Error while creating notAcceptedblogs.');
											  		});
								};	  

								function createBlog(blog) {   
									console.log("createblog...")
									BlogService.createBlog(blog).then(function(d) {
										alert("Thank you for creating message")
										$location.path("/viewblog") 
									}, function(errResponse) { 
										console.error('Error while creating blog.');
									});
								};    

								function reject(id) {
									console.log("reject...")
									var reason = prompt("Please enter the reason");
								BlogService.reject(id, reason).then(function(d) {
										self.blog = d;
										self.fetchAllBlogs
										$location.path("/manage_Blogs")
										alert(self.Blog.errorMessage)

									}, null);
								}; 
								 function updateBlog(currentBlog) {
										console.log("updateBlog...")
										BlogService.updateBlog(currentBlog).then(
												self.fetchAllBlog, null);
									};

									function update() {  
										{
											console.log('Update the blog details',
													$rootScope.currentBlog);
											self.updateBlog($rootScope.currentBlog);
										}
										self.reset();
									};
  
							  
							  

							// self.fetchAllBlogs(); //calling the method    

							// better to call fetchAllBlogs -> after login ???

									function get(blog){
										ReplyService.fetchAllReplys(blog.id) .then(function(d) {
											self.blogReplys = d;
											$rootScope.breply = d;   
											console.log($rootScope.breply);
											console.log(self.blogreplys);
											$scope.bc=blog; 
											$scope.rpl=d;      
											console.log($scope.bc);  
											console.log($scope.rpl);
											console.log("fetchingAllReplysss...")
											   
											$rootScope.viewBlog=$scope.bc;
											console.log($rootScope.viewBlog);  
											$rootScope.rt=$scope.rpl;
											$location.path("/viewb");   
										}, function(errResponse) { 
											console.error('Error while fetching reply');
										});
									   
									         
								};    
								function createReply(reply) { 
									console.log("createreply...")

									$scope.recentBlog = $rootScope.viewBlog;
									console.log($scope.recentBlog);
									ReplyService.createReply(reply).then(function(d) {
										self.Blog = d;

										alert("Thank you for creating message")
										$location.path("/home")
									}, function(errResponse) {
										console.error('Error while creating reply.');
									});
								};  
								       
								
								function getReply(id){
									console.log("fetchingAllreply...")
									ReplyService.fetchAllReplys(id) .then(function(d) {
										self.blogReplys = d;
										console.log(self.blogReplys)
									}, function(errResponse) {  
										console.error('Error while fetching Replys');
									});
								};
								
								
								   
								
								
							function getBlogAdmin(blogs){  
								
								$scope.bc=blogs;    
								console.log($scope.bc);
								console.log("hai");    
							 	$rootScope.adminvb=$scope.bc;
								$location.path("/adminviewblog");   
							};  
          
							function submit() {
								{
									console.log('Saving New Blog', self.blog); 
									self.createBlog(self.blog);
								}
								self.reset();
							}; 
							
							function accept(adminvb) {
								{
									console.log('accept the Blog details')
										
									BlogService.accept(adminvb);
									$location.path("/admin")
								}   
								    
							};
							 function reset(){
								 self.blog = {id:null,title : '',status: '',description:''};
								 self.reply={replyId:'null',replymsg:'',mailid:'',Id:'',title:''}
							       //$scope.myform.$setPristine(); //reset Form
							    }
							        
						} ]);
  