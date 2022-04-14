package com.zensar.ui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main11 {

	public static void main(String[] args) {
	
		Connection connection = DBConnection.create();
		String sql = "select sum(price) from products";
		String sql2 = "select min(price) from products";
		String sql3 = "select max(price) from products";
		String sql4 = "select avg(price) from products";
		String sql5 = "select count(price) from products";

		try {
			Statement statment = connection.createStatement();
			Statement statment2 = connection.createStatement();
			Statement statment3 = connection.createStatement();
			Statement statment4 = connection.createStatement();
			Statement statment5 = connection.createStatement();

			System.out.println("sum ======================");
			ResultSet rs = statment.executeQuery(sql);
			rs.next();
			System.out.println(rs.getDouble(1));
			
			System.out.println("min ======================");
			rs =statment2.executeQuery(sql2);
			rs.next();
			System.out.println(rs.getDouble(1));
			
			System.out.println("max ======================");
			rs =statment3.executeQuery(sql3);
			rs.next();
			System.out.println(rs.getDouble(1));
			
			System.out.println("avg ======================");
			rs =statment4.executeQuery(sql4);
			rs.next();
			System.out.println(rs.getDouble(1));
			
			System.out.println("count ======================");
			rs =statment5.executeQuery(sql5);
			rs.next();
			System.out.println(rs.getInt(1));
			
			rs.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
