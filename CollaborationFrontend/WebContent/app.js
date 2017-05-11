var app = angular.module('myApp', [ 'ngRoute', 'ngCookies' ]);

app.config(function($routeProvider) {

	$routeProvider 
 
	/*.when('/', {
		templateUrl : 'index.html'

	})
 */
	.when('/login', {
		templateUrl : 'user/login.html'

	})

	.when('/register', {
		templateUrl : 'user/register.html',
		controller : 'UserController',
		controllerAs: 'ctrl'
	})
.when('/blog', {
		templateUrl : 'blog/blogform.html'

	})
	.when('/forum', {
		templateUrl : 'forum/forum.html',
		controller  : 'ForumController',
		controllerAs: 'ctrl'
	})
	.otherwise({
		redirectTo : '/'
	});
});