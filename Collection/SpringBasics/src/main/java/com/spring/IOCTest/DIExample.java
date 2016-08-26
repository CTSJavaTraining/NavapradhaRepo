package com.spring.IOCTest;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * @author 523696 Class with setters and getters to be instantiated as bean and
 *         accessed.
 */
public class DIExample {
	final static Logger logger = Logger.getLogger(DIExample.class);
	private String message;

	private String constructorInjection;

	private InjectInnerBeans injectInnerBeans;

	private List<Employee> employeeList;

	private Set<Employee> employeeSet;

	private Map<Integer, Employee> employeeMap;

	public DIExample(String constructorInjection) {

		this.constructorInjection = constructorInjection;

	}

	public DIExample(InjectInnerBeans injectInnerBeans) {

		this.injectInnerBeans = injectInnerBeans;

	}

	/**
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public void getMessage() {
		logger.info("Setter injection-injecting a string value: " + message);
	}

	/**
	 * 
	 * @param constructorInjection
	 */

	public void setConstructorInjection(String constructorInjection) {
		this.constructorInjection = constructorInjection;
	}

	/**
	 * 
	 * @return
	 */
	public String getConstructorInjection() {
		return constructorInjection;
	}

	/**
	 * 
	 * @param injectInnerBeans
	 */
	public void setInjectInnerBeans(InjectInnerBeans injectInnerBeans) {
		this.injectInnerBeans = injectInnerBeans;
	}

	/**
	 * 
	 * @return
	 */

	public InjectInnerBeans getInjectInnerBeans() {
		return injectInnerBeans;
	}

	/**
	 * 
	 * @param employeeList
	 */
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	/**
	 * 
	 * @return
	 */
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	/**
	 * 
	 * @param employeeSet
	 */

	public void setEmployeeSet(Set<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}

	/**
	 * 
	 * @return
	 */

	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}

	/**
	 * 
	 * @param employeeMap
	 */
	public void setEmployeeMap(Map<Integer, Employee> employeeMap) {
		this.employeeMap = employeeMap;
	}

	/**
	 * 
	 * @return
	 */
	public Map<Integer, Employee> getEmployeeMap() {
		return employeeMap;
	}

}
