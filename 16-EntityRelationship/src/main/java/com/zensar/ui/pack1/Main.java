package com.zensar.ui.pack1;

import javax.persistence.EntityManager;

import com.zensar.bean.pack1.Address;
import com.zensar.bean.pack1.Employee;
import com.zensar.util.JPAUtil;

public class Main {
	
	static void test1() {
		
		Employee employee = new Employee(101, "Rachana", 50000, null);
		Address address = new Address("F-4", "Padmanabhanagar", "Bangalore", null);
		employee.setAddress(address);
		address.setEmployee(employee);
		
		EntityManager em= JPAUtil.createEntityManager("PU");
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		
		JPAUtil.shutDown();
	}
	
	static void test2() {
		EntityManager em= JPAUtil.createEntityManager("Employee");
		Employee employee= em.find(Employee.class, 1);
		System.out.println(employee);
		JPAUtil.shutDown();
	}

	public static void main(String[] args) {
		test1();
		//test2();
	}
}
