package io.pivotal.example.hrapp.domain;

import io.pivotal.example.hrapp.domain.listener.EmployeeListener;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@EntityListeners({EmployeeListener.class})
public class Employee {
	


	protected Employee() {
		super();
	}
	
	
	/**
	 * @param name
	 * @param hireDate
	 * @param salary
	 * @param isFullTime
	 * @param vacationDays
	 * @param comments
	 */
	public Employee(String name, Date hireDate, Double salary, Boolean isFullTime,
			Integer vacationDays, String comments) {
		this.name = name;
		this.hireDate = hireDate;
		this.salary = salary;
		this.isFullTime = isFullTime;
		this.vacationDays = vacationDays;
		this.comments = comments;
	}


	/**
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the hireDate
	 */
	public Date getHireDate() {
		return hireDate;
	}
	/**
	 * @param hireDate the hireDate to set
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	/**
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	/**
	 * @return the isFullTime
	 */
	public Boolean getIsFullTime() {
		return isFullTime;
	}
	/**
	 * @param isFullTime the isFullTime to set
	 */
	public void setIsFullTime(Boolean isFullTime) {
		this.isFullTime = isFullTime;
	}
	/**
	 * @return the vacationDays
	 */
	public Integer getVacationDays() {
		return vacationDays;
	}
	/**
	 * @param vacationDays the vacationDays to set
	 */
	public void setVacationDays(Integer vacationDays) {
		this.vacationDays = vacationDays;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	/**
	 * Overrides Object's toString method to return the
	 * state of the Employee object.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"Employee = [employeeId: %d, name: '%s', hireDate: '%tB %te, %tY', isFullTime: %b, vacationDays: %d, comments: %s]",
				employeeId, 
				name, 
				hireDate,
				isFullTime,
				vacationDays,
				comments);
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long employeeId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private Date hireDate;
	
	@Column(nullable=false)
	private Double salary;
	
	@Column(nullable=false)
	private Boolean isFullTime;
	
	@Column(nullable=false)
	private Integer vacationDays;
	
	@Column(nullable=false)
	private String comments;
}
