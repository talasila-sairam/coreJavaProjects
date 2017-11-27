package com.filecopty.test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyFileIntoAnother 
{
	public static void main(String[] args) throws IOException 
	{
		File file = new File("C:\\Users\\Appstek-15\\Test\\Demo\\Delete.txt");
		BufferedReader br=new BufferedReader(new FileReader(file));
		PrintWriter pw=new PrintWriter("Data.txt");
		String line=br.readLine();
		while(line!=null)
		{
		 pw.println(line);
		 pw.flush();
		 line=br.readLine();
		}
		br.close();
		pw.close();
		try{	
    		if(file.delete())
    		{
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
    	   
    	}catch(Exception e){
    		
    		e.printStackTrace();
    	}  		
	}
}
