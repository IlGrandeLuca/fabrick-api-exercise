package com.example.demo.accountbalance.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountBalance {

	private Date date;
	private double balance;
	private double availableBalance;
	private String currency;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "AccountBalance{" +
				"date=" + date +
				", balance=" + balance +
				", availableBalance=" + availableBalance +
				", currency='" + currency + '\'' +
				'}';
	}
}
