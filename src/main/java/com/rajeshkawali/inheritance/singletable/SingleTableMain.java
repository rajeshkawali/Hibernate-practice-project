package com.rajeshkawali.inheritance.singletable;

import java.time.LocalDate;

import org.hibernate.Session;

import com.rajeshkawali.HibernateConfiguration;
import com.rajeshkawali.inheritance.tableperclass.ContractEmployee;
import com.rajeshkawali.inheritance.tableperclass.PermanentEmployee;
//This is typically the best inheritance strategy. In this strategy, whole inheritance hierarchy’s data is stored in a single table. 
//A discriminator column is used to determine to which class the row belongs.All the Contract and Permanent employee details are stored in the employee table and they are differentiated by discriminator column employee_type. 
//Below is the domain class structure. As you see only the parent class has a database table associated with it and hibernate automatically creates a discriminatory column employee_type for us.

public class SingleTableMain {
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
