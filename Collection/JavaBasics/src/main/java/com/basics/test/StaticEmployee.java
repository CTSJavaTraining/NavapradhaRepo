package com.basics.test;

public class StaticEmployee {
	//static block gets invoked before the main method
	static{System.out.println("count the total number of employee objects");} 
	public static void main(String args[]){
		 Employee e  = new Employee();
		
		Employee.validateEmployeeEmail("testemail@gmail.com");
		 Employee e1  = new Employee();
		 Employee e2  = new Employee();
	}

}
