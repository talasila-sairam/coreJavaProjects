package com.apps.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


public class TestThread {
	public static void main(String[] args) {
		ThreadCreation tt=new ThreadCreation();
		  FutureTask futureTask = new FutureTask(tt);
		  Future futureOnly =new FutureTask(tt);
		  
		  futureTask.run();
		  System.out.println("hi");
		  ExecutorService executorService = Executors.newFixedThreadPool(5);
		  System.out.println(executorService.getClass().getName());
		  for(int i=0;i<5;i++){
			  Future future = executorService.submit(tt);
			  System.out.println(Thread.currentThread().getPriority());
			  System.out.println("is Cancelled  "+future.isCancelled()+"  is Completed  "+future.isDone());
		  }
		  try {
		   System.out.println(futureTask.get());
		   System.out.println("main thread will be finished by last");
		  } catch (Exception e) {
		  }
	}

	}
