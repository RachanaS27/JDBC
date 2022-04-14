package com.zensar.ui.pack1;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import com.zensar.bean.pack1.ContactInfo;
import com.zensar.bean.pack1.Person;
import com.zensar.util.JPAUtil;

public class MainRunner {
	
	static void test1() {
		Person person= new Person(101, "Mike", LocalDate.of(1998, 2, 12), 'M', null);
		
		ContactInfo contactInfo = new ContactInfo("Mike@google.com", "8927289298");
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
		Person person = new Person(102, "Ramya", LocalDate.of(1999, 3, 12), 'F', null);
		
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
		
		Person person = em.find(Person.class, 102);
		System.out.println(person);
		
		JPAUtil.shutDown();
	}
	
	static void test6() {
		EntityManager em = JPAUtil.createEntityManager("PU");
		
		Person person = em.find(Person.class, 102);
		em.getTransaction().begin();
		em.remove(person);
		em.getTransaction().commit();
		
		JPAUtil.shutDown();
	}

	public static void main(String[] args) {
		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		test6();
	}

}
