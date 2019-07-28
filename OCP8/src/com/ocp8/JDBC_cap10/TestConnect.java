package com.ocp8.JDBC_cap10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnect {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
		System.out.println( conn);

	}

}
