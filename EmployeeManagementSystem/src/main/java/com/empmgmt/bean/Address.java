package com.empmgmt.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



/**
 * @author 523696 
 * Bean class with variables and appropriate getters and setters  used for accessing variables.
 */
@Entity
public class Address {
	@Id
	@GeneratedValue
    private int addressId;
public int getAddressId() {
	return addressId;
}

public void setAddressId(int addressId) {
	this.addressId = addressId;
}

@ManyToOne(cascade = CascadeType.PERSIST)
@JoinColumn(name="employeeId")

	private Employee employee;
	public Employee getEmployee() {
	return employee;
}

public void setEmployee(Employee employee) {
	this.employee = employee;
}

	private int doorNo;
	private String streetName;
	private String state;



	/**
	 * 
	 * @return
	 */
	public int getDoorNo() {
		return doorNo;
	}

	/**
	 * 
	 * @param doorNo
	 */
	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}

	/**
	 * 
	 * @return
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * 
	 * @param streetName
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * 
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

}
