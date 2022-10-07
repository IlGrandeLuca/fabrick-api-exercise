package com.example.demo.moneytransfer.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Creditor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int creditorId;
	@NotNull
	private String name;
	@NotNull
	@OneToMany(mappedBy = "creditor1")
	private List<Account> account;
	@OneToMany(mappedBy = "creditor2")
	private List<Address> address;
	@OneToMany(mappedBy = "creditor3")
	private List<MoneyTransfer> moneyTransfer;

	public int getCreditorId() {
		return creditorId;
	}

	public void setCreditorId(int creditorId) {
		this.creditorId = creditorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<MoneyTransfer> getMoneyTransfer() {
		return moneyTransfer;
	}

	public void setMoneyTransfer(List<MoneyTransfer> moneyTransfer) {
		this.moneyTransfer = moneyTransfer;
	}

	@Override
	public String toString() {
		return "Creditor [id=" + creditorId + ", name=" + name + ", account=" + account + ", address=" + address + "]";
	}

}
