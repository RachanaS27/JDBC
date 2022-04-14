package com.zensar.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main8 {

	public static void main(String[] args) {
		Connection connection = DBConnection.create();
		
		String sql = "delete from products where id = ?";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the id");
		int id = scan.nextInt();
		
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int result = preparedStatement.executeUpdate();
			System.out.println(result);
			connection.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		
	}

}
