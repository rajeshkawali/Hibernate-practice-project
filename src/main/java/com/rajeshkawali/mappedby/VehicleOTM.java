package com.rajeshkawali.mappedby;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class VehicleOTM {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="vehicle_id")
	private int vehicle_id;
	@Column(name="vehicle_name")
	private String vehicle_name;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserDetailsOTM user;
	
	public int getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getVehicle_name() {
		return vehicle_name;
	}
	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}
	public UserDetailsOTM getUser() {
		return user;
	}
	public void setUser(UserDetailsOTM user) {
		this.user = user;
	}
}
