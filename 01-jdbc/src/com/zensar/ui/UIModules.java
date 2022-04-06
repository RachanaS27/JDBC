package com.zensar.ui;

import java.time.LocalDate;

import com.zensar.bean.Employee;
import com.zensar.bean.Gender;

public class UIModules {

	public void addInfo() {
		System.out.println("\t\t Add New Employee \n");
		System.out.println("\t\t ----------------------");
		
		String name = InputPrompter.promptInputForString("\t\t Enter Name ");
		double basicSalary = InputPrompter.promptInputForDouble("\t\t Enter the basic salary ");
		char grade = InputPrompter.promptInputForChar("\t\t Enter Grade ");
		String cityName = InputPrompter.promptInputForString("\t\t Enter city name");
		LocalDate dateOfJoin = InputPrompter.promptInputForDate("\t\t Enter Date of Join ", "dd-MM-yyyy");
		Gender gender = InputPrompter.promptInputForGender("\t\t Enter Gender 1.Male 2.Female");
		
		Employee employee = new Employee(name, basicSalary, grade, cityName, dateOfJoin, gender);
		
	}

	public void searchInfo() {
		System.out.println("\t\t Search Employee \n");
		int id = InputPrompter.promptInputForInt("Enter Search Id: ");
		
	}

	public void editInfo() {
		System.out.println("\t\t Edit Employee \n");
		
		int id = InputPrompter.promptInputForInt("Enter Id: ");
		String name = InputPrompter.promptInputForString("Enter Name ");
		double basicSalary = InputPrompter.promptInputForDouble("Enter the basic salary ");
		char grade = InputPrompter.promptInputForChar("Enter Grade ");
		String cityName = InputPrompter.promptInputForString("Enter city name");
		LocalDate dateOfJoin = InputPrompter.promptInputForDate("Enter Date of Join ", "dd-MM-yyyy");
		Gender gender = InputPrompter.promptInputForGender("Enter Gender 1.Male 2.Female");
	}

	public void listInfo() {
		System.out.println("\t\t List Employee \n");

	}

	public void deleteInfo() {
		System.out.println("\t\t Delete Employee \n");
		int id = InputPrompter.promptInputForInt("Enter Id to delete: ");

	}
	public void exit(){
		System.out.println("\t\t Exiting.. Thank you \n");
		System.exit(0);
	}

}
