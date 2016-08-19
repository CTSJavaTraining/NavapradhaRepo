package com.collection.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

	private String name;
	private Address address;
	private int salary;
	private int id;
	private String designation;
	private String DOJ;

	Employee(String name, int id, String designation, String DOJ, Address address, int salary) {
		this.name = name;
		this.id = id;
		this.designation = designation;
		this.DOJ = DOJ;
		this.address = address;
		this.salary = salary;

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDOJ() {
		return DOJ;
	}

	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}
	
	public Date calculateDate(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    	Date date = null;
    	
		try {
			date = sdf.parse(getDOJ());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
	}
	
	
	
	  

}
