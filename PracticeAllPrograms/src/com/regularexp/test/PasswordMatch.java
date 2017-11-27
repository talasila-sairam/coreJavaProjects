package com.regularexp.test;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordMatch 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your password. It should contain alphabets and digits only");
		String pass=sc.nextLine();
		try
		{
		            Pattern p=Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6})");
		            Matcher m=p.matcher(pass);
		            if(pass.length()==6)
		            {
		               if(m.find() && m.group().equals(pass))
		                 {
		                   System.out.print("your entered password is valid  :"+m.group());	
		                 }
		                else
		                 {
		            	   System.out.println("your entered password is invalid  :"+pass);
		                 }
		            }
		            else
		            {
		            	System.out.println("password should contain 6 digits only");
		            }
		}
		catch(Exception e)
		{
		  System.out.println("An Exception occured :");	
		}
		finally 
		{
			sc.close();	
		}
	}
}
