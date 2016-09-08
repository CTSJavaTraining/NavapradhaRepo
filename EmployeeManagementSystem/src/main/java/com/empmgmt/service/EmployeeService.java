package com.empmgmt.service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import com.empmgmt.bean.Employee;

@WebService
public interface EmployeeService {

	@WebMethod
	public void getAllEmployees();

	@WebMethod
	public void insertEmployee(List<Employee> employee);

	@WebMethod
	public void updateEmployee(Integer empId);

	@WebMethod
	public void deleteEmployee(Integer empId);

}
