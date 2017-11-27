package com.apps.thread;

import java.lang.reflect.Method;

import com.apps.thread.Test2;

public class CustomClassLoaderMain {
public static void main(String[] args) throws Exception{
	System.out.println("--------------Test2 class is loading------------");
	System.out.println("------------------------------------------------......");
	Test2 t=new Test2();
	t.run();
	System.out.println("Test2 class is loaded");
	System.out.println("--------------------------------------------------.....");
	CustomClassLoader ccl= new CustomClassLoader("Hi");
	
	Class<?> c = ccl.findClass("com.apps.thread.Test2");
    Object ob = c.newInstance();
    Method md = c.getMethod("run");
    md.invoke(ob);
    System.out.println("--------------------");
    ClassLoader cl = CustomClassLoaderMain.class.getClassLoader();
    System.out.println(cl);
    System.out.println("-------------------");
    Class clazz = Class.forName("com.apps.thread.Test2",true,cl);
    System.out.println("before instance");
    Test2 obj = (Test2)clazz.newInstance();
    obj.run();
   // Class<?> c1 = ccl.findClass("com.apps.thread.Test2");
    System.out.println("---------------------------------------------------------------");
    System.out.println("Context class loader is  "+Thread.currentThread().getContextClassLoader());
    }
}
