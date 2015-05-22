var hrApp = angular.module('hrApp', ['ngRoute', 'hrRESTServiceControllers']);

hrApp.config(['$routeProvider', 
    function($routeProvider) {
		$routeProvider.when('/employees', {
			templateUrl: '/partials/employeeList.html',
			controller: 'EmployeeListController'
		}).when('/employees/:employeeId', {
			templateUrl: '/partials/editEmployeeEntry.html',
			controller: 'EditEmployeeEntryController'
		}).otherwise({
			redirectTo: '/employees'
		})
}])