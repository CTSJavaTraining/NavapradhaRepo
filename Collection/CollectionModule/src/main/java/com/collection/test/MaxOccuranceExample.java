package com.collection.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * @author 523696 
 * This class uses map to find the max occurred character in a given string
 */

public class MaxOccuranceExample {

	final static Logger logger = Logger.getLogger(MaxOccuranceExample.class);

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "employee";
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : str.toCharArray()) {
			if (map.containsKey(ch)) {

				int val = map.get(ch);

				map.put(ch, val + 1);
			} else {

				map.put(ch, 1);
			}
		}

		logger.info("The most occurred character in the given string is: "
				+ getKeyFromValue(map, (Collections.max(map.values()))));

	}

	/**
	 * 
	 * @param hm
	 * @param value
	 * @return key corresponding to the given value
	 */
	public static Object getKeyFromValue(Map hm, Object value) {
		for (Object o : hm.keySet()) {

			if (hm.get(o).equals(value)) {
				return o;
			}
		}
		return null;
	}

}
