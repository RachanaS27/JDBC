package com.zensar.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main7 {

	public static void main(String[] args) {
	Connection connection = DBConnection.create();
	
	String sql = "update products set productName=?,price=? where id=?";
	
	Scanner scan = new Scanner(System.in);

	System.out.println("Enter product name ");
	String name = scan.next();
	
	System.out.println("Enter product price ");
	double price = scan.nextDouble();
	
	System.out.println("Enter id of product ");
	int id = scan.nextInt();
	
	try {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setDouble(2, price);
		preparedStatement.setInt(3, id);
		int result= preparedStatement.executeUpdate();
		System.out.println(result);
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();

	}

	}

}
