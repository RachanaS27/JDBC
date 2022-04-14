package com.zensar.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main10 {

	public static void main(String[] args) {
	Connection con = DBConnection.create();
	
	String sql = "select * from products where price>=?";
	
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter price ");
	double price = scan.nextDouble();
	try{
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setDouble(1, price);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
			
		}
		rs.close();
		con.close();
	}catch(SQLException e){
		System.out.println(e.getMessage());
	}

	}

}
