package com.string.test;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenReverse 
{
	public static void main(String[] args) 
	{
		String s1="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any string");
		String s=sc.nextLine();
		StringTokenizer st=new StringTokenizer(s," ");
		int count=st.countTokens();
		String[] arr=new String[count];
	//	System.out.println(arr.length);
        
        	if(st.hasMoreTokens())//we can keep while also 
        	{
        		for(int i=0;i<count;i++)
                {
        		   arr[i]= st.nextToken();
        	    }
            }
		for(int j=count-1;j>=0;j--)
		{
		  //s1 = s1+arr[j]+" ";
			System.out.print((String)arr[j]+" ");
		}
		System.out.print(s1);
		sc.close();
	}
	

}
