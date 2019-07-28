package com.ocp8.JDBC_cap10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestStatement {
			
	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
	
		Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
		Statement stmt = conn.createStatement();
		
		new TestStatement().testStatement(stmt);

	}
	
	public void testStatement(Statement stmt) throws SQLException{
											
		int result = stmt.executeUpdate( 
				"insert into species values( 10, 'Deer', 3)"); 
		System.out.println(result);// 1 
		result = stmt.executeUpdate( 
				"update species set name = '' where name = 'None'"); 
		System.out.println( result); // 0 
		result = stmt.executeUpdate( 
				" delete from species where id = 10"); 
		System.out.println( result);// 1
	}
	
	public void testExecute(Statement stmt) throws SQLException{
		String sql = "";
		boolean isResultSet = stmt.execute(sql);
		
		if (isResultSet) { 
			ResultSet rs = stmt.getResultSet(); 
			System.out.println(" ran a query"); 
		} else { 
			int result = stmt.getUpdateCount(); 
			System.out.println(" ran an update"); 
		}
	}
	
	public void scaryDelete(Connection conn) throws SQLException{
		//Add an animal
		
		//Delete animal using Prepared statement
		PreparedStatement ps = conn.prepareStatement("delete from animal where name = ?");
		ps.setString( 1, name); 
		ps.execute();

		
	}
	
//	public void readingResulset(Statement stmt) throws SQLException{
	Map < Integer, String > idToNameMap = new HashMap < >(); 21: ResultSet rs = stmt.executeQuery(" select id, name from species"); 22: while( rs.next()) { 23: int id = rs.getInt(" id"); 24: String name = rs.getString(" name"); 25: idToNameMap.put( id, name); 26: } 27: System.out.println( idToNameMap); // {1 = African Elephant, 2 = Zebra}

	
//	}
//	
//	public void scaryDelete(Statement stmt) throws SQLException{
//	
	Map < Integer, String > idToNameMap = new HashMap < >(); 21: ResultSet rs = stmt.executeQuery(" select id, name from species"); 22: while( rs.next()) { 23: int id = rs.getInt( 1); 24: String name = rs.getString( 2); 25: idToNameMap.put( id, name); 26: } 27: System.out.println( idToNameMap); // {1 = African Elephant, 2 = Zebra}

	
//	}
	
//	public void scaryDelete(Statement stmt) throws SQLException{
//	
	ResultSet rs = stmt.executeQuery(" select count(*) from animal"); 
	if( rs.next())
		System.out.println( rs.getInt( 1));		
		System.out.println( rs.getInt(" count"));
		
		ResultSet rs = stmt.executeQuery( "select * from animal where name = 'Not in table'"); rs.next(); rs.getInt( 1); // throws SQLException

		ResultSet rs = stmt.executeQuery(" select count(*) from animal"); rs.getInt( 1); // throws SQLException

		ResultSet rs = stmt.executeQuery(" select count(*) from animal"); rs.next(); rs.getInt( 0); // throws SQLException

		ResultSet rs = stmt.executeQuery(" select id from animal"); rs.next(); rs.getInt(" badColumn"); // throws SQLException

		
		
//}
	
//	public void scaryDelete(Statement stmt) throws SQLException{
//	
		ResultSet rs = stmt.executeQuery(" select id from animal"); rs.next(); rs.getInt(" badColumn"); // throws SQLException

		ResultSet rs = stmt.executeQuery(" select date_born from animal where name = 'Elsa'"); if (rs.next()) { java.sql.Time sqlTime = rs.getTime( 1); LocalTime localTime = sqlTime.toLocalTime(); System.out.println( localTime); // 02: 15 }

		ResultSet rs = stmt.executeQuery(" select date_born from animal where name = 'Elsa'"); if (rs.next()) { java.sql.Timestamp sqlTimeStamp = rs.getTimestamp( 1); LocalDateTime localDateTime =

				sqlTimeStamp.toLocalDateTime(); System.out.println( localDateTime); // 2001— 05— 06T02: 15 }

				ResultSet rs = stmt.executeQuery(" select id, name from species"); 17: while( rs.next()) { 18: Object idField = rs.getObject(" id"); 19: Object nameField = rs.getObject(" name"); 20: if (idField instanceof Integer) {

					int id = (Integer) idField; 22: System.out.println( id); 23:} 24: if (nameField instanceof String) { 25: String name = (String) nameField; 26: System.out.println( name); 27: } 28:}

				
//}
	
//	public void scrolling(Statement stmt) throws SQLException{
//	
				Statement stmt = conn.createStatement( 11: ResultSet.TYPE_SCROLL_INSENSITIVE, 12: ResultSet.CONCUR_READ_ONLY); 13: ResultSet rs = stmt.executeQuery(" select id from species order by id");

				rs.afterLast(); 15: System.out.println( rs.previous());// true 16: System.out.println( rs.getInt( 1)); // 2 17: System.out.println( rs.previous());// true 18: System.out.println( rs.getInt( 1)); // 1 19: System.out.println( rs.last());// true 20: System.out.println( rs.getInt( 1)); // 2 21: System.out.println( rs.first()); // true 22: System.out.println( rs.getInt( 1)); // 1 23: rs.beforeFirst(); 24: System.out.println( rs.getInt( 1)); // throws SQLException

								
//}
	
//	public void scaryDelete(Statement stmt) throws SQLException{
//	
				Statement stmt = conn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); ResultSet rs = stmt.executeQuery(" select id from species where id = -99"); System.out.println( rs.first());// false System.out.println( rs.last()); // false

								
//}
	

	public void absolute(Connection conn) throws SQLException{
	
		Statement stmt = conn.createStatement( 
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_READ_ONLY); 
		ResultSet rs = stmt.executeQuery(" select id from animal order by id"); 
		System.out.println( rs.absolute( 2));// true 
		System.out.println( rs.getString(" id"));// 2 
		System.out.println( rs.absolute( 0));// false 
		System.out.println( rs.absolute( 5));// true 
		System.out.println( rs.getString(" id"));// 5
		System.out.println( rs.absolute(-2)); // true 
		System.out.println( rs.getString(" id"));// 4
							
	}
	
	public void relative(Connection conn) throws SQLException{
	
		Statement stmt = conn.createStatement( 
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_READ_ONLY); 
		ResultSet rs = stmt.executeQuery(
				"select id from animal order by id"); 
		System.out.println( rs.next());// true 
		System.out.println( rs.getString(" id")); // 1 
		System.out.println( rs.relative( 2)); // true 
		System.out.println( rs.getString(" id")); // 3 
		System.out.println( rs.relative(-1));// true
		System.out.println( rs.getString(" id")); // 2 
		System.out.println( rs.relative( 4)); // false
								
}
	
	public void exceptions() throws SQLException{

		String url = " jdbc:derby:zoo"; 
		try (	Connection conn = DriverManager.getConnection(url); 
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery("select not_a_column from animal")) 
				{
					while (rs.next()) 
						System.out.println(rs.getString(1)); 
				} catch (SQLException e) { 
					System.out.println( e.getMessage()); 
					System.out.println( e.getSQLState()); 
					System.out.println( e.getErrorCode()); 
					}
	}
		

}
