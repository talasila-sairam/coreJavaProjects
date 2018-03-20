package com.apps.interfaces;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class HashMapPractice {
   public static void main(String[] args) {
	System.out.println("main method");
	// Map map = new HashMap();  -->java.util.HashMap$Node
	Map map = new Hashtable<String ,String>(); //java.util.Hashtable$Entry
	map.put("ji", "hello");
    Set<Map.Entry> entrySet = map.entrySet();
    for(Map.Entry entry : entrySet) {
    	System.out.println(entry.getClass().getName());
    }
	/*Map.Entry<String, String> map =  new AbstractMap.SimpleEntry("hi" ,"hello");
	System.out.println(map.getClass().getName());*/
}
}
