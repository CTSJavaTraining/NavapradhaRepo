package com.empmgmt.DAOImpl;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.Query;

import com.empmgmt.DAOInterface.EmployeeDAO;
import com.empmgmt.bean.Employee;
import com.empmgmt.util.EmployeeUtil;

import org.apache.log4j.Logger;

/**
 * @author 523696 EmployeeDAOImpl class performs the CRUD operations
 */

public class EmployeeDAOImpl implements EmployeeDAO {

	EntityManager entityManager = null;

	Employee employee = null;

	final static Logger logger = Logger.getLogger(EmployeeDAOImpl.class);

	/**
	 * Method to fetch the employee records and return the employee list
	 */

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		entityManager = EmployeeUtil.getEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("SELECT e FROM Employee e");

		List<Employee> employeeList = query.getResultList();
		if (employeeList != null) {
			for (Employee employee : employeeList) {
				logger.info("Employee Name:" + employee.getEmployeeName());
			}
		}
		return query.getResultList();
	}

	/**
	 * Method to insert the employee and persist
	 */
	public void insertEmployee(List<Employee> employee) {
		// TODO Auto-generated method stub

		logger.info("inserting a employee");
		entityManager = EmployeeUtil.getEntityManager();
		entityManager.getTransaction().begin();
		Iterator<Employee> itr = employee.iterator();
		while (itr.hasNext()) {
			Employee emp = (Employee) itr.next();

			entityManager.persist(emp);

		}

		entityManager.getTransaction().commit();
		logger.info("Records inserted successfully");
		getAllEmployees();

	}

	/**
	 * Method to update the employee name based on the employee id.
	 */

	public void updateEmployee(Integer empId) {
		// TODO Auto-generated method stub
		entityManager = EmployeeUtil.getEntityManager();
		entityManager.getTransaction().begin();
		logger.debug("Employee Id given:"+empId);
		Query query = entityManager
				.createQuery("UPDATE Employee e SET e.designation = 'system engineer' " + "WHERE e.id= :id");
		query.setParameter("id", empId);

		int updateCount = query.executeUpdate();
		if (updateCount > 0) {
			logger.info("Record Updated Successfully");
			entityManager.getTransaction().commit();
		}else{
			logger.info("Entered EmpId is invalid.No such data present in DB");
		}

		

	}

	/**
	 * Method to delete the employee based on the employee id.
	 */

	public void deleteEmployee(Integer empId) {
		// TODO Auto-generated method stub
		entityManager = EmployeeUtil.getEntityManager();
		entityManager.getTransaction().begin();
		logger.debug("Employee Id given:"+empId);
		Employee emp = (Employee) entityManager.find(Employee.class, empId);
        if(emp!=null){
		entityManager.remove(emp);
		entityManager.getTransaction().commit();
		logger.info("Record Deleted Successfully");
        }else{
        	logger.info("Entered EmpId is invalid.No such data present in DB");
        }

		
	}

}
