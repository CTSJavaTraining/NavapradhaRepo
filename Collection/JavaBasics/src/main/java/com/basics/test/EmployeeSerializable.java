package com.basics.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.log4j.Logger;

/**
 * @author 523696 
 * Class to serialize and de-serialize the employee object.
 */
public class EmployeeSerializable {
	final static Logger logger = Logger.getLogger(EmployeeSerializable.class);
	Employee employee = null;

	/**
	 * 
	 * Constructor to instantiate the values for empname,salary,address and
	 * count
	 */

	EmployeeSerializable(Employee employee) {
		this.employee = employee;
		employee.setAddress("xxx");
		Employee.setCount(1);
		employee.setEmpname("test");
		employee.setSalary(5000);

	}

	/**
	 * Method to serialize the employee object into the text file
	 * 
	 */

	public void serializeEmployee() {

		try {

			FileOutputStream fos = new FileOutputStream("D:\\test.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(employee);
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Serialize Success");

	}

	/**
	 * Method to de-serialize the employee object from the text file
	 * 
	 */

	public void deserializeEmployee() {
		Employee employee = null;
		try {
			FileInputStream fis = new FileInputStream("D:\\test.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			employee = (Employee) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("De-Serialize Success:" + employee.getEmpname() + " " + employee.getSalary() + " "
				+ Employee.getCount() + " " + employee.getAddress());

	}

	public static void main(String args[]) {
		Employee employee = new Employee();
		EmployeeSerializable e = new EmployeeSerializable(employee);
		e.serializeEmployee();
		e.deserializeEmployee();

	}

}
