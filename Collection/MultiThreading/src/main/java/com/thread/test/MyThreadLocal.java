package com.thread.test;

/**
 * @author 523696
 * this class acts as a container to our thread local variables.
 * 
 */

public class MyThreadLocal {
	
	public static final	ThreadLocal userThreadLocal = new ThreadLocal();

	public static void set(ThreadTest user) {
		userThreadLocal.set(user);
	}

	public static void unset() {
		userThreadLocal.remove();
	}

	public static ThreadTest get() {
		return (ThreadTest) userThreadLocal.get();
	}


}
