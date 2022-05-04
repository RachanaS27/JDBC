package com.zensar;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.zensar.bean.Address;
import com.zensar.bean.BankAccount;
import com.zensar.bean.Employee;
import com.zensar.bean.Skill;


public class App {
	public static void loadTesting() {
		//write code here to load Employee object
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		
		Employee employee = null;
		employee = em.find(Employee.class, 3);
		System.out.println(employee);
		
		em.close();
		emf.close();
	}
	
	public static void insertTesting() {
		//write code here to persist Employee object
		
		List<Skill> skillList = new ArrayList<>();
		skillList.add(new Skill("Java", 2));
		skillList.add(new Skill("SQL",1));
		skillList.add(new Skill("Python",2));
		
		BankAccount bankAccount = new BankAccount(102, "2234HDFC79");
		Address address = new Address(2, "mysore", "560070", null);
		Employee employee = new Employee("Ramesh", 65000.00, address, skillList, bankAccount);
		employee.setAddress(address);
		address.setEmployee(employee);
		
		System.out.println(employee.toString());
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(employee);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
  public static void main(String[] args) {
    
	  // insertTesting();
	  loadTesting();
  }
}
