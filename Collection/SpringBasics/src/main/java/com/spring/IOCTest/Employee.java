package com.spring.IOCTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

	private String name;
	
	private int salary;
	private int id;
	private String designation;
	private String DOJ;

	

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
	

	
	
	
	  

}
