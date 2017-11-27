package com.regularexp.test;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFindRegExp 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a Requrired String");
		String s=sc.nextLine();
		//Pattern p=Pattern.compile("[a-z A-Z]+");
		//Pattern p=Pattern.compile("[a-z A-Z 0-9]+");
		Pattern p=Pattern.compile("\\.");
		Matcher m=p.matcher(s);
        while(m.find())
        {
        	System.out.print(m.group());
        }
        sc.close();
	}

}
