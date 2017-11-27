package com.executorframework.beans;

import java.security.GeneralSecurityException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class CompletionExecutorBean implements  Runnable
{
	private String name;
	public CompletionExecutorBean(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		 try {
			 //System.out.println("current Thread Name "+Thread.currentThread().getName());
			 if(Thread.currentThread().getName().equals("pool-1-thread-1")){
				 System.out.println("Thread 0 is Entered");
				 Thread.sleep(9000);
				 System.out.println(getName()+"---> Thread is Trreminated");				
			 }else if(Thread.currentThread().getName().equals("pool-1-thread-2")){
				 System.out.println("Thread 1 is Entered");
				 Thread.sleep(6000);
				 System.out.println(getName()+"---> Thread is Trreminated");
			 }else if(Thread.currentThread().getName().equals("pool-1-thread-3")){
				 System.out.println("Thread 2 is Entered");
				 Thread.sleep(8000);
				 System.out.println(getName()+"---> Thread is Trreminated");
			 }else{
				 System.out.println("Thread 3 is Entered");
				 Thread.sleep(7000);
				 System.out.println(getName()+"---> Thread is Trreminated");
			 }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
