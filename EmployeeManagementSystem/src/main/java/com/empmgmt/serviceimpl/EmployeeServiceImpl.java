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

@WebService(endpointInterface = "com.empmgmt.service.EmployeeService", serviceName = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDAOImpl empDAO = new EmployeeDAOImpl();


public void getAllEmployees() {
	// TODO Auto-generated method stub
	empDAO.getAllEmployees();
	
}

public void insertEmployee(List<Employee> employee) {
	
	// TODO Auto-generated method stub

	
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
