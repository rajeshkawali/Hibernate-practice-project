package com.rajeshkawali.mappedby;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserDetailsOTM {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int user_id;
	@Column(name="user_name")
	private String user_name;
	
	// mappedBy - It will not create new table for mapping of two tables id's, instead it will store user_id in Vehicle table. 
	@OneToMany(mappedBy = "user") 
	private Collection<VehicleOTM> vehicle= new ArrayList<VehicleOTM>();
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Collection<VehicleOTM> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<VehicleOTM> vehicle) {
		this.vehicle = vehicle;
	}

}
