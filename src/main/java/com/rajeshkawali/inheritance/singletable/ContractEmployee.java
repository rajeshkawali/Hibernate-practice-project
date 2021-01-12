package com.rajeshkawali.inheritance.singletable;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CONTRACT")
public class ContractEmployee extends Employee {
	
	private LocalDate contractStartDate;
	private LocalDate contractEndDate;
	private String agencyName;

	public ContractEmployee() {
	}

	public ContractEmployee(LocalDate contractStartDate, LocalDate contractEndDate, String agencyName) {
		super();
		this.contractStartDate = contractStartDate;
		this.contractEndDate = contractEndDate;
		this.agencyName = agencyName;
	}

	public LocalDate getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(LocalDate contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public LocalDate getContractEndDate() {
		return contractEndDate;
	}

	public void setContractEndDate(LocalDate contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
}
