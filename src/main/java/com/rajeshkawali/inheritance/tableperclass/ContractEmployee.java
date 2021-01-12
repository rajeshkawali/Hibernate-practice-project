package com.rajeshkawali.inheritance.tableperclass;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "tablePerClassContractEmployee")
@Table(name = "TABLE_PER_CLASS_CONTRACT_EMPLOYEE")
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
