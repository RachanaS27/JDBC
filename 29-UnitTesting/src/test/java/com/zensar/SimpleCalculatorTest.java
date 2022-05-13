package com.zensar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleCalculatorTest {

	SimpleCalculator sc;
	
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
		 sc = new SimpleCalculator();
		 System.out.println("f1 executes --");
	}
	
	@AfterEach
	public void f2() {
		sc=null;
		System.out.println("f2 executes **");
	}
	
	
	@Test
	public void addTesting1() {
		int actualResult= sc.add(11, 23);
		int expectedResult=34;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void addTesting2() {
		int actualResult= sc.add(-11, -23);
		int expectedResult=-34;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void addTesting3() {
		int actualResult= sc.add(11, -23);
		int expectedResult=-12;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void addTesting4() {
		int actualResult= sc.add(-11, 23);
		int expectedResult=12;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void multiplyTesting1() {
		int actualResult= sc.multiply(10, 5);
		int expectedResult=50;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void multiplyTesting2() {
		int actualResult= sc.multiply(-10, -5);
		int expectedResult=50;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void multiplyTesting3() {
		int actualResult= sc.multiply(10, -5);
		int expectedResult=-50;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void multiplyTesting4() {
		int actualResult= sc.multiply(-10, 5);
		int expectedResult=-50;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void divideTesting1() {
		int actualResult= sc.divide(10, 5);
		int expectedResult=2;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void divideTesting2() {
		int actualResult= sc.divide(-10, 5);
		int expectedResult=-2;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void divideTesting3() {
		int actualResult= sc.divide(-10, -5);
		int expectedResult=2;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void divideTesting4() {
		int actualResult= sc.divide(10, -5);
		int expectedResult=-2;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void subtractTesting1() {
		int actualResult= sc.subtract(11, 23);
		int expectedResult=-12;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void subtractTesting2() {
		int actualResult= sc.subtract(-11, -23);
		int expectedResult=12;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void subtractTesting3() {
		int actualResult= sc.subtract(11, -23);
		int expectedResult=34;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void subtractTesting4() {
		int actualResult= sc.subtract(-11, 23);
		int expectedResult=-34;
		assertEquals(expectedResult, actualResult);
	}
}
