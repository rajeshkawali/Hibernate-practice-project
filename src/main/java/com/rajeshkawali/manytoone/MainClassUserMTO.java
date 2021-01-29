package com.rajeshkawali.manytoone;

import org.hibernate.Session;

import com.rajeshkawali.HibernateConfiguration;

public class MainClassUserMTO {

	public static void main(String[] args) {
		
		UserDetailsMTO user=new UserDetailsMTO();
		user.setUser_name("Vidya");
		
		UserDetailsMTO user1=new UserDetailsMTO();
		user1.setUser_name("Rajesh");
		
		UserDetailsMTO user2=new UserDetailsMTO();
		user2.setUser_name("Kiran");
		
		UserDetailsMTO user3=new UserDetailsMTO();
		user3.setUser_name("Mahesh");
		
		UserDetailsMTO user4=new UserDetailsMTO();
		user4.setUser_name("Keshav");
		
		VehicleMTO vehicle = new VehicleMTO();
		vehicle.setVehicle_name("Bugati");
		
		VehicleMTO vehicle1 = new VehicleMTO();
		vehicle1.setVehicle_name("BMW");
		
		VehicleMTO vehicle2 = new VehicleMTO();
		vehicle2.setVehicle_name("Honda");
		
		VehicleMTO vehicle3 = new VehicleMTO();
		vehicle3.setVehicle_name("Maruti");
		
		user.setVehicle(vehicle);
		user1.setVehicle(vehicle1);
		user2.setVehicle(vehicle2);
		user3.setVehicle(vehicle3);
		user4.setVehicle(vehicle3);
		
		
		Session session = HibernateConfiguration.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.save(user1);
		session.save(user2);
		session.save(user3);
		session.save(user4);
		session.getTransaction().commit();


	}

}
