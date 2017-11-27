package com.apps.thread;

public class Test2 {
	public static int str=m1();
	public static int m1(){
		System.out.println("this is inside m1()");
		return 100;
	}
	public Test2(){
		
		System.out.println("inside constructor");
	}
	static{
		System.out.println("static block inside Test2 class");
	}
public void run()
{
	System.out.println("this is second test class");
System.out.println("Test2.class is loaded by  "+this.getClass().getClassLoader());
System.out.println("Test2.class is loaded classloader parent  "+this.getClass().getClassLoader().getParent());
}
}
