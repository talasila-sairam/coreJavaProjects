package com.executorframework.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CopletionExecutorTest {
   public static void main(String[] args) throws ExecutionException, InterruptedException {
	ExecutorService executor = Executors.newFixedThreadPool(4);
	List<Future> listFuture = new ArrayList<Future>();
	for(int i=0;i<4;i++){
		Future future = executor.submit(new CompletionExecutorBean("Thread "+i));
		listFuture.add(future);
	}
	for(Future future :listFuture){
		System.out.println("Entered into ForEach loop");
		//If you go for ExecutorService or Executor and try to acessing the get method it will stop
		//further processing untill you get the out put from the future object
		System.out.println("Results from Future Object is "+future.get());
		System.out.println("isDone or Not  "+future.isDone());
	}
	
	/*
	//Same Example we will try with The CompletionService(I) and ExcecutorCompletionService 
	//and it will me more use full when compared with executor or executor service 
	//it will maintain some blocking queue internally
	CompletionService completionService  = new ExecutorCompletionService(executor);
	for(int i=0;i<4;i++){
		Future future = completionService.submit(new CompletionExecutorBean("Thread "+i),"");
		listFuture.add(future);
	}
	for(int i =0;i<4;i++){
		System.out.println("inside for loop for future object");
		//Future future = completionService.take();
		System.out.println("Future class get Method is "+completionService.take().get());
		//System.out.println("is Done or not "+future.isDone());
	}*/
}
}
