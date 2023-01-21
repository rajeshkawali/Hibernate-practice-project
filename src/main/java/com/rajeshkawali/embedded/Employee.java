package com.rajeshkawali.embedded;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

//import org.hibernate.annotations.CollectionId;
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Type;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Emp_Id")
	private int empId;
	
	@Column(name="Emp_Name")
	private String empName;
	
	@Column(name="Emp_Salary")
	private String empSalary;
	
	@Column(name="Emp_Joining")
	private String empJoining;
	
	//@EmbeddedId  //This is used to instruct Hibernate that the Employee entity has a composite key of an Address entity.
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name ="houseNo",column=@Column(name="Home_House_No")),
		@AttributeOverride(name ="street",column=@Column(name="Home_street")),
		@AttributeOverride(name ="city",column=@Column(name="Home_city")),
		@AttributeOverride(name ="state",column=@Column(name="Home_state")),
		@AttributeOverride(name ="pinCode",column=@Column(name="Home_pinCode")),
	})
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name ="houseNo",column=@Column(name="Office_House_No")),
		@AttributeOverride(name ="street",column=@Column(name="Office_street")),
		@AttributeOverride(name ="city",column=@Column(name="Office_city")),
		@AttributeOverride(name ="state",column=@Column(name="Office_state")),
		@AttributeOverride(name ="pinCode",column=@Column(name="Office_pinCode")),
	})
	private Address officeAddress;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name="List_Address",joinColumns=@JoinColumn(name="Emp_Id")) // To change id column name and table name
	//@GenericGenerator(name = "hilo-gen", strategy = "hilo")  //Depricated
	//@GenericGenerator(name="sequence-gen",strategy="sequence")
	//@CollectionId(columns = { @Column(name="Address_Id") }, generator = "sequence-gen", type = @Type(type ="long"))
	private Collection<Address> listAddress = new ArrayList<Address>();
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpJoining() {
		return empJoining;
	}
	public void setEmpJoining(String empJoining) {
		this.empJoining = empJoining;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Collection<Address> getListAddress() {
		return listAddress;
	}

	public void setListAddress(Collection<Address> listAddress) {
		this.listAddress = listAddress;
	}
	 
		
}
