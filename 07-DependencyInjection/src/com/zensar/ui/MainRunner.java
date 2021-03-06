package com.zensar.ui;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.bean.Loan;
import com.zensar.bean.Person;
import com.zensar.bean.Student;

public class MainRunner {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
		Student s1,s2;
		s1=(Student)context.getBean("stud1");
		s2=(Student)context.getBean("stud2");
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		
		String str = (String)context.getBean("company");
		System.out.println(str);
		Double num = (Double)context.getBean("basicSalary");
		System.out.println(num);
		
		float n2 = (Float)context.getBean("floatNum");
		System.out.println(n2);
		
		Student s3 = (Student)context.getBean("stud3");
		System.out.println(s3);
		
		Loan l1= (Loan)context.getBean("loan1");
		System.out.println(l1);
		
		Person person = (Person)context.getBean("personBean");
		System.out.println(person);
		System.out.println(person.getAllowance());

		Person person1 = (Person)context.getBean("personBean1");
		System.out.println(person1);
		System.out.println(person1.getAllowance());
		
		



	}

}
