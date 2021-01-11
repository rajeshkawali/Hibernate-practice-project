package com.rajeshkawali.manytomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class UserDetailsMTM {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int user_id;
	@Column(name="user_name")
	private String user_name;
	
	@ManyToMany(targetEntity = VehicleMTM.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="userList")
	//@JoinTable(name="UserID_VehicleID",joinColumns=@JoinColumn(name="u_id"),inverseJoinColumns=@JoinColumn(name="v_id"))
	private Collection<VehicleMTM> vehicleList = new ArrayList<VehicleMTM>();
	
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
	public Collection<VehicleMTM> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(Collection<VehicleMTM> vehicleList) {
		this.vehicleList = vehicleList;
	}
}
