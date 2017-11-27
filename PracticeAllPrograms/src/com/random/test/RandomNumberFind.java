package com.random.test;
import java.util.Random;

public class RandomNumberFind 
{
	public static void main(String[] args) 
	{
		Random r=new Random();
		for(int i=0;i<=10;i++)
		{
		System.out.print(r.nextInt(10)+" ");
		}
	}

}
