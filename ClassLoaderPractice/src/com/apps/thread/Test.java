package com.apps.thread;

public class Test {
static
{
System.out.println("hello");	
}
public void show(){
	System.out.println("this is test class");
	System.out.println("Test.class is loaded by "+this.getClass().getClassLoader());
}
}
