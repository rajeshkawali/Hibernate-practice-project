package com.rajeshkawali.manytomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class VehicleMTM {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vehicle_id")
	private int vehicle_id;
	@Column(name="vehicle_name")
	private String vehicle_name;
	
	
	@ManyToMany(targetEntity=UserDetailsMTM.class, cascade=CascadeType.ALL)
	@JoinTable(name="VehicleUser", joinColumns=@JoinColumn(name="v_id",referencedColumnName="vehicle_id"),inverseJoinColumns=@JoinColumn(name="u_id",referencedColumnName="user_id"))
	private Collection<UserDetailsMTM> userList = new ArrayList<UserDetailsMTM>();
	
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
	public Collection<UserDetailsMTM> getUserList() {
		return userList;
	}
	public void setUserList(Collection<UserDetailsMTM> userList) {
		this.userList = userList;
	}
}
