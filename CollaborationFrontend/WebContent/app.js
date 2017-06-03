var app = angular.module('myApp', [ 'ngRoute', 'ngCookies' ]);

app.config(function($routeProvider) {

	$routeProvider 
 
	/*.when('/', {
		templateUrl : 'index.html'

	})
 */
	.when('/login', {
		templateUrl : 'user/login.html',
		controller : 'UserController',
		controllerAs: 'uc'
	})
	.when('/logout', {
		templateUrl : 'home/home.html',
		controller : 'UserController',
		controllerAs: 'ctrl'
	})   

	.when('/register', { 
		templateUrl : 'user/register.html',
		controller : 'UserController',
		controllerAs: 'uc'
	})
.when('/blog', {
		templateUrl : 'blog/blog.html',
		controller  :'BlogController',
		controllerAs:'bc'

	})
	.when('/viewblog', {
		templateUrl : 'blog/viewblog.html',
		controller  :'BlogController',
		controllerAs:'bc'
  
	})
	.when('/forum', {
		templateUrl : 'forum/forum.html',
		controller  : 'ForumController',
		controllerAs: 'fc'
	})
	.when('/viewforum', {
		templateUrl : 'forum/viewforum.html',
		controller  :'ForumController',
		controllerAs:'fc'
  
	})
	.when('/job', {
		templateUrl : 'job/job.html',
		controller  : 'JobController',  
		controllerAs: 'jc'
	})
	.when('/viewjob', {
		templateUrl : 'job/viewjob.html',
		controller  :'JobController',    
		controllerAs:'jc'
  
	})
	.otherwise({
		redirectTo : '/'
	});
});