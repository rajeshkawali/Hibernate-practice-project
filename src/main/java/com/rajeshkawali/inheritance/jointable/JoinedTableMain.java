package com.rajeshkawali.inheritance.jointable;

import java.time.LocalDate;

import org.hibernate.Session;

import com.rajeshkawali.HibernateConfiguration;
// This is the most logical solution, as it mirrors the object structure in the database. In this approach, a separate database table is defined for each of the class in the hierarchy 
// and each table stores only its local attributes. Along with attribute, each table should have an id column and the id is defined in the parent table.
// Each of the entity classes is associated with a database table. Additionally, the parent class’s mapped table contains a discriminatory column. In our demo, 
// join_table_employee contains the employee_type discriminatory column.
public class JoinedTableMain {
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