package com.basics.test;

import java.io.Serializable;

import org.apache.log4j.Logger;

/**
 * @author 523696
 * Class to demonstrate how to implement static and non-static variables.
 */

public class Employee implements Serializable {

	final static Logger logger = Logger.getLogger(Employee.class);
	private static int count = 23;// will get memory only once and retain its
									// value
	private int counter = 0;
	private String empname;
	private int salary;
	transient private String address;

	/**
	 * 
	 * Constructor to increment the static and non-static variable
	 */

	Employee() {
		count++;
		counter++;
		logger.info("Number of employee objects invoked--static:" + count);
		logger.info("Number of employee objects invoked--instance:" + counter);
	}

	/**
	 * 
	 * Constructor to instantiate the values for empname,salary and address
	 */

	Employee(String empname, int salary, String address) {
		this.empname = empname;
		this.salary = salary;
		this.address = address;

	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Employee.count = count;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Static method to validate the email
	 * 
	 * @param emailValidate holds the format to be validated against the email
	 * 
	 * @return boolean value
	 */

	public static void validateEmployeeEmail(String testEmail) {
		String emailValidate = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		;

		Boolean b = testEmail.matches(emailValidate);

		if (b == true) {
			logger.info("given e-mail: " + testEmail + " :Valid");
		} else {
			logger.info("given e-mail: " + testEmail + " :inValid");
		}

	}

}
