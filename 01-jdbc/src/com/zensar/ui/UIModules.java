package com.zensar.ui;

import java.time.LocalDate;
import java.util.List;

import com.zensar.bean.Employee;
import com.zensar.bean.Gender;
import com.zensar.service.EmployeeService;
import com.zensar.service.EmployeeServiceImpl;

public class UIModules {
	
	EmployeeService employeeService = new EmployeeServiceImpl();

	public void addInfo() throws Exception {
		System.out.println("\t\t Add New Employee \n");
		System.out.println("\t\t ----------------------");
		
		String name = InputPrompter.promptInputForString("\t\t Enter Name ");
		double basicSalary = InputPrompter.promptInputForDouble("\t\t Enter the basic salary ");
		char grade = InputPrompter.promptInputForChar("\t\t Enter Grade ");
		String cityName = InputPrompter.promptInputForString("\t\t Enter city name");
		LocalDate dateOfJoin = InputPrompter.promptInputForDate("\t\t Enter Date of Join ", "dd-MM-yyyy");
		Gender gender = InputPrompter.promptInputForGender("\t\t Enter Gender 1.Male 2.Female");
		
		Employee employee = new Employee(name, basicSalary, grade, cityName, dateOfJoin, gender);
		this.employeeService.addEmployee(employee);
	}

	public void searchInfo() throws Exception {
		System.out.println("\t\t Search Employee \n");
		int id = InputPrompter.promptInputForInt("Enter Search Id: ");
		
		Employee employee = employeeService.findEmployee(id);
		System.out.println(employee);
	}

	public void editInfo() throws Exception {
		System.out.println("\t\t Edit Employee \n");
		
		int id = InputPrompter.promptInputForInt("Enter Id: ");
		String name = InputPrompter.promptInputForString("Enter Name ");
		double basicSalary = InputPrompter.promptInputForDouble("Enter the basic salary ");
		char grade = InputPrompter.promptInputForChar("Enter Grade ");
		String cityName = InputPrompter.promptInputForString("Enter city name");
		LocalDate dateOfJoin = InputPrompter.promptInputForDate("Enter Date of Join ", "dd-MM-yyyy");
		Gender gender = InputPrompter.promptInputForGender("Enter Gender 1.Male 2.Female");
		
		Employee employee = new Employee(id, name, basicSalary, grade, cityName, dateOfJoin, gender);
		employee = this.employeeService.updateEmployee(employee);
	
		System.out.println("Employee updated");
	}

	public void listInfo() throws Exception {
		System.out.println("\t\t List Employee \n");
		
		List<Employee> allEmployees = this.employeeService.findAllEmployee();
		for (Employee employee : allEmployees) {
			System.out.println("\t\t"+employee);
		}
	}

	public void deleteInfo() throws Exception {
		System.out.println("\t\t Delete Employee \n");
		int id = InputPrompter.promptInputForInt("Enter Id to delete: ");
		
		boolean res= this.employeeService.removeEmployee(id);
		if(res)
			System.out.println("\t  Record Deleted");
		else
			System.out.println("\t Record not deleted");
	}
	public void exit(){
		System.out.println("\t\t Exiting.. Thank you \n");
		System.exit(0);
	}

}
