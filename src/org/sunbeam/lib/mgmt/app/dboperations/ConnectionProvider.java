package org.sunbeam.lib.mgmt.app.dboperations;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This is singleton implementation for getting connection obj.
 */
public class ConnectionProvider {

	private static Connection connection;
	
	private ConnectionProvider() throws Exception {
		String connStr = "jdbc:mysql://localhost:3306/library";
		String user = "root";
		String password = "root";
		
		System.out.println("Connecting to " + connStr);
		Class.forName("com.mysql.cj.jdbc.Driver");  
		connection =DriverManager.getConnection(connStr,user,password);  
	}
	
	public static Connection getConnection() throws Exception {
		if(connection != null) {
			return connection;
		} else {
			System.out.println("Connection is not available so creating new one!!");
			new ConnectionProvider();
			return connection;
		}
	}
	
	
}
