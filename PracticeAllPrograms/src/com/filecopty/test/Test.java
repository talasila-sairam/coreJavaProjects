package com.filecopty.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.PrintWriter;

public class Test 
{
public static void main(String[] args)throws Exception
  {
	BufferedReader br=null;
	File file=null;
	PrintWriter pw=null;
    try {
    	File file1=new File("C:\\files\\myhtml.html");
		br=new BufferedReader(new FileReader(file1));
		file=new File("E:\\files\\myhtml1.html");
		
		System.out.println(file.getName());
		pw=new PrintWriter(file);
		String s=br.readLine();
		while(s != null)
		{
		pw.write(s);
		s=br.readLine();
		}
		pw.flush();
		if(file.exists())
		{
				System.out.println("source file length  "+file1.length());
				System.out.println("destination file length  "+file.length());
			
		}
		System.out.println("loaded susscessfully");
	} catch (Exception e) {
		// TODO: handle exception
	}
    finally {
    br.close();
    	pw.close();
	}
  }
}
