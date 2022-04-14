package com.zensar.ui.pack1;

import javax.persistence.EntityManager;

import com.zensar.bean.pack1.Course;
import com.zensar.bean.pack1.Subject;
import com.zensar.util.JPAUtil;

public class MainRunner {

	private static void insertTesting() {
		EntityManager em = JPAUtil.createEntityManager("PU");

		Course course = new Course("Induction Training", 32000.00);

		course.addSubject(new Subject("Spring", 42));
		course.addSubject(new Subject("JPA", 18));
		course.addSubject(new Subject("JQuery", 20));
		course.addSubject(new Subject("Angular", 50));
		course.addSubject(new Subject("Ajax", 5));

		em.getTransaction().begin();
		em.persist(course);
		em.getTransaction().commit();
		System.out.println(">>>>> course data saved <<<<<");

	}

	private static void loadTesting() {
		EntityManager em = JPAUtil.createEntityManager("PU");

		Course course = em.find(Course.class, 1);
		System.out.println(course);

		JPAUtil.shutDown();
	}

	private static void editTesting() {
		EntityManager em = JPAUtil.createEntityManager("PU");

		Course course = em.find(Course.class, 1);
		System.out.println(course);

		course.setFee(course.getFee() + 3000);
		course.setCourseName(course.getCourseName().toUpperCase());

		course.getSubjects().remove(em.find(Subject.class, 2));
		course.getSubjects().add(new Subject("React JS", 28));

		em.getTransaction().begin();
		em.merge(course);
		em.getTransaction().commit();

		JPAUtil.shutDown();
	}

	private static void deleteTesting() {
		EntityManager em = JPAUtil.createEntityManager("PU");

		Subject subject = em.find(Subject.class, 5);
		em.getTransaction().begin();
		em.remove(subject);
		em.getTransaction().commit();

		JPAUtil.shutDown();
	}



	public static void main(String[] args) {
		// insertTesting();
		// loadTesting();
		// editTesting();
		deleteTesting();
	}

}
