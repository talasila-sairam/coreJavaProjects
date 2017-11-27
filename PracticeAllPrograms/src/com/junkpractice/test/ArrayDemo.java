package com.junkpractice.test;
public class ArrayDemo 
{
 public static void main(String[] args) 
 {
  int a[]={5,10,20,30,20,25,30,20,10,5,10,70,25,25,30,5,4,30};
  for(int i=0;i<a.length;i++)
  {
	  int count=0;
	  int temp=0;
	  for(int k=i;k>=0;k--)
	  {
		  if(a[i]==a[k])
		  {
			  temp++;
		  }
	  }
	  
	  for(int j=i;j<a.length;j++)
	  {
		  if(temp>1)
		  {
			  break;
		  }
		  else if(a[i]==a[j])
		  {
			  count++;
		  }
	  }
	  if(temp>1){}
	  else
	  {System.out.println(a[i]+" frequency is  "+count);}
  }
}
}
