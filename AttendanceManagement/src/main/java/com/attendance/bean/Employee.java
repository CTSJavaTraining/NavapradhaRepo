package com.attendance.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private int employee_id;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "access_cardno")
	private int access_cardno;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "active_status")
	private String active_status;

	@Column(name = "employeetype")
	private String employee_type;
	
	 @OneToOne(optional=true, mappedBy="employee",cascade = CascadeType.PERSIST)
	    private AttendanceDetails attendanceDetails;

	/**
	 * @return the employee_id
	 */
	public int getEmployee_id() {
		return employee_id;
	}

	/**
	 * @param employee_id
	 *            the employee_id to set
	 */
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	/**
	 * @return the access_cardno
	 */
	public int getAccess_cardno() {
		return access_cardno;
	}

	/**
	 * @param access_cardno
	 *            the access_cardno to set
	 */
	public void setAccess_cardno(int access_cardno) {
		this.access_cardno = access_cardno;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the active_status
	 */
	public String getActive_status() {
		return active_status;
	}

	/**
	 * @param active_status
	 *            the active_status to set
	 */
	public void setActive_status(String active_status) {
		this.active_status = active_status;
	}

	/**
	 * @return the employee_type
	 */
	public String getEmployee_type() {
		return employee_type;
	}

	/**
	 * @param employee_type
	 *            the employee_type to set
	 */
	public void setEmployee_type(String employee_type) {
		this.employee_type = employee_type;
	}

}
