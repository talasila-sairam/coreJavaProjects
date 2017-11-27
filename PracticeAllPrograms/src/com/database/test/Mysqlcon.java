package com.database.test;
import java.sql.*;
public class Mysqlcon 
{
	public static void main(String[] args) throws SQLException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
	 	    Connection con=DriverManager.getConnection(  
		 	"jdbc:mysql://localhost:3306/sai","root","root");  
			 Statement stmt=con.createStatement();  
			 ResultSet rs=stmt.executeQuery("select * from student");  
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));	
			}
			int i=stmt.executeUpdate("update student set id=300 where id=100");
			System.out.println(i);
			con.close();
		}
		       catch(Exception e)
		        { 
				System.out.println(e);
				} 
	}
}
