package com.empmgmt.serviceimpl;


import java.util.Iterator;
import java.util.List;

import javax.jws.WebService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.empmgmt.DAOImpl.EmployeeDAOImpl;
import com.empmgmt.bean.Employee;
import com.empmgmt.service.EmployeeService;


import org.apache.log4j.Logger;

@WebService(endpointInterface = "com.empmgmt.service.EmployeeService", serviceName = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	final static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);
	
	EmployeeDAOImpl empDAO = new EmployeeDAOImpl();


public void getAllEmployees() {
	// TODO Auto-generated method stub
	empDAO.getAllEmployees();
	
}

public void insertEmployee(List<Employee> employee) {
	
	// TODO Auto-generated method stub
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

	Employee emp = (Employee) context.getBean("employee");
	
	Iterator<Employee> itr=employee.iterator();  
	while(itr.hasNext()){  
		Employee e=(Employee)itr.next(); 
		e.setSalary(emp.getSalary());
		e.setGrade(emp.getGrade());
		e.setBonus(emp.getBonus());
	}
	empDAO.insertEmployee(employee);
	
}

public void updateEmployee(Integer empId) {
	// TODO Auto-generated method stub
	empDAO.updateEmployee(empId);
	
}

public void deleteEmployee(Integer empId) {
	// TODO Auto-generated method stub
	empDAO.deleteEmployee(empId);
	
}

}
