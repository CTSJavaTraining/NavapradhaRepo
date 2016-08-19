package com.collection.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author 523696
 * This class implements Comparator and compares the list of Objects based on name,
 * @return boolean value based on comparison
 */
public class NameComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Employee s1=(Employee)o1;  
		Employee s2=(Employee)o2;  
	
		  
		return s1.getName().compareTo(s2.getName());  

		
	}

}
