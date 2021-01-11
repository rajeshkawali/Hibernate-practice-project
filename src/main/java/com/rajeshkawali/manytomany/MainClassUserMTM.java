package com.rajeshkawali.manytomany;

import org.hibernate.Session;

import com.rajeshkawali.HibernateConfiguration;

public class MainClassUserMTM {

	public static void main(String[] args) {
		
		UserDetailsMTM user=new UserDetailsMTM();
		user.setUser_name("Nivedita");
		
		UserDetailsMTM user1=new UserDetailsMTM();
		user1.setUser_name("Rajesh");
		
		UserDetailsMTM user2=new UserDetailsMTM();
		user2.setUser_name("Kiran");
		
		UserDetailsMTM user3=new UserDetailsMTM();
		user3.setUser_name("Mahesh");
		
		VehicleMTM vehicle = new VehicleMTM();
		vehicle.setVehicle_name("Bugati");
		
		VehicleMTM vehicle1 = new VehicleMTM();
		vehicle1.setVehicle_name("BMW");
		
		VehicleMTM vehicle2 = new VehicleMTM();
		vehicle2.setVehicle_name("Honda");
		
		VehicleMTM vehicle3 = new VehicleMTM();
		vehicle3.setVehicle_name("Maruti");
		
		user.getVehicleList().add(vehicle);
		user1.getVehicleList().add(vehicle1);
		user2.getVehicleList().add(vehicle2);
		user3.getVehicleList().add(vehicle3);
		
		vehicle.getUserList().add(user);
		vehicle1.getUserList().add(user1);
		vehicle2.getUserList().add(user2);
		vehicle3.getUserList().add(user3);
		
		Session session = HibernateConfiguration.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.save(user1);
		session.save(user2);
		session.save(user3);
		
		session.save(vehicle);
		session.save(vehicle1);
		session.save(vehicle2);
		session.save(vehicle3);
		
		session.getTransaction().commit();

	}

}
