package com.basics.test;

import org.apache.log4j.Logger;

public class StringTest {
	
	final static Logger logger = Logger.getLogger(StringTest.class);

	public static void main(String args[]) {
		String s1 = "java";// creating string by java string literal
		
		String s2 = "java";

		s1.concat("hello");

		String s3 = new String("example");// creating java string by new keyword

		logger.info("immutable:"+s1);
		
		String s4 = new String("example");
		
		s1 = s1.concat("hello");
		
		logger.info("mutable due to new reference:"+s1);
		
		logger.info("New reference created:"+s3);
		
		if(s1==s2){
			
			logger.info("reference are equal-String literal");
		}
		
		if(s1.equals(s2)){
			logger.info("given values are equal-String literal");
		}
		
		if(s3==s4){
			logger.info("reference are equal-String objects");
		}
		
		if(s3.equals(s4)){
			logger.info("given values are equal-String objects");
		}

	}
}
