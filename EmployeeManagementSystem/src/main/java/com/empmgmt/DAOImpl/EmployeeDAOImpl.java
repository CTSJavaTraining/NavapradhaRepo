package com.empmgmt.DAOImpl;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.empmgmt.DAOInterface.EmployeeDAO;
import com.empmgmt.bean.Employee;
import com.empmgmt.util.EmployeeUtil;


public class EmployeeDAOImpl implements EmployeeDAO {
	
	EntityManager entityManager = null;

    Employee employee=null;


	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		entityManager=EmployeeUtil.getEntityManager();
		 entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("SELECT e FROM Employee e");
		List<Employee> employeeList =query.getResultList();
		for (Employee employee : employeeList) {
			System.out.println("Employee Name:"+employee.getEmployeeName());
		}
		return query.getResultList();
	}

	public void insertEmployee(List<Employee> employee) {
		// TODO Auto-generated method stub
//		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//		EntityManager em = factory.createEntityManager();
//		
//		em.persist(employee);
		System.out.println("inserting a employee");
		entityManager=EmployeeUtil.getEntityManager();
		 entityManager.getTransaction().begin();
		 Iterator itr=employee.iterator();  
			while(itr.hasNext()){  
				Employee emp=(Employee)itr.next(); 
			
				 entityManager.persist(emp);
				
			//System.out.println(emp.getName()+"   "+st.getId()+"   "+st.getDesignation()+ "    "+st.getDOJ()+"    "+st.getAddress().city+ "   "+st.getSalary());  
			}

			 entityManager.getTransaction().commit();

        
		
	}

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		entityManager=EmployeeUtil.getEntityManager();
		 entityManager.getTransaction().begin();
		  entityManager.merge(employee);

          entityManager.getTransaction().commit();
		
	}

	public void deleteEmployee(Integer empId) {
		// TODO Auto-generated method stub
		entityManager=EmployeeUtil.getEntityManager();
		 entityManager.getTransaction().begin();
		    Employee emp = (Employee)entityManager.find(Employee.class, empId);

            entityManager.remove(emp);

            entityManager.getTransaction().commit();
	}

}
