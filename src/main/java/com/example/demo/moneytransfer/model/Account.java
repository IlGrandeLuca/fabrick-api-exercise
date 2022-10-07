package com.example.demo.moneytransfer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Account {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String accountCode;
	private String bicCode;
	@ManyToOne
	private Creditor creditor1;

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getBicCode() {
		return bicCode;
	}

	public void setBicCode(String bicCode) {
		this.bicCode = bicCode;
	}

	public Creditor getCreditor() {
		return creditor1;
	}

	public void setCreditor(Creditor creditor) {
		this.creditor1 = creditor;
	}

	@Override
	public String toString() {
		return "Account [accountCode=" + accountCode + ", bicCode=" + bicCode + "]";
	}

}
