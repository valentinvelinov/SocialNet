package com.socialNet.dbmanager;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private Connection connection;
	private static DBConnection theChosenOneDBConnection;
	
	private static final String DB_HOSTNAME = "localhost";
	private static final String DB_PORT = "3306";
	private static final String DATABASE = "socialnet-db";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	private DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = 
					DriverManager.getConnection("jdbc:mysql://" + 
							DB_HOSTNAME + ":" + 
							DB_PORT + "/" + DATABASE, 
							DB_USER, DB_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static DBConnection getInstance() {
		if (theChosenOneDBConnection == null) {
			theChosenOneDBConnection = new DBConnection();
		}
		return theChosenOneDBConnection;
	}

	public Connection getConnection() {
		return connection;
	}
}
