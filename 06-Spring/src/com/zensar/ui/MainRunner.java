package com.zensar.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.bean.Employee;

public class MainRunner {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
		Employee e = (Employee)context.getBean("employeeBean");
		System.out.println(e.toString());
		
	}

}
