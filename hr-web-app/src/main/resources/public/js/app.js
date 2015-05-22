var hrApp = angular.module('hrApp', ['ngRoute', 'hrRESTServiceControllers']);

hrApp.config(['$routeProvider', 
    function($routeProvider) {
		$routeProvider.when('/web/employees', {
			templateUrl: '/partials/employeeList.html',
			controller: 'EmployeeListController'
		}).when('/web/employees/:employeeId', {
			templateUrl: '/partials/editEmployeeEntry.html',
			controller: 'EditEmployeeEntryController'
		}).otherwise({
			redirectTo: '/web/employees'
		})
}])