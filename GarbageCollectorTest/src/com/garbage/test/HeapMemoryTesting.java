package com.garbage.test;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryType;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.List;

import javassist.CannotCompileException;
import javassist.ClassPool;
/**
 * These are the commands to increase or decrease the memory of Heap and Metaspace
 * 
 * -Xms5M ------------------------------------>To Set Minimum Heap Size
 * -Xmx6M------------------------------------->To Set Maximum Heap Size
 * -Xmn500K----------------------------------->To Set Maximum Value For YoungGenration Or EdenSpace Or (Young+Survior Space) 
 * -XX:MaxMetaspaceSize=6M ------------------->To Set Minimum MetaSpace(PermGen Space)Size
 * -XX:MetaspaceSize=5M ---------------------->To Set Maximum MetaSpace (PermGen Space)Size  
 * -XX:ReservedCodeCacheSize=6m -------------->To Increase the CodeCache Size
 * -XX:InitialCodeCacheSize=5M --------------->To Set Minimum CodeCache Size
 * -XX:+PrintCommandLineFlags ---------------->To Print all Command Values in console
 * -XX:+UseConcMarkSweepGC ------------------->Promting to use CMS Algorithm in GC
 * -XX:+PrintGCDetails ----------------------->It will Print All Garbage Collector Details
 * 
 * 
 * Provide these in RunConfigurations as arguments
 * -Xms5M -Xmn500K -Xmx6M -XX:MaxMetaspaceSize=6M -XX:MetaspaceSize=5M 
 * -XX:ReservedCodeCacheSize=6M -XX:InitialCodeCacheSize=5M -XX:+PrintCommandLineFlags
 * -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails
 * 
 * 
 * Mathemetical Calculations
 * if SurvivorRatio=6
   then S / E = 1/6
   E = 6S
   2S + E = Y
   2S + 6S = Y
   S = Y / 8
 */
public class HeapMemoryTesting {
	static ClassPool classPool = ClassPool.getDefault();
   public static void main(String[] args) throws CannotCompileException, RuntimeException {
	Runtime runtime = Runtime.getRuntime();
	System.out.println("free memory   "+runtime.freeMemory()/(1024*1024)+" MB");
	System.out.println("total memory   "+runtime.totalMemory()/(1024*1024)+" MB");
	System.out.println("max memory   "+runtime.maxMemory()/(1024*1024)+" MB");
	
	List mpoolArr = ManagementFactory.getMemoryPoolMXBeans();
	Iterator itr = mpoolArr.iterator();
    while(itr.hasNext()){
    	MemoryPoolMXBean mpool =(MemoryPoolMXBean) itr.next();
    	System.out.println(mpool.getType()+"     "+mpool.getUsage());
    }
    System.out.println("================================================================================================");
    //For HEAP Memory
	for (MemoryPoolMXBean mpBean: ManagementFactory.getMemoryPoolMXBeans()) {
	    if (mpBean.getType() == MemoryType.HEAP) {
	        System.out.printf(
	            "Name: %s: %s\n",
	            mpBean.getName(), mpBean.getUsage()
	        );
	    }
	}
	 System.out.println("=========================================================================================");
	//For NON-HEAP Memory
	for (MemoryPoolMXBean mpBean: ManagementFactory.getMemoryPoolMXBeans()) {
	    if (mpBean.getType() == MemoryType.NON_HEAP) {
	        System.out.printf(
	            "Name: %s: %s\n",
	            mpBean.getName(), mpBean.getUsage()
	        );
	    }
	}
	
	/*Creating More Number of Objects and Try to get java.lang.OutOfMemoryError: Java heap space
	 * java.lang.OutOfMemoryError: GC overhead limit exceeded
	for(int i=0;i<100000;i++){
		Test t =new Test(i);
	}*/
	
	
	//Loading Class ByteCode into Memory
	  for (int i = 0; i < 1000000000; i++) {
		  
		  Test t = new Test(i);
          Class c = classPool.makeClass("com.saket.demo.Permgen" + i).toClass();
          System.out.println(c.getName());
      }
}
}
