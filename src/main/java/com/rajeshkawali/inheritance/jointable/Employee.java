package com.rajeshkawali.inheritance.jointable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/*
In Hibernate, the @Inheritance annotation is used to specify the inheritance strategy for an entity class hierarchy. 
The strategy attribute of the @Inheritance annotation is used to specify the type of inheritance strategy.

When the strategy attribute is set to InheritanceType.JOINED, 
it means that the inheritance strategy used is the "joined" strategy. 
This strategy maps the class hierarchy to multiple tables, one for each class in the hierarchy, 
and each table has a primary key column that is shared by all the tables in the hierarchy. 
Each table also has columns for the properties defined in its corresponding class, 
as well as a foreign key column that references the primary key of the table of the superclass.
*/
@Entity(name = "joinedTableEmployee")
@Table(name = "JOIN_TABLE_EMPLOYEE")
@Inheritance(strategy = InheritanceType.JOINED)
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
