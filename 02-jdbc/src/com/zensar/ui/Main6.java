package com.zensar.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main6 {

	public static void main(String[] args) {
		Connection connection = DBConnection.create();
		String sql = "insert into products values(?,?,?)";
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter id of product ");
		int id = scan.nextInt();
		
		System.out.println("Enter product name ");
		String name = scan.next();
		
		System.out.println("Enter product price ");
		double price = scan.nextDouble();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setDouble(3, price);
			
			int result = preparedStatement.executeUpdate();
			System.out.println(result);
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
