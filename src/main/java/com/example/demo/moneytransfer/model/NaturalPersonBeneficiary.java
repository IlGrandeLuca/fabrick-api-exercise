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
public class NaturalPersonBeneficiary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "natural_id")
	private int id;
	@NotNull
	private String fiscalCode1;
	private String fiscalCode2;
	private String fiscalCode3;
	private String fiscalCode4;
	private String fiscalCode5;
	@OneToOne
	private TaxRelief taxRelief1;

	public String getFiscalCode1() {
		return fiscalCode1;
	}

	public void setFiscalCode1(String fiscalCode1) {
		this.fiscalCode1 = fiscalCode1;
	}

	public String getFiscalCode2() {
		return fiscalCode2;
	}

	public void setFiscalCode2(String fiscalCode2) {
		this.fiscalCode2 = fiscalCode2;
	}

	public String getFiscalCode3() {
		return fiscalCode3;
	}

	public void setFiscalCode3(String fiscalCode3) {
		this.fiscalCode3 = fiscalCode3;
	}

	public String getFiscalCode4() {
		return fiscalCode4;
	}

	public void setFiscalCode4(String fiscalCode4) {
		this.fiscalCode4 = fiscalCode4;
	}

	public String getFiscalCode5() {
		return fiscalCode5;
	}

	public void setFiscalCode5(String fiscalCode5) {
		this.fiscalCode5 = fiscalCode5;
	}

	@Override
	public String toString() {
		return "NaturalPersonBeneficiary [id=" + id + ", fiscalCode1=" + fiscalCode1 + ", fiscalCode2=" + fiscalCode2
				+ ", fiscalCode3=" + fiscalCode3 + ", fiscalCode4=" + fiscalCode4 + ", fiscalCode5=" + fiscalCode5
				+ "]";
	}

}
