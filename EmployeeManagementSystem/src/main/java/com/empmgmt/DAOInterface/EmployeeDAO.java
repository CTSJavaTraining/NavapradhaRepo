package com.empmgmt.DAOInterface;

import java.util.List;

import com.empmgmt.bean.Employee;

public interface EmployeeDAO {
	
	
	public List<Employee> getAllEmployees();
    
    public void insertEmployee(List<Employee> employee);
    
    public void updateEmployee(Integer empId);
    
    public void deleteEmployee(Integer empId);
}
