package com.zensar.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection create() {
		// step 1
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded successfully");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		// step2

		String url = "jdbc:mysql://localhost:3306/trainingdb";
		String username = "root";
		String password = "root";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("connection obtained successfully");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return con;
	}
}
