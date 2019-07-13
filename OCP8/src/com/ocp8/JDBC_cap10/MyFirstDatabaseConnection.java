package com.ocp8.JDBC_cap10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyFirstDatabaseConnection {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		String url ="jdbc:derby:zoo";
		
		try (				
				Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select name from animal")){
				while(rs.next())
					System.out.println(rs.getString(1));
		}
	}

}
