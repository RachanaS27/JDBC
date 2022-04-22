package com.zensar.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank_account")
public class BankAccount {

	@Id
	int bankId;
	@Column
	String accountId;
	
	public BankAccount() {
		super();
	}

	public BankAccount(int bankId) {
		super();
		this.bankId = bankId;
	}

	public BankAccount(String accountId) {
		super();
		this.accountId = accountId;
	}

	public BankAccount(int bankId, String accountId) {
		super();
		this.bankId = bankId;
		this.accountId = accountId;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "BankAccount [bankId=" + bankId + ", accountId=" + accountId + "]";
	}
	
	
}
