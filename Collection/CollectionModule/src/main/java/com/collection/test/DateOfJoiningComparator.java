package com.collection.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.log4j.Logger;

/**
 * @author 523696
 * This class implements Comparator and compares the list of Objects based on Date Of Joining,
 * @return boolean value based on comparison
 */
public class DateOfJoiningComparator implements Comparator {
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	Date dateOne = null;
	Date dateTwo = null;
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Employee employeeOne=(Employee)o1;  
		Employee employeeTwo=(Employee)o2;  
		
    	
		try {
			dateOne = sdf.parse(employeeOne.getDOJ());
			dateTwo = sdf.parse(employeeTwo.getDOJ());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	
	
		  
		return dateOne.compareTo(dateTwo);  

		
	}

}
