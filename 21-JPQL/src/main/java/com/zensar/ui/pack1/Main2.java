package com.zensar.ui.pack1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.print.Doc;

import com.zensar.bean.pack1.Doctor;
import com.zensar.util.JPAUtil;

public class Main2 {
	
	static void test1() {
		EntityManager em = JPAUtil.createEntityManager("PU");
		TypedQuery<Doctor> query = em.createNamedQuery("findAll", Doctor.class);
		List<Doctor> doctor = query.getResultList();
		System.out.println(doctor);
		JPAUtil.shutDown();
		
	}
	
	static void test2() {
		EntityManager em = JPAUtil.createEntityManager("PU");
		TypedQuery<Doctor> query = em.createNamedQuery("findById", Doctor.class);
		query.setParameter("did", 2);
		Doctor doctor = query.getSingleResult();
		System.out.println(doctor);
		JPAUtil.shutDown();
	}
	
	static void test3() {
		EntityManager em = JPAUtil.createEntityManager("PU");
		TypedQuery<Doctor> query = em.createNamedQuery("findByFee", Doctor.class);
		query.setParameter("a", 500.00);
		query.setParameter("b", 1000.00);
		List<Doctor> doctor = query.getResultList();
		System.out.println(doctor);
		JPAUtil.shutDown();
	}


	public static void main(String[] args) {
		//test1();
		//test2();
		test3();

	}

}
