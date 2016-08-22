package com.thread.test;

/**
 * @author 523696
 * This class which will generate and set the transaction ID in thread local and then call the business method
 * 
 */

public class ThreadLocalDemo extends Thread {

	public static void main(String args[]) {

		Thread threadOne = new ThreadLocalDemo();
		threadOne.start();

		Thread threadTwo = new ThreadLocalDemo();
		threadTwo.start();
	}

	@Override
	public void run() {
		// sample code to simulate transaction id
		ThreadTest context = new ThreadTest();
		context.setTransactionId(getName());

		// set the context object in thread local to access it somewhere else
		MyThreadLocal.set(context);

		/* note that we are not explicitly passing the transaction id */
		new ThreadService().getTransactionId();
		MyThreadLocal.unset();

	}

}
