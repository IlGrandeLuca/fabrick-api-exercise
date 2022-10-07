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
public class LegalPersonBeneficiary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "legal_id")
	private int id;
	@NotNull
	private String fiscalCode;
	private String legalRepresentativeFiscalCode;
	@OneToOne
	private TaxRelief taxRelief2;

	public String getFiscalCode() {
		return fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}

	public String getLegalRepresentativeFiscalCode() {
		return legalRepresentativeFiscalCode;
	}

	public void setLegalRepresentativeFiscalCode(String legalRepresentativeFiscalCode) {
		this.legalRepresentativeFiscalCode = legalRepresentativeFiscalCode;
	}

	@Override
	public String toString() {
		return "LegalPersonBeneficiary [id=" + id + ", fiscalCode=" + fiscalCode + ", legalRepresentativeFiscalCode="
				+ legalRepresentativeFiscalCode + "]";
	}

}
