package com.ocp8.JDBC_cap10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//This is only illustrative,this wont run unless you have 
//postgresql database "ocp-book" running on 5432 port
public class TestExternal {
	
	public static void main( String[] args) throws SQLException	{ 
		Connection conn = DriverManager.getConnection(
				"jdbc:postgresql:// localhost: 5432/ ocp-book", 
				"username", "password"); 
		System.out.println( conn); }

	

}
