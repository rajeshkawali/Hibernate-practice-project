package com.rajeshkawali.inheritance.mappedsuperclass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
//import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
//import javax.persistence.Table;

/*
In Hibernate, the @MappedSuperclass annotation is used to mark a class as a 
superclass that should be mapped to the database, but is not an entity itself. 
This means that the class will not be represented by its own table in the database, 
but its properties and fields will be inherited by the entity subclasses that extend from it.

A class annotated with @MappedSuperclass cannot be used as the target of an entity relationship, 
and it cannot be queried directly. It serves as a common base class for entities that share common fields or properties.
*/
@MappedSuperclass
@DiscriminatorColumn(name = "EMPLOYMENT_TYPE")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "EMPLOYEE_ID")
	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;

	public Employee() {
	}

	public Employee(Long id, String employeeId, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
