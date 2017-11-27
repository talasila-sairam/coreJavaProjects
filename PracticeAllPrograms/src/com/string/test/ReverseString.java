package com.string.test;

import java.util.StringTokenizer;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
StringTokenizer string=null;
StringBuffer buffer=null;

string=new StringTokenizer("rajinikantha pradhan appstek solutions");
buffer=new StringBuffer();

if(string.hasMoreTokens()){	
	String s1=string.nextToken();
buffer.append(string.nextToken());
buffer.append(s1+" ");
	}
System.out.println(buffer);
	}
}
