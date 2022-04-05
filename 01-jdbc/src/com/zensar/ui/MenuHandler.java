package com.zensar.ui;

import java.util.Scanner;

public class MenuHandler {

	public void displayMenu() {
		String[] menuItem = { "Add Employee", "Search Employee",
				"Edit Employee", "List All Employee", "Delete Employee", "Exit" };

		for (int i = 0; i < menuItem.length; i++) {
			System.out.println("\t\t" + (i + 1) + " " + menuItem[i]);

		}
		System.out.println("\t\t-----------------------------");
		System.out.print("\t\t Enter your Choice :  ");
	}

	public void dispatchMenu() {
		int choice = 0;
		Scanner scan = new Scanner(System.in);
		choice = scan.nextInt();
		switch (choice) {
		case 1:
			new UIModules().addInfo();
			break;
		case 2:
			new UIModules().searchInfo();
			break;
		case 3:
			new UIModules().editInfo();
			break;
		case 4:
			new UIModules().listInfo();
			break;
		case 5:
			new UIModules().deleteInfo();
			break;
		case 6:
			new UIModules().exit();
			scan.close();
			break;
		default:
			break;
		}
	}
}
