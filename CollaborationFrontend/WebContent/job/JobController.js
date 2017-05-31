 'use strict';

app.controller('JobController',['$scope','JobService','$location','$rootScope','$cookieStore','$http',function($scope, JobService, $location, $rootScope,$cookieStore, $http) {
							console.log("JobController...")
							var self = this;
							self.job = {jobname : '',jobcategory: '',jobdetails:''};
							//this.job = {jobname : '',jobcategory: '',jobdetails:''};
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

							// this.fatchAllJobs();

							this.createJob = function(blog) {
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

							

							

							this.reject = function(id) {
								console.log("reject...")
								var reason = prompt("Please enter the reason");
								JobService.reject(id, reason).then(
										function(d) {
											this.job = d;
											this.fetchAllJobs
											$location.path("/manage_Jobs")
											alert(this.Job.errorMessage)

										}, null);
							};

							this.updateJob = function(currentJob) {
								console.log("updateJob...")
								JobService.updateJob(currentJob).then(
										this.fetchAllJobs, null);
							};

							this.update = function() {
								{
									console.log('Update the Job details',
											$rootScope.currentJob);
									this.updateJob($rootScope.currentJob);
								}
					 			this.reset();
							};

							
							

							// this.fetchAllBlogs(); //calling the method    

							// better to call fetchAllBlogs -> after login ???

							

							this.submit = function() {
								{
									console.log('Saving New Job', this.job);
									this.createBlog(this.job);
								}
								this.reset();  
							};

						
							 function reset(){
								 self.job = {jobname : '',jobcategory: '',jobdetails:''};
							       //$scope.myform.$setPristine(); //reset Form
							    }
							    
						} ]);