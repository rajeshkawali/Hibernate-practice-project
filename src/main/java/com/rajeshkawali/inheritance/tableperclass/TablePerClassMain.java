package com.rajeshkawali.inheritance.tableperclass;

import java.time.LocalDate;

import org.hibernate.Session;

import com.rajeshkawali.HibernateConfiguration;
// In table per class strategy, each concrete class has an associated database table and stores 
// all the attributes in the class hierarchy to store all the attributes of that class and its parent class.
// In table per class hierarchy, each class in the hierarchy has a mapping database table. Contract employee details are 
// stored in table_per_class_contract_employee and permanent employee details are stored in table_per_class_permanent_employee table respectively.
// Since they are stored in different tables, there is no need to have a discriminator column.
// Less performant as a result of additional joins. Some JPA providers even don’t support this strategy. 
// Sometimes ordering is quite tricky as ordering is done based on the class and later by the ordering criteria
public class TablePerClassMain {
	public static void main(String[] args) {
		
		Employee employee = new Employee();
		employee.setFirstName("Rajesh");
		employee.setLastName("Kawali");
		employee.setEmail("rajesh@gmail.com");
		employee.setEmployeeId("EMP-007");
		
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
		session.persist(employee);
		session.persist(permanentEmployee);
		session.persist(contractEmployee);
		session.getTransaction().commit();
		session.close();
	}
}
