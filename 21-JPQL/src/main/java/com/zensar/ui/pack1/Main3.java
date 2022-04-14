package com.zensar.ui.pack1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.zensar.bean.pack1.Doctor;
import com.zensar.util.JPAUtil;

public class Main3 {


	static void test1() {
		EntityManager em = JPAUtil.createEntityManager("PU");
		Query query = em.createNamedQuery("readAll", Doctor.class);
		List doctor = query.getResultList();
		System.out.println(doctor);
		JPAUtil.shutDown();
		
	}
	
	static void test2() {
		EntityManager em = JPAUtil.createEntityManager("PU");
		TypedQuery<Doctor> query = em.createNamedQuery("readById", Doctor.class);
		query.setParameter(1, 3);
		Doctor doctor = query.getSingleResult();
		System.out.println(doctor);
		JPAUtil.shutDown();
	
	
	}
	
	static void test3() {
		EntityManager em = JPAUtil.createEntityManager("PU");
		Query query = em.createNamedQuery("readByFee", Doctor.class);
		query.setParameter(1, 400);
		query.setParameter(2, 1001);
		List doctor = query.getResultList();
		System.out.println(doctor);
		JPAUtil.shutDown();
		
	}

	public static void main(String[] args) {
		//test1();
		test3();
		//test2();
	}

}
