package com.junkpractice.test;

public class B extends A  {
public int m1()
{
	System.out.println("m1-B");
	//A a=new A();
	//int j=(int)a.m1();
	int j=super.m1();
return j;	
}
}
