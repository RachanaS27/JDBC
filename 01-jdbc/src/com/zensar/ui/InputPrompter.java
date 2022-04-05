package com.zensar.ui;

import java.util.Scanner;

public class InputPrompter {

	public static String promptInputForString(String label){
		System.out.printf("%-40s",label);
		Scanner scan = new Scanner(System.in);
		String text = scan.next();
		scan.close();
		return text;
	}
	public static char promptInputForChar(String label){
		System.out.printf("%-40s",label);
		Scanner scan = new Scanner(System.in);
		String text = scan.next();
		scan.close();
		return text.charAt(0);
	}
	
	public static int promptInputForInt(String label){
		System.out.printf("%-40s",label);
		Scanner scan = new Scanner(System.in);
		String text = scan.next();
		scan.close();
		return Integer.parseInt(text);
	}
	public static double promptInputForDouble(String label){
		System.out.printf("%-40s",label);
		Scanner scan = new Scanner(System.in);
		String text = scan.next();
		scan.close();
		return Double.parseDouble(text);
	}
}