package com.filecopty.test;
import java.io.*;
import java.util.*;
public class FileReadingFrmDir 
{
	public static void main(String[] args) throws Exception 
	{
		LinkedHashSet<String> al=new LinkedHashSet<String>();
		boolean b=true;
	    File f=new File("C:\\Users\\Appstek-15\\Test\\Demo\\apps");
        File[] f1=f.listFiles();
        while(b)
          {
              for(File f2:f1)
               {
            	  File temp=new File((f2.getAbsolutePath()));;
            	  if(f2.isDirectory())
                            {
    	                	    System.out.println(f2.getName());
    		                    System.out.println(f2.getAbsolutePath());
    		                    al.add(temp.getName());
                                f1=temp.listFiles();
                                if(f1!=null)
                                {
                                	for(File f3:f1)
                                	{
                                		if(f3.isDirectory())
                                		{
                                		System.out.println(f3.getName());
                                		System.out.println(f3.getAbsolutePath());
             		                    al.add(f3.getName());
                                		}
             		                    else if(f3.isFile())
             		                    {
             		                    System.out.println(f2.getName());
             		                    al.add(f3.getName());
            	    		            System.out.println();
             		                    }
            	    		            else
            	    		            {
            	    		            	al.add(f3.getName());	
            	    		            }	
                                	}
                                }
                                b=true;
                            }
    	                   else if(f2.isFile())
    	    	            {
    	    		            System.out.println(f2.getName());
    	    		            al.add(temp.getName());
    	    		            System.out.println();
    	    		            b=false;
    	    	            } 
    	                   else
    	                    {
    	                	   b=false;
    	                    }
             } 
     }
     System.out.println(al);
   }
}