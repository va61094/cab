package com.accenture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class Connector {

	private static Connection connection = null;

	

	public static Connection createConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/vaibhav", "root", "root");
		return connection;
	}

	
	public static void closeConnection() throws SQLException {
		connection.close();
	}
}
