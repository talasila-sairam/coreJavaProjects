package com.filecopty.test;
import java.io.*;
import java.util.Scanner;
public class CsvFile
{
	public static void main(String[] args) throws IOException 
	{
      File f=new File("csv.csv");
      BufferedWriter br=new BufferedWriter(new FileWriter(f,true));
      Scanner sc=new Scanner(System.in);
      System.out.println("Press end to terminate");
      System.out.println("plz enter the values into file");
      String str1=sc.nextLine();
      while(!str1.equalsIgnoreCase("end"))
      {
      br.write(str1+",");
      System.out.println("plz enter the values into file");
      str1=sc.nextLine();
      }
      System.out.println("Your Data enterde into File.......");
      br.close();
	}
}
