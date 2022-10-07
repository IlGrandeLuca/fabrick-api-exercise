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

public class TaxRelief {

	private String taxReliefId;
	private boolean isCondoUpgrade;
	private String creditorFiscalCode;
	private String beneficiaryType;
	private NaturalPersonBeneficiary naturalPersonBeneficiary;
	private LegalPersonBeneficiary legalPersonBeneficiary;

	public String getTaxReliefId() {
		return taxReliefId;
	}

	public void setTaxReliefId(String taxReliefId) {
		this.taxReliefId = taxReliefId;
	}

	public boolean getIsCondoUpgrade() {
		return isCondoUpgrade;
	}

	public void setIsCondoUpgrade(boolean isCondoUpgrade) {
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

	public NaturalPersonBeneficiary getNaturalPersonBeneficiary() {
		return naturalPersonBeneficiary;
	}

	public void setNaturalPersonBeneficiary(NaturalPersonBeneficiary naturalPersonBeneficiary) {
		this.naturalPersonBeneficiary = naturalPersonBeneficiary;
	}

	public LegalPersonBeneficiary getLegalPersonBeneficiary() {
		return legalPersonBeneficiary;
	}

	public void setLegalPersonBeneficiary(LegalPersonBeneficiary legalPersonBeneficiary) {
		this.legalPersonBeneficiary = legalPersonBeneficiary;
	}
}
