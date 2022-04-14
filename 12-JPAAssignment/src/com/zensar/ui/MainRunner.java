package com.zensar.ui;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.zensar.bean.Account;

public class MainRunner {

	public static void demo1() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAIntro");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Account account = new Account();
		account.setName("Rakesh");
		account.setBalance(20000);
		account.setDateOfOpening(LocalDate.of(2022, 02, 27));

		em.persist(account);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

	public static void demo2() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAIntro");
		EntityManager em = emf.createEntityManager();

		Account account = null;
		account = em.find(Account.class, 1);
		System.out.println(account);

		em.close();
		emf.close();
	}

	public static void demo3() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAIntro");
		EntityManager em = emf.createEntityManager();

		Account account = null;
		account = em.find(Account.class, 1);

		em.getTransaction().begin();

		account.setName(account.getName().toUpperCase());
		em.merge(account);

		em.getTransaction().commit();

		System.out.println(account);

		em.close();
		emf.close();
	}

	public static void demo4() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAIntro");
		EntityManager em = emf.createEntityManager();

		Account account = null;
		account = em.find(Account.class, 1);

		em.getTransaction().begin();
		em.remove(account);

		em.getTransaction().commit();

		System.out.println(account);

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
