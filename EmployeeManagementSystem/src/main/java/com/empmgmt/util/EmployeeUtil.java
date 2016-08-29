package com.empmgmt.util;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EmployeeUtil {
	private static final String PERSISTENCE_UNIT_NAME = "Employee";
	
	 private static final EntityManagerFactory entityManagerFactory;

     static {

       try {

         entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

         



       } catch (Throwable ex) {          

         throw new ExceptionInInitializerError(ex);

       }

     }



     public static EntityManager getEntityManager() {

       return entityManagerFactory.createEntityManager();



     }

}
