/**
 * 
 */
package com.attendance.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

/**
 * @author 523696
 *
 */
@Entity
@Table(name = "attendancedetails")
public class AttendanceDetails {
	public int getAttendance_id() {
		return attendance_id;
	}
	public void setAttendance_id(int attendance_id) {
		this.attendance_id = attendance_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public int getAccess_cardno() {
		return access_cardno;
	}
	public void setAccess_cardno(int access_cardno) {
		this.access_cardno = access_cardno;
	}
	public String getSwipe_in() {
		return swipe_in;
	}
	public void setSwipe_in(String swipe_in) {
		this.swipe_in = swipe_in;
	}
	public String getSwipe_out() {
		return swipe_out;
	}
	public void setSwipe_out(String swipe_out) {
		this.swipe_out = swipe_out;
	}
	public int getTotal_hours() {
		return total_hours;
	}
	public void setTotal_hours(int total_hours) {
		this.total_hours = total_hours;
	}
	public int getMachine_id() {
		return machine_id;
	}
	public void setMachine_id(int machine_id) {
		this.machine_id = machine_id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@Id
	
	@Column(name = "attendance_id")
	private int attendance_id;
	@Column(name = "employee_id")
	private int employee_id;
	@Column(name = "access_cardno")
	private int access_cardno;
	@Column(name = "swipe_in")
	private String swipe_in;
	@Column(name = "swipe_out")
	private String swipe_out;
	@Column(name = "total_hours")
	private int total_hours;
	@Column(name = "machine_id")
	private int machine_id;
	   @OneToOne(optional=true) @PrimaryKeyJoinColumns({
	        @PrimaryKeyJoinColumn(name="employee_id", referencedColumnName="employee_id"), 
	        @PrimaryKeyJoinColumn(name="access_cardno", referencedColumnName="access_cardno")
	    })
	private Employee employee;
	

}
