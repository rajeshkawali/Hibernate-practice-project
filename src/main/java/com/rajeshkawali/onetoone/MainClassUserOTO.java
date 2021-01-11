package com.rajeshkawali.onetoone;

import org.hibernate.Session;

import com.rajeshkawali.HibernateConfiguration;

public class MainClassUserOTO {

	public static void main(String[] args) {
		
		UserDetailsOTO user=new UserDetailsOTO();
		user.setUser_name("Rajesh");
		
		VehicleOTO vehicle = new VehicleOTO();
		vehicle.setVehicle_name("Bugati");
		
		user.setVehicle(vehicle);
		Session session = HibernateConfiguration.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();

	}

}
