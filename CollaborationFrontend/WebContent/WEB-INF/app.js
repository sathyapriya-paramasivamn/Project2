var app = angular.module('myApp', [ 'ngRoute', 'ngCookies' ]);

angular.config(config);

config.$inject = [ '$routeProvider'];

app.config(function($routeProvider) {
	$routeProvider 
 
	.when('/', {
		templateUrl : 'index.html'

	})
 
	.when('/login', {
		templateUrl : 'user/login.html'

	})

	.when('/register', {
		templateUrl : 'user/register.html'

	})

	.otherwise({
		redirectTo : '/'
	});
})();
