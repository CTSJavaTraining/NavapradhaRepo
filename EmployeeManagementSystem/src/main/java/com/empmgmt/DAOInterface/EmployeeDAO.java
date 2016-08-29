package com.empmgmt.DAOInterface;

import java.util.List;

import com.empmgmt.bean.Employee;

public interface EmployeeDAO {
	
	
	public List<Employee> getAllEmployees();
    
    public void insertEmployee(List<Employee> employee);
    
    public void updateEmployee(Employee employee);
    
    public void deleteEmployee(Integer empId);
}
