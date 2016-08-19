package com.collection.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

import org.apache.log4j.Logger;

/**
 * @author 523696
 * This class sorts the object based on different atrributes of the Employee
 */
public class SortEmployee {
	
	final static Logger logger = Logger.getLogger(SortEmployee.class);
	
	/**
	 * Method to sort the objects based on name
	 */
	
	public void sortByName(List<Employee> employeeList){
		
		logger.debug("Sorting by Name...");  
		  
		Collections.sort(employeeList,new NameComparator());  
		
		Iterator itr=employeeList.iterator();  
		while(itr.hasNext()){  
			Employee st=(Employee)itr.next();  
		logger.debug(st.getName()+"   "+st.getId()+"   "+st.getDesignation()+ "    "+st.getDOJ()+"    "+st.getAddress().city+ "   "+st.getSalary());  
		}
		
	}
	
	/**
	 * Method to filter the employees with salary greater than 10000 and sort by address using Lambda expressions
	 * 
	 */
	
	public void sortByAddress(List<Employee> employeeList){
		
		logger.debug("Sorting by  address...");  


		employeeList
	    .stream()
	    .filter(e -> e.getSalary() > 10000)
	   
	    .sorted((e1, e2) -> e1.getAddress().city
	            .compareTo(e2.getAddress().city))
	    .forEach(e -> logger.debug(e.getName()+"   "+e.getId()+"   "+e.getDesignation()+ "    "+e.getDOJ()+"    "+e.getAddress().city+ "   "+e.getSalary()));
	    
		
	}
	
	/**
	 * Method to sort the employee object based on date of joining 
	*/
	
	public void  sortByDateOfJoining(List<Employee> employeeList){
		
		logger.debug("Sorting by Date Of joining...");  
		  
		Collections.sort(employeeList,new NameComparator());  
		
		Iterator itr=employeeList.iterator();  
		while(itr.hasNext()){  
			Employee st=(Employee)itr.next();  
		logger.debug(st.getName()+"   "+st.getId()+"   "+st.getDesignation()+ "    "+st.getDOJ()+"    "+st.getAddress().city+ "   "+st.getSalary());  
		}
		
	}
	
	/**
	 * Method to maintain the insertion order based on Date Of Joining
	*/
	
	public void dateOfJoiningInsertionOrder(List<Employee> employeeList){
		
		logger.debug("Maintain the insertion order of the employees...");  
		
		 Iterator<Employee> itr=employeeList.iterator();  
		  while(itr.hasNext()){  
			  Employee employee=(Employee)itr.next(); 
			  logger.debug(employee.getName()+"   "+employee.getId()+"   "+employee.getDesignation()+ "    "+employee.getDOJ()+"    "+employee.getAddress().city+ "   "+employee.getSalary());  
		  } 
		
	}
	
	public static void main(String args[]) {
		
		SortEmployee sortemployee = new SortEmployee();
	
		
	Address addressOne=new Address("gzb","UP","india");  
	Address addressTwo=new Address("gno","UP","india");
	

	List<Employee> employeeList=new ArrayList<Employee>();  
	employeeList.add(new Employee("Vijay",23,"system engg","21-06-2010",addressOne,5000));  
	employeeList.add(new Employee("Ajay",27,"senior sys engg","22-06-2010",addressTwo,10000));  
	employeeList.add(new Employee("Jai",21,"tech analyst","23-06-2010",addressTwo,15000));
	employeeList.add(new Employee("JJai",22,"tech analyst","23-06-2010",addressTwo,15000));
	  
	LinkedList<Employee> employeeObjects=new LinkedList<Employee>(); 
	employeeObjects.add(new Employee("Vijay",23,"system engg","21/06/2010",addressOne,5000));  
	employeeObjects.add(new Employee("Ajay",27,"senior sys engg","22/06/2010",addressTwo,10000));  
	employeeObjects.add(new Employee("Jai",21,"tech analyst","23/06/2010",addressTwo,15000));
	employeeObjects.add(new Employee("JJai",22,"tech analyst","23/06/2010",addressTwo,15000));
	
	
	sortemployee.sortByName(employeeList);
	sortemployee.sortByAddress(employeeList);
	sortemployee.sortByDateOfJoining(employeeList);
	sortemployee.dateOfJoiningInsertionOrder(employeeObjects);
	

	
	
	
	}

}
