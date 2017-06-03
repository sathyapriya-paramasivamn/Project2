 'use strict';

app.controller('JobController',['$scope','JobService','$location','$rootScope','$cookieStore','$http',function($scope, JobService, $location, $rootScope,$cookieStore, $http) {
							console.log("JobController...")
							var self = this;
							self.job = {jobname : '',jobcategory: '',jobdetails:''};
							//self.job = {jobname : '',jobcategory: '',jobdetails:''};
							self.jobs = []; // json array

//							$scope.orderByMe = function(x) {  
//								$scope.myOrderBy = x;
//							}  
							fetchAllJobs();
							  reset();
							  function fetchAllJobs(){
							    	JobService.fetchAllJobs()
							            .then(
							            function(d) {
							                self.jobs = d;
							                console.log(self.jobs)
							            },
							            function(errResponse){
							                console.error('Error while fetching Jobs');
							            }
							        );
							    }

							// self.fatchAllJobs();

							self.createJob = function(blog) {
								console.log("createJob...")
								BlogService.createJob(job)
										.then(
												function(d) {
													alert("Thank you for creating message")
													$location.path("/index")
												},
												function(errResponse) {
													console
															.error('Error while creating Job.');
												});
							};

							

							

							self.reject = function(id) {
								console.log("reject...")
								var reason = prompt("Please enter the reason");
								JobService.reject(id, reason).then(
										function(d) {
											self.job = d;
											self.fetchAllJobs
											$location.path("/manage_Jobs")
											alert(self.Job.errorMessage)

										}, null);
							};

							self.updateJob = function(currentJob) {
								console.log("updateJob...")
								JobService.updateJob(currentJob).then(
										self.fetchAllJobs, null);
							};

							self.update = function() {
								{
									console.log('Update the Job details',
											$rootScope.currentJob);
									self.updateJob($rootScope.currentJob);
								}
					 			self.reset();
							};

							
							

							// self.fetchAllBlogs(); //calling the method    

							// better to call fetchAllBlogs -> after login ???

							

							self.submit = function() {
								{
									console.log('Saving New Job', self.job);
									self.createBlog(self.job);
								}
								self.reset();  
							};

						
							 function reset(){
								 self.job = {jobname : '',jobcategory: '',jobdetails:''};
							       //$scope.myform.$setPristine(); //reset Form
							    }
							    
						} ]);