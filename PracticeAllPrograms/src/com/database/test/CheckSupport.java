package com.database.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckSupport {
public static void main(String[] args) throws Exception {
	Class.forName("oracle.jdbc.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
	DatabaseMetaData dmd= con.getMetaData();
	System.out.println("TYPE_FORWARD_ONLY ResultSet Supports  "+dmd.supportsResultSetType(1003));
	System.out.println("TYPE_SCROLL_INSENSITIVE ResultSet Supports  "+dmd.supportsResultSetType(1004));
	System.out.println("TYPE_SCROLL_SENSITIVE ResultSet Supports  "+dmd.supportsResultSetType(1005));
	System.out.println("CONCUR_READ_ONLY ResultSet Supports  "+dmd.supportsResultSetType(1007));
	System.out.println("CONCUR_UPDATABLE ResultSet Supports  "+dmd.supportsResultSetType(1008));
}
}
