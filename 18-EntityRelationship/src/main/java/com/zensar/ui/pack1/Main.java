package com.zensar.ui.pack1;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import com.zensar.bean.pack1.ContactInfo;
import com.zensar.bean.pack1.Person;
import com.zensar.util.JPAUtil;

public class Main {
	
	static void test1() {
		Person person = new Person(202, "Harshitha", LocalDate.of(1994, 10, 19), 'F', null);
		ContactInfo contactInfo = new ContactInfo("harshi@google.com", "8889298292");
		person.setContactInfo(contactInfo);
	  	
		EntityManager em = JPAUtil.createEntityManager("PU");
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
		
		JPAUtil.shutDown();
		
	}
	

	static void test2() {
		
		ContactInfo contactInfo= new ContactInfo("steve@gmail.com", "6782992289");
		
		EntityManager em = JPAUtil.createEntityManager("PU");
		
		em.getTransaction().begin();
		em.persist(contactInfo);
		em.getTransaction().commit();
		JPAUtil.shutDown();
	}
	
	static void test3() {
		Person person = new Person(201, "Steve", LocalDate.of(1999, 3, 12), 'M', null);
		
		EntityManager em = JPAUtil.createEntityManager("PU");
		ContactInfo contactInfo = em.find(ContactInfo.class, 2);
		person.setContactInfo(contactInfo);
		
		
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
		
		JPAUtil.shutDown();
	}
	
	static void test4() {
		EntityManager em = JPAUtil.createEntityManager("PU");
		
		ContactInfo contactInfo = em.find(ContactInfo.class, 2);
		
		System.out.println(contactInfo);
		JPAUtil.shutDown();
	}
	
	static void test5() {
		EntityManager em = JPAUtil.createEntityManager("PU");
		
		Person person = em.find(Person.class, 201);
		System.out.println(person);
		
		JPAUtil.shutDown();
	}
	
	static void test6() {
		EntityManager em = JPAUtil.createEntityManager("PU");
		
		Person person = em.find(Person.class, 202);
		em.getTransaction().begin();
		em.remove(person);
		em.getTransaction().commit();
		
		JPAUtil.shutDown();
	}
	
	static void test7() {
		EntityManager em = JPAUtil.createEntityManager("PU");
		
		Person person = em.find(Person.class, 201);
		em.getTransaction().begin();
		person.setPersonName("Sujay");
		person.getContactInfo().setEmail("sujay@gmail.com");
		em.getTransaction().commit();
		
		JPAUtil.shutDown();
	}
	
	public static void main(String[] args) {

		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		//test6();
		test7();

	}

}
