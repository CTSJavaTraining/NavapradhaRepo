package com.attendance.DAOServiceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.attendance.DAOService.AttendanceDAO;
import com.attendance.bean.AttendanceDetails;
import com.attendance.bean.Employee;
import com.attendance.exception.DAOException;
import com.attendance.util.JPAUtil;


public class AttendanceDAOImpl implements AttendanceDAO {
	
	EntityManager entityManager = null;
	
	Query query = null;
	
	final static Logger logger = Logger.getLogger(AttendanceDAOImpl.class);

	@Override
	public List<AttendanceDetails> getAttendanceDetails() throws Exception  {
		
		entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		 query = entityManager
					.createQuery("SELECT attendance FROM AttendanceDetails attendance");
		
		return query.getResultList();
	}

	@Override
	public void insertSwipeHours(List<AttendanceDetails> employee) throws Exception {
		// TODO Auto-generated method stub
		
		entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		
		employee.forEach( (emp) -> {
			try {
				getEmployee(emp.getEmployee_id(),emp.getAccess_cardno());
				entityManager.persist(emp);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.info(e.getMessage());
			}
		} );
		
		entityManager.getTransaction().commit();
		logger.info("Records inserted successfully");
		
	
		

		
	
		
	}

	@Override
	public void getEmployee(int empId,int cardno) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("The given Employee ID is:"+empId);
		
			entityManager = JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			 query = entityManager
					.createQuery("SELECT e FROM Employee e WHERE e.employee_id= :id and e.access_cardno= :cardNo and e.active_status= :status");
			query.setParameter("id", empId);
			query.setParameter("cardNo", cardno);
			query.setParameter("status", "Y");
			int employeeSize = query.getResultList().size();
			if(employeeSize==0){
				throw new DAOException("The given Employee ID and access card no combination doesn't match with any data or doesn't exists in DB");
			}else{
				logger.info("Inserting the attendance details in DB");
			}
			
			
			
			
		
	}

}
