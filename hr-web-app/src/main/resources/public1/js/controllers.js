/*
 * JS file for all of the Angular controllers in the app
 */
'use strict';

/* 
 * Define the TimeEntry controllers scope for Angular
 */
var hrRESTServiceControllers = angular.module('hrRESTServiceControllers', []);

var router_url = "http://demohrapp.cfapps.io";
/*
 * Controller for getting all entries. This controller makes an ajax call to the 
 * HR APP REST controller (/employees/) to get all of the entries, and uses
 * the results for the model.
 */ 
hrApp.controller('EmployeeListController', function($scope, $http) {
	
	//Handles the delete request function
	$scope.delete = function(employeeId) {
		console.log("deleting id " + employeeId);
		$http.delete(router_url + "/employees/" + employeeId).success(function(data, status, headers, config) {
			$scope.getEmployeeList();
			$scope.message = "Successfully deleted the employee.";
			$scope.error = ""
		}).error(function(data, status, headers, config) {
			$scope.message = "";
			$scope.error = "There was an error deleting the employee.";
		});
	};
	
	//Reloads the data
	$scope.getEmployeeList = function() {
		$http.get(router_url + '/employees/').success(function(data) {
			$scope.employees = data;
		})
	};

	//Initial page load
	$scope.getEmployeeList();
});

/*
 * Controller for editing a employee entry.  This controller handles both the initial
 * display of the employee, by making an ajax request to the HR APP REST controller
 * (/employees/:employeeId), and also handle the form submission by making an ajax post request
 * to the HR APP REST controller (/employees/:employeeId) with the form data.
 */ 
hrApp.controller('EditEmployeeEntryController', function($scope, $http, $routeParams) {
	
	//Handles the update request function
	$scope.update = function(employee) {
		console.log("updating employee: "+employee);
		$http.put(router_url + "/employees/" + $routeParams.employeeId, employee).success(function(data, status, headers, config) {
			$scope.employee = data;
			$scope.message = "Successfully saved the employee.";
			$scope.error = "";
		}).error(function(data, status, headers, config) {
			$scope.message = "";
			$scope.error = "There was an error saving the entry.";
		});
	};
	
	//Handles the reset request function and the initial load of the entry
	$scope.reset = function(employee) {
		$http.get(router_url + "/employees/" + $routeParams.employeeId).success(function(data) {
			$scope.employee = data;
			$scope.message = "";
			$scope.error = "";
		});
	}
	
	//Initial load
	$scope.reset();
});



