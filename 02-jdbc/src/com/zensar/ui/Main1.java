package com.zensar.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {

	public static void main(String[] args) {
		// step 1
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded successfully");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
		//step2

		String url = "jdbc:mysql://localhost:3306/trainingdb";
		String username = "root";
		String password = "root";
		Connection con = null;
		try {
			 con = DriverManager.getConnection(url, username,
					password);
			System.out.println("connection obtained successfully");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		//step 3
		
		Statement statement = null;
		try {
			statement = con.createStatement();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		//step 4
		
		String sql = "insert into Products values(104,'Mobile',32000.00)";
		
		//step 5
		
		int result;
		try {
			result = statement.executeUpdate(sql);
			System.out.println(result+" Record added successfully");
			//step 6
			con.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
}
