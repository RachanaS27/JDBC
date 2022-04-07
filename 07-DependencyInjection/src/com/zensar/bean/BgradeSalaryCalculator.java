package com.zensar.bean;

public class BgradeSalaryCalculator implements SalaryCalculator {
	public double computeAllowance(double basic){
		double allow = basic *0.10;
		return allow;
	}
}
