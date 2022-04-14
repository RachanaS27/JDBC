package com.zensar.ui.pack1;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import com.zensar.bean.pack1.Doctor;
import com.zensar.util.JPAUtil;

public class Main1 {

	
	public static void main(String[] args) {

		Doctor doctor1 = new Doctor("Santhosh", 500, "Male", LocalDate.of(2018, 2, 12));
		Doctor doctor2 = new Doctor("Sindhu", 500, "Female", LocalDate.of(2017, 3, 22));
		Doctor doctor3 = new Doctor("Prakash", 1000, "Male", LocalDate.of(2014, 1, 9));
		Doctor doctor4= new Doctor("Deepak", 1500, "Male", LocalDate.of(2012, 11, 27));
		Doctor doctor5 = new Doctor("Lakshmi", 1000, "Female", LocalDate.of(2012, 12, 12));
		Doctor doctor6 = new Doctor("Kamala", 500, "Female", LocalDate.of(2012, 2, 22));

		EntityManager em = JPAUtil.createEntityManager("PU");
		
		em.getTransaction().begin();
		em.persist(doctor1);
		em.persist(doctor2);
		em.persist(doctor3);
		em.persist(doctor4);
		em.persist(doctor5);
		em.persist(doctor6);
		em.getTransaction().commit();
		
		JPAUtil.shutDown();

	}

}
