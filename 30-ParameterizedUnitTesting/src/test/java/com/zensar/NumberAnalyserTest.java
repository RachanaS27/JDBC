package com.zensar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;



import org.junit.After;
import org.junit.Before;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.zensar.bean.NumberAnalyser;

@RunWith(Parameterized.class)
public class NumberAnalyserTest {

	private int inputNumber;
	private boolean expectedResult;
	
	public NumberAnalyserTest(int inputNumber, boolean expectedResult) {
		super();
		this.inputNumber = inputNumber;
		this.expectedResult = expectedResult;
	}
	

	@Parameterized.Parameters
	public static Collection testData() {
		Object[][] data = {
				{13,true},
				{17,true},
				{27,false},
				{28,false},
		};
		return Arrays.asList(data);
	}
	
	NumberAnalyser analyser; 
	
	@Before
	public void init() {
		analyser=new NumberAnalyser();
	}
	
	@Test
	public void f3() {
		this.analyser.setNumber(this.inputNumber);
		assertEquals(this.expectedResult, this.analyser.isPrimeNumber());
	}
	
	@After
	public void destroy() {
		this.analyser=null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
