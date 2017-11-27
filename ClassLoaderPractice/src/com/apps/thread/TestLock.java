package com.apps.thread;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock extends ReentrantLock implements Runnable {

	@Override
	public void run() {
      System.out.println("this is run method from test class");
      testSynchLock();
      testNormalLock();      
	}
    public synchronized String testSynchLock(){
    	try{
    		Thread.sleep(1000);
    	}catch(Exception e){
    		e.printStackTrace();
    	}

    	
    	System.out.println("testSynchLock() method executed by the threads "+Thread.currentThread().getName());
    	return Thread.currentThread().getName();
    } 
    public String testNormalLock(){
    	this.lock();
    	try{
    		Thread.sleep(1000);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	System.out.println("this is locking concept method "+Thread.currentThread().getName());
    	System.out.println("No of threads in current pool is ");
    	this.unlock();
    	return Thread.currentThread().getName();
    	
    }
	
}
