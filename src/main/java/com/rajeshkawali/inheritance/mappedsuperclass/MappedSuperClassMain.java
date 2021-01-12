package com.rajeshkawali.inheritance.mappedsuperclass;

import java.time.LocalDate;

import org.hibernate.Session;

import com.rajeshkawali.HibernateConfiguration;
// In mapped superclass strategy parent class isn’t mapped to any database table. However, the database table mapping 
// to child class contains all the attributes of the parent class.The subclass cannot omit the superclass’s attributes.
// This makes the classes tightly coupled. Also, they can’t be queried or persisted separately.
public class MappedSuperClassMain {
	public static void main(String[] args) {
		
		PermanentEmployee permanentEmployee = new PermanentEmployee();
		permanentEmployee.setEmployeeId("EMP-001");
		permanentEmployee.setFirstName("Mahesh");
		permanentEmployee.setLastName("Koli");
		permanentEmployee.setEmail("mahesh@koli.com");
		permanentEmployee.setCostCenter("AAA-111");
		permanentEmployee.setTotalLeaves(12.50F);
		permanentEmployee.setStartingDate(LocalDate.parse("2018-03-10"));

		ContractEmployee contractEmployee = new ContractEmployee();
		contractEmployee.setEmployeeId("EMP-002");
		contractEmployee.setFirstName("Rajesh");
		contractEmployee.setLastName("Kawali");
		contractEmployee.setEmail("rajeshkawali@gmail.com");
		contractEmployee.setAgencyName("CONTRACT AGENCY");
		contractEmployee.setContractStartDate(LocalDate.parse("2018-07-12"));
		contractEmployee.setContractEndDate(LocalDate.parse("2019-02-22"));

		Session session = HibernateConfiguration.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(permanentEmployee);
		session.save(contractEmployee);
		session.getTransaction().commit();
		session.close();
	}
}