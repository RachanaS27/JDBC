package com.zensar.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.zensar.bean.Gender;

public class InputPrompter {
	

	public static String promptInputForString(String label){
		System.out.printf("\t %-40s",label);
		Scanner scan = new Scanner(System.in);
		String text = scan.next();
		//scan.close();
		return text;
	}
	public static char promptInputForChar(String label){
		System.out.printf("\t %-40s",label);
		Scanner scan = new Scanner(System.in);
		String text = scan.next();
		//scan.close();
		return text.charAt(0);
	}
	
	public static int promptInputForInt(String label){
		System.out.printf("\t %-40s",label);
		Scanner scan = new Scanner(System.in);
		String text = scan.next();
		//scan.close();
		return Integer.parseInt(text);
	}
	public static double promptInputForDouble(String label){
		System.out.printf("\t %-40s",label);
		Scanner scan = new Scanner(System.in);
		String text = scan.next();
		//scan.close();
		return Double.parseDouble(text);
	}
	
	public static LocalDate promptInputForDate(String message,String format){
		System.out.printf("\t %-40s",message+" "+format);
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		LocalDate localDate = LocalDate.parse(str, DateTimeFormatter.ofPattern(format));
		//scan.close();
		return localDate;
	}
	
	public static Gender promptInputForGender(String message){
		int input = promptInputForInt(message);
		if(input==1){
			return Gender.MALE;
		}
		return Gender.FEMALE;
	}
}
