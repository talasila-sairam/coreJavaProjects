package com.junkpractice.test;
public class C  {
public int m1(){
	return new B().m1();
}
public static void main(String[] args) {
	C b=new C();
	System.out.println(b.m1());
}
}
