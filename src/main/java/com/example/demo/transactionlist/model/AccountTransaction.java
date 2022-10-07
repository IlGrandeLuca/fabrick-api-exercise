package com.example.demo.transactionlist.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class AccountTransaction {

	@Id
	@NotNull
	@Column(name="account_transaction_id")
	private long accountId;
	@NotNull
	private Date fromAccountingDate;
	@NotNull
	private Date toAccountingDate;
	private String xTimeZone;
	private String transactionId;
	private String operationId;
	private Date accountingDate;
	private Date valueDate;
	private int type; // cambiare in enum
	private int amount;
	private String currency;
	private String description;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public Date getFromAccountingDate() {
		return fromAccountingDate;
	}

	public void setFromAccountingDate(Date fromAccountingDate) {
		this.fromAccountingDate = fromAccountingDate;
	}

	public Date getToAccountingDate() {
		return toAccountingDate;
	}

	public void setToAccountingDate(Date toAccountingDate) {
		this.toAccountingDate = toAccountingDate;
	}

	public String getxTimeZone() {
		return xTimeZone;
	}

	public void setxTimeZone(String xTimeZone) {
		this.xTimeZone = xTimeZone;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public Date getAccountingDate() {
		return accountingDate;
	}

	public void setAccountingDate(Date accountingDate) {
		this.accountingDate = accountingDate;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "AccountTransaction [accountId=" + accountId + ", fromAccountingDate=" + fromAccountingDate
				+ ", toAccountingDate=" + toAccountingDate + ", xTimeZone=" + xTimeZone + ", transactionId="
				+ transactionId + ", operationId=" + operationId + ", accountingDate=" + accountingDate + ", valueDate="
				+ valueDate + ", type=" + type + ", amount=" + amount + ", currency=" + currency + ", description="
				+ description + "]";
	}

}
