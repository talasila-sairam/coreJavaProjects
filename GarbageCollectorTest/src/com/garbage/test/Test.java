package com.garbage.test;

public class Test {
	int i;
  public Test(int i){
	  this.i=i;
  }
  @Override
protected void finalize() throws Throwable {
	// TODO Auto-generated method stub
	super.finalize();
	System.out.println("finalize method called");
}
}
