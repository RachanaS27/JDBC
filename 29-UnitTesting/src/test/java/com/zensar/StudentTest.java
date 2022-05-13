package com.zensar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zensar.bean.Student;

public class StudentTest {

	Student student;

	@BeforeEach
	public void init() {
		student = new Student();
	}

	@Test
	public void test1() {
		Exception e = assertThrows(Exception.class, () -> this.student.setName("Abi"));
		assertEquals("Name too short", e.getMessage());
	}

	@Test
	public void test2() {
		Exception e = assertThrows(Exception.class, () -> this.student.setMark1(-87));
		assertEquals("Marks should lie between 0 and 100", e.getMessage());
	}

	@Test
	public void test3() {
		Exception e = assertThrows(Exception.class, () -> this.student.setMark2(167));
		assertEquals("Marks should lie between 0 and 100", e.getMessage());
	}

	@Test
	public void test4() {
		try {
			this.student.setMark1(98);
			int expectedResult = 98;
			assertEquals(expectedResult, this.student.getMark1());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test5() {
		try {
			this.student.setMark1(98);
			this.student.setMark2(88);
			this.student.setMark3(76);

		} catch (Exception e) {
			assertEquals("Marks should lie between 0 and 100", e.getMessage());
		}
		int actualTotal = this.student.computeTotal();
		int expectedtotal = 262;
		assertEquals(expectedtotal, actualTotal);

		
	}

}
