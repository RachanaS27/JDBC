package com.zensar.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	public static Connection create() {
		String url = "jdbc:mysql://localhost:3306/trainingdb";
		String user = "root";
		String pass = "root";
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("connection obtained");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return connection;
	}

	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}