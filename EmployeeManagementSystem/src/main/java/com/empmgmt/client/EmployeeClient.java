package com.empmgmt.client;

import java.util.ArrayList;
import java.util.List;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import com.empmgmt.bean.Employee;
import com.empmgmt.service.EmployeeService;

/**
 * 
 * @author 523696
 *
 */

public class EmployeeClient {
	
	public static void main(String[] args) {
		String serviceUrl = "http://localhost:8080/employee/employeeservice?wsdl";
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(EmployeeService.class);
		factory.setAddress(serviceUrl);
		EmployeeService employeeService = (EmployeeService) factory.create();

		List<Employee> employeeList = new ArrayList<Employee>();


	employeeService.insertEmployee(employeeList);
	employeeService.getAllEmployees();
	employeeService.updateEmployee(3);
	employeeService.deleteEmployee(3);
	}

}
