package com.rajeshkawali.embedded;

import org.hibernate.Session;
import com.rajeshkawali.HibernateConfiguration;



public class MainClass {

	public static void main(String[] args) {
		System.out.println("In Main class");
		
		Employee emp=new Employee();
		emp.setEmpName("Rajesh");
		emp.setEmpJoining("04-01-2020");
		emp.setEmpSalary("47500");
		
		Address addr=new Address();
		addr.setHouseNo(14);
		addr.setStreet("Borivali");
		addr.setCity("Mumbai");
		addr.setState("Maharashtra");
		addr.setPinCode("400066");
		emp.setOfficeAddress(addr);
		
		Address addr2=new Address();
		addr2.setHouseNo(16);
		addr2.setStreet("Street lines");
		addr2.setCity("Bangalore");
		addr2.setState("Karnataka");
		addr2.setPinCode("400033");
		emp.setHomeAddress(addr2);
		
		emp.getListAddress().add(addr);
		emp.getListAddress().add(addr2);
		System.out.println("value of name==>"+emp.getEmpName());
		System.out.println("value of salary==>"+emp.getEmpSalary());
		System.out.println("value of joining==>"+emp.getEmpJoining());
		
		
		Session session = HibernateConfiguration.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		
		
		// This is used to fetch the proxy object after closing the session (@ElementCollection(fetch = FetchType.EAGER))
		emp = null;
		Session session2 = HibernateConfiguration.getSessionFactory().getCurrentSession();
		session2.beginTransaction();
		emp = (Employee) session2.get(Employee.class, 1);
		System.out.println(emp.getListAddress().size());
		
		/* Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		 StandardServiceRegistryBuilder regBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		 SessionFactory sessionFactory = configuration.buildSessionFactory(regBuilder.build());
		 Session session = sessionFactory.openSession();
		 session.beginTransaction();
		 session.save(emp);
		 session.getTransaction().commit();
		 session.close();*/
		
		
		
	}

}
