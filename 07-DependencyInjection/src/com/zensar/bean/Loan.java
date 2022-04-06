package com.zensar.bean;

public class Loan {

	private String customerName;
	private double loanAmount;
	public Loan() {
		super();
	}
	public Loan(String customerName, double loanAmount) {
		super();
		this.customerName = customerName;
		this.loanAmount = loanAmount;
	}
	public String getcustomerName() {
		return customerName;
	}
	public void setcustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	@Override
	public String toString() {
		return "Loan [customerName=" + customerName + ", loanAmount=" + loanAmount
				+ "]";
	}
	
	
}
