package com.empmgmt.serviceimpl;

import java.util.ArrayList;

import java.util.List;

import javax.jws.WebService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.empmgmt.DAOImpl.EmployeeDAOImpl;
import com.empmgmt.bean.Employee;
import com.empmgmt.service.EmployeeService;

import com.empmgmt.bean.Address;
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
	
	
	emp.setEmployeeName(employee.get(0).getEmployeeName());
	emp.setDateOfJoining(employee.get(0).getDateOfJoining());
	emp.setDesignation(employee.get(0).getDesignation());
	emp.setAddress(employee.get(0).getAddress());
	emp.setEmailId(employee.get(0).getEmailId());
	

	empDAO.insertEmployee(employee);
	
}

public void updateEmployee(Employee employee) {
	// TODO Auto-generated method stub
	empDAO.updateEmployee(employee);
	
}

public void deleteEmployee(Integer empId) {
	// TODO Auto-generated method stub
	empDAO.deleteEmployee(empId);
	
}

}
