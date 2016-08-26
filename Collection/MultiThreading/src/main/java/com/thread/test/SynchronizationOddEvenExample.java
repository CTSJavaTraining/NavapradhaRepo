package com.thread.test;
import org.apache.log4j.Logger;

/**
 * 
 * @author 523696
 *This class  prints odd and even sequence using two threads in Java 
 */

public class SynchronizationOddEvenExample {
	final static Logger logger = Logger.getLogger(SynchronizationOddEvenExample.class);
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {

                for (int itr = 1; itr < 21; itr = itr + 2) {
                    synchronized (lock) {
                        logger.info(Thread.currentThread().getName()+" " + itr );
                        try {
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
      
        Thread t2 = new Thread(new Runnable() {
            public void run() {

                for (int itr = 2; itr < 21; itr = itr + 2) {
                    synchronized (lock) {
                        logger.info(Thread.currentThread().getName()+" " + itr);
                        try {
                            lock.notify();
                            if(itr==20)
                                break;
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        try {
            t1.start();

            t2.start();

            
           
        } catch (Exception e) {

        }
    }
}
