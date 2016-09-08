package com.empmgmt.bean;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * @author 523696 Bean class with variables and appropriate getters and setters
 *         used for accessing variables.
 *
 */
@Entity

public class Employee {

	@Id
	@GeneratedValue
	private int employeeId;
	private String employeeName;
	private String designation;
	private int salary;
	private int bonus;
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "employeeId")

	private List<Address> Address;
	private String dateOfJoining;
	private String grade;
	private String emailId;

	/**
	 * 
	 * @return
	 */

	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * 
	 * @param employeeId
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * 
	 * @return
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * 
	 * @param employeeName
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * 
	 * @return
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * 
	 * @param designation
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * 
	 * @return
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * 
	 * @param salary
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	/**
	 * 
	 * @return
	 */
	public int getBonus() {
		return bonus;
	}

	/**
	 * 
	 * @param bonus
	 */
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	/**
	 * 
	 * @return
	 */
	public List<Address> getAddress() {
		return Address;
	}

	/**
	 * 
	 * @param address
	 */

	public void setAddress(List<Address> address) {
		Address = address;
	}

	/**
	 * 
	 * @return
	 */
	public String getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * 
	 * @param dateOfJoining
	 */
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * 
	 * @return
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * 
	 * @param grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * 
	 * @return
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * 
	 * @param emailId
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
