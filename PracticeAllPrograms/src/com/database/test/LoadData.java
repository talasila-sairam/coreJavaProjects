package com.database.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadData {

	private static final String load="select * from employee";
	public Employee load(){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Employee emp=null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sai","root","root");
		if(con!=null)
			ps=con.prepareStatement(load);
		if(ps!=null)
			rs=ps.executeQuery();
		if(rs!=null)
			 emp=new Employee();
			while(rs.next()){
				emp.setEno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setEadd(rs.getString(3));
			}
}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
		try{
			if(con!=null){
				con.close();
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		try{
			if(ps!=null){
				ps.close();
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		try{
			if(rs!=null){
				rs.close();
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		return emp;
	}
}
