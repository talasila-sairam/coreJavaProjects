package com.filecopty.test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class LookupDemo {

	public static void main(String[] args) throws IOException 
	{
		ArrayList<String> al=new ArrayList<String>();
	 BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\T05053\\Desktop\\demo.txt"));
	 PrintWriter pw=new PrintWriter("C:\\Users\\T05053\\Desktop\\demo.txt");
	 String line=br.readLine();
	 while(br!=null)
	 {
		 al.add(line);
		 line=br.readLine();
	 }
	 Collections.sort(al);
     for(String al1:al)
     {
    	 
     }
	}

}
