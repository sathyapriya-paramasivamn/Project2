'use strict';

app.controller('JobController',['$scope','JobService','$location','$rootScope','$cookieStore','$http',function($scope, JobService, $location, $rootScope,$cookieStore, $http) {
							console.log("JobController...")
							// var this = this;
							this.job = {jobname : '',jobcategory: '',jobdetails:''};
							this.job = {jobname : '',jobcategory: '',jobdetails:''};
							this.jobs = []; // json array

							$scope.orderByMe = function(x) {  
								$scope.myOrderBy = x;
							}  

							this.fetchAllJobs = function() {
								console.log("fetchAllJobs...")
								JobService
										.fetchAllJobs()    
										.then(
												function(d) {
													this.jobs = d;
												},
												function(errResponse) {  
													console
															.error('Error while fetching Jobs');
												});
							};

							// this.fatchAllJobs();

							this.createJob = function(job) {
								console.log("createJob...")
								JobService.createJob(job)
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

							
							

							// this.fetchAllJobs(); //calling the method    

							// better to call fetchAllJobs -> after login ???

							
  
							this.submit = function() {
								{
									console.log('Saving New Job', this.job);
									this.createJob(this.job);
								}
								this.reset();  
							};

							this.reset = function() {
								this.job = {jobid:null,jobname : '',jobcategory: '',jobdetails:''};
								$scope.myForm.$setPristine(); // reset Form
							};

						} ]);
