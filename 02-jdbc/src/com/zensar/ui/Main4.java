package com.zensar.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main4 {

	public static void main(String[] args) {
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
		// step 3

		Statement statement = null;
		try {
			statement = con.createStatement();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		// step 4

		String sql = "select * from products where id = 102";

		// step 5

		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);

			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t" + rs.getString(2) + "\t"
						+ rs.getDouble(3));
				System.out.println();
			}
			con.close();
			System.out.println(" Record dispalyed successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
