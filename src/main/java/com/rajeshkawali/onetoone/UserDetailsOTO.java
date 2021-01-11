package com.rajeshkawali.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserDetailsOTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int user_id;
	@Column(name = "user_name")
	private String user_name;

	@OneToOne(targetEntity = VehicleOTO.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "vehicle_Id", referencedColumnName = "vehicle_id")
	private VehicleOTO vehicle;

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

	public VehicleOTO getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleOTO vehicle) {
		this.vehicle = vehicle;
	}

}
