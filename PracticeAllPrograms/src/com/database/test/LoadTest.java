package com.database.test;

public class LoadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
LoadData data=new LoadData();

Employee emp1=data.load();
System.out.println(emp1.getEno());
System.out.println(emp1.getEname());
System.out.println(emp1.getEadd());
	}

}
