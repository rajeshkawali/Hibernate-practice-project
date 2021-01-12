package com.rajeshkawali.inheritance.jointable;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name = "joinedTablePermanentEmployee")
@Table(name = "JOIN_TABLE_PERMANENT_EMPLOYEE")
@PrimaryKeyJoinColumn(name = "ID")
@DiscriminatorValue("PERMANENT")
public class PermanentEmployee extends Employee {

	private LocalDate startingDate;
	private String costCenter;
	private Float totalLeaves;

	public PermanentEmployee() {
	}

	public PermanentEmployee(LocalDate startingDate, String costCenter, Float totalLeaves) {
		super();
		this.startingDate = startingDate;
		this.costCenter = costCenter;
		this.totalLeaves = totalLeaves;
	}

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public Float getTotalLeaves() {
		return totalLeaves;
	}

	public void setTotalLeaves(Float totalLeaves) {
		this.totalLeaves = totalLeaves;
	}
}
