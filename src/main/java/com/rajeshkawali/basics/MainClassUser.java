package com.rajeshkawali.basics;

import java.util.Date;

import org.hibernate.Session;

import com.rajeshkawali.HibernateConfiguration;

public class MainClassUser {

	public static void main(String[] args) {
		
		UserDetails user=new UserDetails();
		user.setUser_name("Rajesh");
		user.setAge("20");
		user.setDob(new Date());
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicle_name("Honda");
		
		Session session = HibernateConfiguration.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.getTransaction().commit();

	}

}
