package com.string.test;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
public class StringLengthCompatator 
{
  public static void main(String[] args) throws IOException
  {
	  File f=new File("C:\\Users\\Appstek-15\\Test\\Demo\\file1.txt");
	  BufferedReader br=new BufferedReader(new FileReader(f));
	  BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\Appstek-15\\Test\\Demo\\file2.txt",true));
	  String str1=br.readLine();
	  ArrayList<String> al=new ArrayList<String>();
	  while(str1!=null)
	  {
		  al.add(str1);
	  }
	  Collections.sort(al);
	  System.out.println(al);
	  for(int i=0;i<al.size();i++)
	  {
		  bw.write(al.get(i));
	  }
	  br.close();
	  bw.close();
  }
}
