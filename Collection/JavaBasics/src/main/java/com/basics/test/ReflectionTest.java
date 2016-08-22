package com.basics.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
/**
 * @author 523696 
 * Class load the employee and access the methods,fields using reflection.
 */
public class ReflectionTest {
	final static Logger logger = Logger.getLogger(ReflectionTest.class);
	public static void main(String args[]) {
		try {
			String className = "com.employee.test.Employee";
			Class c = Class.forName(className);
			Method[] methods = c.getMethods();
			Field[] fields = c.getDeclaredFields();
			logger.info("Reflection Class Name:" + c.getSimpleName());
			logger.info("Reflection Methods Name:" + methods[1]);
			logger.info("Reflection fileds Name:" + fields[1]);
		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

	}

}