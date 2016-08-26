package com.spring.IOCTest;
/**
 * @author 523696
 * Class to be injected as reference bean to DIExample.
 *
 */
public class InjectInnerBeans {
	
	 public InjectInnerBeans(){
	      System.out.println("Constructor injection- injecting the inner bean" );
	   }

	   public void checkSpelling() {
	      System.out.println("Constructor injection- inside inner bean invoking the checkSpelling method" );
	   }


}
