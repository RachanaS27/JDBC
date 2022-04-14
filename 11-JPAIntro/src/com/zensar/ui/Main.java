package com.zensar.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.zensar.bean.Contact;

public class Main {

	public static void demo1() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAIntro");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Contact contact = new Contact();
		contact.setName("Das");
		contact.setEmail("Das@gmail.com");
		contact.setPhone("989898765");

		em.persist(contact);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

	public static void demo2() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAIntro");
		EntityManager em = emf.createEntityManager();

		Contact contact = null;
		contact = em.find(Contact.class, 1);
		System.out.println(contact);

		em.close();
		emf.close();
	}

	public static void demo3() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAIntro");
		EntityManager em = emf.createEntityManager();

		Contact contact = null;
		contact = em.find(Contact.class, 1);

		em.getTransaction().begin();

		contact.setName(contact.getName().toUpperCase());
		em.merge(contact);

		em.getTransaction().commit();

		System.out.println(contact);

		em.close();
		emf.close();
	}

	public static void demo4() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAIntro");
		EntityManager em = emf.createEntityManager();

		Contact contact = null;
		contact = em.find(Contact.class, 1);

		em.getTransaction().begin();
		em.remove(contact);

		em.getTransaction().commit();

		System.out.println(contact);

		em.close();
		emf.close();
	}

	public static void main(String[] args) {

		//demo1();
		//demo2();
		//demo3();
		//demo4();
	}

}
