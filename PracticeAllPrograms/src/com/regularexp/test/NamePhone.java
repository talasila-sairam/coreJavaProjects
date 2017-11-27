package com.regularexp.test;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NamePhone 
{
	public static void main(String[] args) 
	{
		boolean b1 = false;
		boolean b2 = false;
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter valid user name:");
		String name = inp.nextLine();
		System.out.println("Enter your phone no: ");
		String phone = inp.nextLine();
		b1=Pattern.matches("(0|91)?[789][0-9]{9}",phone);
		b2=Pattern.matches("[rsRS][a-z A-Z]+",name);
		if(b1 == true)
		{
			System.out.print("phone is valid    :"+phone);
		}
		else
		{
			System.out.println("phone is invalid     :"+phone);
		}
		System.out.println();
		if(b2==true)
		{
			System.out.print("name valid      :"+name);
		}
		else
		{
			System.out.println("provided name is invalid   :"+name);
		}
		/*
		Pattern p = Pattern.compile("(0|91|[rsSR])?(7|8|9|[a-z A-Z]+)[0-9]{9}");
		Matcher m1=p.matcher(phone);
		Matcher m2=p.matcher(name);
		
					while(m1.find())
					{	
					System.out.print(m1.group());
					}
					System.out.println();
					while(m2.find())
					{
					System.out.print(m2.group());
					}*/
		}
}