package com.thread.test;

import org.apache.log4j.Logger;



/**
 * @author 523696
 * this class  will read from thread local and use the value.
 * 
 */

public class ThreadService {
	final static Logger logger = Logger.getLogger(ThreadService.class);
	public void getTransactionId() {
		// get the context from thread local
		ThreadTest context = MyThreadLocal.get();
		logger.info(context.getTransactionId());
	}


}
