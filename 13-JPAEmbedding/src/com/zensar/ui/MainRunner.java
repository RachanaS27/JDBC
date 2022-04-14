package com.zensar.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.zensar.bean.Address;
import com.zensar.bean.Student;

public class MainRunner {
	
	public static void demo1(){
		Address address =new Address();
		address.setDoorNo("F-1");
		address.setAreaName("Padmanabhanagar");
		address.setCityName("Bangalore");
		
		Student student = new Student();
		student.setName("Rohit");
		student.setAddress(address);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAIntro");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
		
		em.close();
	}
	
	public static void demo2() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAIntro");
		EntityManager em = emf.createEntityManager();

		Student student = null;
		student = em.find(Student.class, 1);
		System.out.println(student);

		em.close();
		emf.close();
	}

	public static void demo3() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAIntro");
		EntityManager em = emf.createEntityManager();

		Student student = null;
		student = em.find(Student.class, 1);

		em.getTransaction().begin();

		student.setName(student.getName().toUpperCase());
		student.getAddress().setCityName("Hassan");
		em.merge(student);

		em.getTransaction().commit();

		System.out.println(student);

		em.close();
		emf.close();
	}

	public static void demo4() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAIntro");
		EntityManager em = emf.createEntityManager();

		Student student = null;
		student = em.find(Student.class, 2);

		em.getTransaction().begin();
		em.remove(student);

		em.getTransaction().commit();

		System.out.println(student);

		em.close();
		emf.close();
	}

	public static void main(String[] args) {
		 //demo1();
		 //demo2(); 
		 //demo3(); 
		 demo4();
	}

}
