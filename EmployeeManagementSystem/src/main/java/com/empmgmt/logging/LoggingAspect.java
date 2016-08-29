package com.empmgmt.logging;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class LoggingAspect {
	final static Logger logger = Logger.getLogger(LoggingAspect.class);
	@Before("execution(* com.empmgmt.DAOImpl.EmployeeDAOImpl.getAllEmployees(..))")
	public void logBefore(JoinPoint joinPoint) {
		
		logger.info("logBefore() is running!");
		logger.info("Checking : " + joinPoint.getSignature().getName());
		logger.info("******");
	}



}
