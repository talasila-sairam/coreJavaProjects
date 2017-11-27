package com.apps.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class LocksInJava {
   public static void main(String[] args)throws Exception {
	TestLock testLock1 = new TestLock();
	TestLock testLock2 = new TestLock();
	TestLock testLock3 = new TestLock();
	
	//Running three threads for concuurency
	/*Thread thread1 = new Thread(testLock1);
	Thread thread2 = new Thread(testLock1);
	Thread thread3 = new Thread(testLock1);*/
	
	//Running three threads at a time
	
	/*thread1.start();
	thread2.start();
	thread3.start();*/
	
	//Through Executors Running the above program
	AtomicInteger atomicInteger = new AtomicInteger();
	ExecutorService executorService = Executors.newFixedThreadPool(10);
	System.out.println();
	for(int i=0;i<2;i++){
		Future<?> future = executorService.submit(testLock1);
		System.out.println("is that the task completed "+future.isDone());
		System.out.println(future.get());
		System.out.println("Data from the future object ");
		System.out.println("is that the task completed "+future.isDone());
		System.out.println("is that the task cancelled "+future.isCancelled());
		System.out.println("---------------------------------------------------------");
	}
	
	
	
}
}

