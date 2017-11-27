package com.database.test;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;   
public class RowSetDemo
{
        public static void main(String[] args) throws Exception 
        {   
	         Class.forName("com.mysql.jdbc.Driver");   
	        JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();   
	        rowSet.setUrl("jdbc:mysql://localhost:3306/sai");   
	        rowSet.setUsername("root");   
	        rowSet.setPassword("root");                  
	        rowSet.setCommand("select * from Employee");   
	        rowSet.execute();   
           //Adding Listener and moving RowSet   
	       rowSet.addRowSetListener((RowSetListener) new MyListener());   
	                 while (rowSet.next()) 
	                 {   
	               // Generating cursor Moved event   
	                  System.out.println("Id: " + rowSet.getString(1));   
                     System.out.println("Name: " + rowSet.getString(2));   
                     System.out.println("Salary: " + rowSet.getString(3));   
	                }   
	                  
	        }   
}   