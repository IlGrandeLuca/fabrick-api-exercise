package com.example.demo.accountbalance.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class AccountBalance {

	@Id
	@NotNull
	private long accountId;
	private String xTimeZone;
	@JsonProperty("date")
	private Date date;
	@JsonProperty("balance")
	private double balance;
	@JsonProperty("availableBalance")
	private double availableBalance;
	@JsonProperty("currency")
	private String currency;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getxTimeZone() {
		return xTimeZone;
	}

	public void setxTimeZone(String xTimeZone) {
		this.xTimeZone = xTimeZone;
	}

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
		return "AccountBalance [accountId=" + accountId + ", xTimeZone=" + xTimeZone + ", date=" + date + ", balance="
				+ balance + ", availableBalance=" + availableBalance + ", currency=" + currency + "]";
	}
}
