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

/**
 * @author 523696 Service class to invoke the methods in DAO layer.
 */

@WebService(endpointInterface = "com.empmgmt.service.EmployeeService", serviceName = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	final static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	EmployeeDAOImpl empDAO = new EmployeeDAOImpl();

	/**
	 * Method to invoke the getAllEmployees() in DAO.
	 */

	public void getAllEmployees() {
		// TODO Auto-generated method stub
		empDAO.getAllEmployees();

	}

	/**
	 * Method to get the emp object injected through bean.xml with its
	 * respective validation. set this emp value in the employee and pass the
	 * same to DAO layer to insert employee details.
	 */
	public void insertEmployee(List<Employee> employee) {

		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		Employee emp = (Employee) context.getBean("employee");

		Iterator<Employee> itr = employee.iterator();
		while (itr.hasNext()) {
			Employee e = (Employee) itr.next();
			e.setSalary(emp.getSalary());
			e.setGrade(emp.getGrade());
			e.setBonus(emp.getBonus());
		}
		empDAO.insertEmployee(employee);

	}

	/**
	 * Method to invoke the updateEmployee() in DAO.
	 */

	public void updateEmployee(Integer empId) {
		// TODO Auto-generated method stub
		empDAO.updateEmployee(empId);

	}

	/**
	 * Method to invoke the deleteEmployee() in DAO.
	 */
	public void deleteEmployee(Integer empId) {
		// TODO Auto-generated method stub
		empDAO.deleteEmployee(empId);

	}

}
