package com.example.demo.moneytransfer.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class MoneyTransfer {

	@NotNull
	private String xTimeZone;
	@Id
	@NotNull
	private long accountId;
	@ManyToOne
	@NotNull
	private Creditor creditor3;
	private Date executionDate;
	private String uri;
	@NotNull
	private String description;
	@NotNull
	private BigDecimal amount;
	@NotNull
	private String currency;
	private boolean isUrgent;
	private boolean isInstant;
	private String feeType;
	private String feeAccountId;
	@OneToMany(mappedBy = "moneyTransfer")
	private List<TaxRelief> taxRelief;

	public String getxTimeZone() {
		return xTimeZone;
	}

	public void setxTimeZone(String xTimeZone) {
		this.xTimeZone = xTimeZone;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public Creditor getCreditor() {
		return creditor3;
	}

	public void setCreditor(Creditor creditor) {
		this.creditor3 = creditor;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public boolean isUrgent() {
		return isUrgent;
	}

	public void setUrgent(boolean isUrgent) {
		this.isUrgent = isUrgent;
	}

	public boolean isInstant() {
		return isInstant;
	}

	public void setInstant(boolean isInstant) {
		this.isInstant = isInstant;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getFeeAccountId() {
		return feeAccountId;
	}

	public void setFeeAccountId(String feeAccountId) {
		this.feeAccountId = feeAccountId;
	}

	public List<TaxRelief> getTaxRelief() {
		return taxRelief;
	}

	public void setTaxRelief(List<TaxRelief> taxRelief) {
		this.taxRelief = taxRelief;
	}

	@Override
	public String toString() {
		return "MoneyTransfer [xTimeZone=" + xTimeZone + ", accountId=" + accountId + ", creditor=" + creditor3
				+ ", executionDate=" + executionDate + ", uri=" + uri + ", description=" + description + ", amount="
				+ amount + ", currency=" + currency + ", isUrgent=" + isUrgent + ", isInstant=" + isInstant
				+ ", feeType=" + feeType + ", feeAccountId=" + feeAccountId + ", taxRelief=" + taxRelief + "]";
	}

}
