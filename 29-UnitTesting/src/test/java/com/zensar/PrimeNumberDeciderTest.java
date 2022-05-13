package com.zensar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zensar.bean.PrimeNumberDecider;

public class PrimeNumberDeciderTest {

	PrimeNumberDecider pm;
	
	@BeforeAll
	public static void init() {
		System.out.println("Class loading");
	}
	
	@AfterAll
	public static void destroy() {
		System.out.println("class unloaded");
	}
	
	
	@BeforeEach
	public void f1() {
		pm = new PrimeNumberDecider();
		 System.out.println("f1 executes --");
	}
	
	@AfterEach
	public void f2() {
		pm=null;
		System.out.println("f2 executes **");
	}
	
	@Test
	public void isPrimeNumbertest1() {
		pm.setNumber(2);
		boolean actualResult=pm.isPrimeNumber();
		boolean expectedResult = true;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void isPrimeNumbertest2() {
		pm.setNumber(0);

		boolean actualResult=pm.isPrimeNumber();
		boolean expectedResult = false;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void isPrimeNumbertest3() {
		pm.setNumber(14);

		boolean actualResult=pm.isPrimeNumber();
		boolean expectedResult = false;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void isPrimeNumbertest4() {
		pm.setNumber(13);

		boolean actualResult=pm.isPrimeNumber();
		boolean expectedResult = true;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void isPrimeNumbertest5() {
		pm.setNumber(47);

		boolean actualResult=pm.isPrimeNumber();
		boolean expectedResult = true;
		assertEquals(expectedResult, actualResult);
	}
	
	
	@Test
	public void isPrimeNumbertest6() {
		pm.setNumber(-14);

		boolean actualResult=pm.isPrimeNumber();
		boolean expectedResult = false;
		assertEquals(expectedResult, actualResult);
	}
	
	
	@Test
	public void isPrimeNumbertest7() {
		pm.setNumber(-2);

		boolean actualResult=pm.isPrimeNumber();
		boolean expectedResult = false;
		assertEquals(expectedResult, actualResult);
	}
	

	
	
	
}
