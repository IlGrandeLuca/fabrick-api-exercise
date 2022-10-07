package com.example.demo.moneytransfer.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class TaxRelief {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "taxrelief_id")
	private int id;
	private String taxReliefId;
	@NotNull
	private boolean isCondoUpgrade;
	@NotNull
	private String creditorFiscalCode;
	@NotNull
	private String beneficiaryType;
	@OneToOne(mappedBy = "taxRelief1")
	private NaturalPersonBeneficiary natural;
	@OneToOne(mappedBy = "taxRelief2")
	private LegalPersonBeneficiary legal;
	@ManyToOne
	private MoneyTransfer moneyTransfer;

	public String getTaxReliefId() {
		return taxReliefId;
	}

	public void setTaxReliefId(String taxReliefId) {
		this.taxReliefId = taxReliefId;
	}

	public boolean isCondoUpgrade() {
		return isCondoUpgrade;
	}

	public void setCondoUpgrade(boolean isCondoUpgrade) {
		this.isCondoUpgrade = isCondoUpgrade;
	}

	public String getCreditorFiscalCode() {
		return creditorFiscalCode;
	}

	public void setCreditorFiscalCode(String creditorFiscalCode) {
		this.creditorFiscalCode = creditorFiscalCode;
	}

	public String getBeneficiaryType() {
		return beneficiaryType;
	}

	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NaturalPersonBeneficiary getNatural() {
		return natural;
	}

	public void setNatural(NaturalPersonBeneficiary natural) {
		this.natural = natural;
	}

	public LegalPersonBeneficiary getLegal() {
		return legal;
	}

	public void setLegal(LegalPersonBeneficiary legal) {
		this.legal = legal;
	}

	public MoneyTransfer getMoneyTransfer() {
		return moneyTransfer;
	}

	public void setMoneyTransfer(MoneyTransfer moneyTransfer) {
		this.moneyTransfer = moneyTransfer;
	}

	@Override
	public String toString() {
		return "TaxRelief [taxReliefId=" + taxReliefId + ", isCondoUpgrade=" + isCondoUpgrade + ", creditorFiscalCode="
				+ creditorFiscalCode + ", beneficiaryType=" + beneficiaryType + ", naturalPersonBeneficiary=" + natural
				+ ", legalPersonBeneficiary=" + legal + "]";
	}

}
