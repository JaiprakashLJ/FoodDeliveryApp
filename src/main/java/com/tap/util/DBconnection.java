package com.tap.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	private static final String url = "jdbc:mysql://localhost:3306/foodapp";
	private static final String username = "root";
	private static final String password = "root";
	private static  Connection connection;
	
	public static Connection getDBConnection(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(url,username,password);
			
			return connection;
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return connection;
		
		
		
		 
	}

}
