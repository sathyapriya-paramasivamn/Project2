'use strict';

app.controller('ForumController', ['$scope','ForumService','CommentService','$location','$rootScope','$cookieStore',  '$http',
		function($scope, ForumService, CommentService, $location, $rootScope,
				$cookieStore, $http) {
			console.log("ForumController...")
			var self = this;
			self.forum = {forumid : '',name : '',message : '',timeStamp:'',usermailid:'',username:''};
			self.comment = {commentid : '',commentname : '',forumid : '',userid : '',content : '',name : '',timeStamp : '',Mail : ''};
			// self.forum = {forumid:'',name : '',message: ''};
			self.forums = []; // json array

			/*
			 * $scope.orderByMe = function(x) { $scope.myOrderBy = x; }
			 */
			$scope.cmt = {};
			self.comments = []; 
			self.submit = submit;   
			self.update = update;  
			self.get = get;
			self.getComment = getComment;
			self.createComment = createComment;
			self.createForum=createForum;  
			self.notAcceptedForums=notAcceptedForums;
			self.accept=accept;
			self.getForumAdmin=getForumAdmin;
			fetchAllForums();
			
			reset();  
			function fetchAllForums() {
				ForumService.fetchAllForums().then(function(d) {
					self.forums = d;
					console.log(self.forums)
				}, function(errResponse) { 
					console.error('Error while fetching Forums');
				});  
			}
			function notAcceptedForums() {
					console.log("notAcceptedForums...")  
					ForumService.notAcceptedForums()     
							.then( 
									function(d) {
										//alert("Thank you for creating message")
				  						self.forumss = d;
									},   
									function(errResponse) {
						  				console
												.error('Error while creating notAcceptedForums.');
							  		});
				};	  

			// self.fatchAllForums();
   
			function createForum(forum) {   
				console.log("createForum...")
				ForumService.createForum(forum).then(function(d) {
					alert("Thank you for creating message")
					$location.path("/viewforum") 
				}, function(errResponse) { 
					console.error('Error while creating Forum.');
				});
			};    
   
		function reject(id) {
				console.log("reject...")
				var reason = prompt("Please enter the reason");
				ForumService.reject(id, reason).then(function(d) {
					self.forum = d;
					self.fetchAllForums
					$location.path("/manage_Forums")
					alert(self.Forum.errorMessage)

				}, null);
			}; 

		 function updateForum(currentForum) {
				console.log("updateForum...")
				ForumService.updateForum(currentForum).then(
						self.fetchAllForums, null);
			};
			

			function update() {  
				{
					console.log('Update the Forum details',
							$rootScope.currentForum);
					self.updateForum($rootScope.currentForum);
				}
				self.reset();
			};
 
			function accept(adminvf) {
				{
					console.log('accept the Blog details')
						
					ForumService.accept(adminvf);
					$location.path("/admin")
				}
			};
			function submit() {
				{
					console.log('Saving New Forum', self.forum);
					self.createForum(self.forum);
				}
				self.reset();
			}; 
    
			function get(forum){
					CommentService.fetchAllComments(forum.forumid) .then(function(d) {
						self.forumComments = d;
						$rootScope.fcomment = d;   
						console.log($rootScope.fcomment);
						console.log(self.forumComments);
						$scope.fc=forum; 
						$scope.cmt=d;      
						console.log($scope.fc);  
						console.log($scope.cmt);
						console.log("fetchingAllComments...")
						   
						$rootScope.viewForum=$scope.fc;
						console.log($rootScope.viewForum);  
						$rootScope.ct=$scope.cmt;
						$location.path("/viewf");  
					}, function(errResponse) { 
						console.error('Error while fetching Comments');
					});
				   
				    
			};    
			function getForumAdmin(forums){  
				$scope.fc=forums;   
				console.log($scope.fc);
				console.log("hai");     
			 	$rootScope.adminvf=$scope.fc;
				$location.path("/adminviewforum");   
			};  
			 
			function getComment(forumid){
				console.log("fetchingAllComments...")
				CommentService.fetchAllComments(forumid) .then(function(d) {
					self.forumComments = d;
					console.log(self.forumComments)
				}, function(errResponse) {  
					console.error('Error while fetching Comments');
				});
			};
			     
			
	function createComment(comment) {
				console.log("createComment...")

				$scope.recentForum = $rootScope.viewForum;
				console.log($scope.recentForum);
				CommentService.createComment(comment).then(function(d) {
					self.comment = d;

					alert("Thank you for creating message")
					$location.path("/home")
				}, function(errResponse) {
					console.error('Error while creating Comment.');
				});
			};  
			       
			          
			    
     
			function reset() {
				self.forum = {forumid :null,name : '',message : '',timeStamp:'',usermailid:'',username:''};
				self.comment = {commentid :null,commentname : '',forumid : '',userid : '',content : '',name : '',timeStamp : '',Mail : ''};
				// $scope.myform.$setPristine(); //reset Form
			}
			   
	
			 
		} ]);
