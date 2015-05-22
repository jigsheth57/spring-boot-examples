/**
 * 
 */
package io.pivotal.example.hrapp.repository;

import java.sql.Date;
import java.util.List;

import io.pivotal.example.hrapp.domain.Employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * JPA CRUD repository interface for a <code>Employee</code> domain object.
 * 
 * @author Jig Sheth
 *
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	/**
	 * Find all of the employee entries with the specified Name.
	 * @param name The name of the Employee to find entries for.
	 * @return A list of employees with a matching name.
	 */
	List<Employee> findByName(@Param("name") String name); 
	
	/**
	 * Find all of the employee entries with the specified hire date.
	 * @param hireDate The employee's hire date to find entries for.
	 * @return A list of employees with a matching hire date.
	 */
	List<Employee> findByHireDate(@Param("hiredate") Date hireDate);	

	/**
	 * Find all of the employee entries with the specified full-time status.
	 * @param isFullTime The employee's full-time status to find entries for.
	 * @return A list of employees with a matching full-time status.
	 */
	List<Employee> findByIsFullTime(@Param("isfulltime") Boolean isFullTime);	
}
