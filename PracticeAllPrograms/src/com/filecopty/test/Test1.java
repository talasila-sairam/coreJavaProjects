package com.filecopty.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test1 
{
  public static void main(String[] args)throws Exception 
  {
	  int de= 2147483647;
	   int count=0;
    	  InputStream inStream = null;
	     OutputStream outStream = null;

	    try {

	        File afile = new File("C:\\files\\issues 5.30.17.docx");
	        File bfile = new File("E:\\files\\issues 5.30.17.docx");

	        inStream = new FileInputStream(afile);
	        outStream = new FileOutputStream(bfile);

	        byte[] buffer = new byte[2147483647];

	        int length;
	        //copy the file content in bytes 
	        while ((length = inStream.read(buffer)) > 0) {
	        	count++;
	            outStream.write(buffer, 0, length);
	        }
	        if(afile.length() == bfile.length())
	        {
	        System.out.println("source file length  "+afile.length());
			System.out.println("destination file length  "+bfile.length());
	        }
	        else 
	        {
	        	System.out.println("not inserted properly");
	        }
	        System.out.println("No of times while loop repeated with buffer 1024 is     "+count);
	        inStream.close();
	        outStream.close();

	        //delete the original file
	     //   afile.delete();

	        System.out.println("File is copied successful!");

	    } catch(IOException e) {
	        e.printStackTrace();
	    }

}
	
}
