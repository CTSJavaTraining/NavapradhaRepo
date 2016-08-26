package com.spring.IOCTest;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * @author 523696
 * This class invokes the beans from xml .
 * Gets the values injected through constructor and setters through beans.xml
 */
public class IOCExample {
	final static Logger logger = Logger.getLogger(IOCExample.class);

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		DIExample objB = (DIExample) context.getBean("iocExampleTest");
		objB.getMessage();
		objB.getInjectInnerBeans().checkSpelling();

		DIExample objC = (DIExample) context.getBean("iocExample");
		String getInjectedValue = objC.getConstructorInjection();
		logger.debug("Constructor injection-injecting a string value: " + getInjectedValue);

		objC.getEmployeeList().forEach(
				employee -> logger.debug("Using list - setter injection: " + employee.getId() + " " + employee.getName()
						+ " " + employee.getDOJ() + " " + employee.getDesignation() + " " + employee.getSalary()));
		objC.getEmployeeSet().forEach(
				employee -> logger.debug("Using set - setter injection: " + employee.getId() + " " + employee.getName()
						+ " " + employee.getDOJ() + " " + employee.getDesignation() + " " + employee.getSalary()));

		objC.getEmployeeMap().forEach((k, v) -> logger.debug("Using map - setter injection: Key: " + k + ": Value: "
				+ v.getName() + " " + v.getId() + " " + v.getDOJ() + " " + v.getDesignation() + " " + v.getSalary()));
	}

}
