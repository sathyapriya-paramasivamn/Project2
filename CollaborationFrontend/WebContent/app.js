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
		controllerAs: 'uc'
	})
.when('/blog', {
		templateUrl : 'blog/blog.html',
		controller  :'BlogController',
		controllerAs:'bc'

	})
	.when('/forum', {
		templateUrl : 'forum/forum.html',
		controller  : 'ForumController',
		controllerAs: 'fc'
	})
	.otherwise({
		redirectTo : '/'
	});
});