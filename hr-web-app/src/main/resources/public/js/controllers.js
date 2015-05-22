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
	
	$scope.findByIsFullTime = function(isFullTime) {
		console.log("searching by full-time status " + isFullTime);
		$http.get(router_url + "/employees/search/findByIsFullTime?isfulltime=" + isFullTime).success(function(data, status, headers, config) {
			console.log("response data: "+JSON.stringify(data));
			if(typeof(data._embedded.employees) != "undefined") {
				console.log("employees data: "+data._embedded.employees);
				console.log("employees response data: "+JSON.stringify(data._embedded.employees));
				$scope.employees = data._embedded.employees;				
			}
		}).error(function(data, status, headers, config) {
			$scope.message = "";
			$scope.error = "There was an error searching the employee by full-time status.";
		});		
	};
	
	$scope.findByHireDate = function(hireDate) {
		console.log("searching by hire date " + hireDate);
		$http.get(router_url + "/employees/search/findByHireDate?hiredate=" + hireDate).success(function(data, status, headers, config) {
			console.log("response data: "+JSON.stringify(data));
			if(typeof(data._embedded.employees) != "undefined") {
				console.log("employees data: "+data._embedded.employees);
				console.log("employees response data: "+JSON.stringify(data._embedded.employees));
				$scope.employees = data._embedded.employees;				
			}
		}).error(function(data, status, headers, config) {
			$scope.message = "";
			$scope.error = "There was an error searching the employee by hire date.";
		});		
	};
	
	$scope.findByName = function(name) {
		console.log("searching by name " + name);
		$http.get(router_url + "/employees/search/findByName?name=" + name).success(function(data, status, headers, config) {
			console.log("response data: "+JSON.stringify(data));
			if(typeof(data._embedded.employees) != "undefined") {
				console.log("employees data: "+data._embedded.employees);
				console.log("employees response data: "+JSON.stringify(data._embedded.employees));
				$scope.employees = data._embedded.employees;				
			}
		}).error(function(data, status, headers, config) {
			$scope.message = "";
			$scope.error = "There was an error searching the employee by name.";
		});		
	};
	
	//Reloads the data
	$scope.getEmployeeList = function() {
		$http.get(router_url + '/employees/').success(function(data) {
			console.log("response data: "+JSON.stringify(data));
			if(typeof(data._embedded.employees) != "undefined") {
				console.log("employees data: "+data._embedded.employees);
				console.log("employees response data: "+JSON.stringify(data._embedded.employees));
				$scope.employees = data._embedded.employees;				
			}
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
		console.log("updating employee: "+JSON.stringify(employee));
		if($routeParams.employeeId == "new") {
			if(typeof(employee.isFullTime) == "undefined") {
				employee.isFullTime = false;
			}
			$http.post(router_url + "/employees/", employee).success(function(data, status, headers, config) {
				$scope.employee = data;
				$scope.message = "Successfully saved the employee.";
				$scope.error = "";
			}).error(function(data, status, headers, config) {
				$scope.message = "";
				$scope.error = "There was an error saving the employee.";
			});
		} else {
			$http.put(router_url + "/employees/" + $routeParams.employeeId, employee).success(function(data, status, headers, config) {
				$scope.employee = data;
				$scope.message = "Successfully saved the employee.";
				$scope.error = "";
			}).error(function(data, status, headers, config) {
				$scope.message = "";
				$scope.error = "There was an error saving the entry.";
			});			
		}
	};
	
	//Handles the reset request function and the initial load of the entry
	$scope.reset = function(employee) {
		if($routeParams.employeeId != "new") {
			$http.get(router_url + "/employees/" + $routeParams.employeeId).success(function(data) {
				$scope.employee = data;
				$scope.message = "";
				$scope.error = "";
			});
		}
	}
	
	//Initial load
	$scope.reset();
});



