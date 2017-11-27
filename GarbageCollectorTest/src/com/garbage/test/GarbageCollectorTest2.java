package com.garbage.test;

import javassist.CannotCompileException;
import javassist.ClassPool;

public class GarbageCollectorTest2 {
	static ClassPool classPool = ClassPool.getDefault();
  public static void main(String[] args) throws CannotCompileException, RuntimeException {
	  for (int i = 0; i < 1000000000; i++) {
          Class c = classPool.makeClass("com.saket.demo.Permgen" + i).toClass();
          System.out.println(c.getName());
      }
}
}
