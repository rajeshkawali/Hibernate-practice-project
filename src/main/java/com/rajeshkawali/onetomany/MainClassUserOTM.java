package com.rajeshkawali.onetomany;

import org.hibernate.Session;

import com.rajeshkawali.HibernateConfiguration;

public class MainClassUserOTM {

	public static void main(String[] args) {
		
		UserDetailsOTM user=new UserDetailsOTM();
		user.setUser_name("Kiran");
		
		VehicleOTM vehicle = new VehicleOTM();
		vehicle.setVehicle_name("Bugati");
		
		VehicleOTM vehicle2 = new VehicleOTM();
		vehicle2.setVehicle_name("BMW");
		
		VehicleOTM vehicle3 = new VehicleOTM();
		vehicle3.setVehicle_name("Maruti");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		user.getVehicle().add(vehicle3);
		
		Session session = HibernateConfiguration.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();

	}

}
