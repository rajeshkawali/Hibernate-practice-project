package com.rajeshkawali.cascade;

import org.hibernate.Session;

import com.rajeshkawali.HibernateConfiguration;

public class MainClassUserCascade {

	public static void main(String[] args) {
		// cascade=CascadeType.ALL --> When we saving user and Vehicle just we are saving only user object not Vehicle, 
		// If we want to save vehicle details with user object then use Cascade.
		// Which will save with user object.
		UserDetailsCascade user=new UserDetailsCascade();
		user.setUser_name("Kiran");
		
		VehicleCascade vehicle = new VehicleCascade();
		vehicle.setVehicle_name("Bugati");
		
		VehicleCascade vehicle2 = new VehicleCascade();
		vehicle2.setVehicle_name("BMW");
		
		VehicleCascade vehicle3 = new VehicleCascade();
		vehicle3.setVehicle_name("Maruti");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		user.getVehicle().add(vehicle3);
		
		Session session = HibernateConfiguration.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(user); // With user object, vehicle object also storing by help of cascade.
		session.getTransaction().commit();

	}

}
