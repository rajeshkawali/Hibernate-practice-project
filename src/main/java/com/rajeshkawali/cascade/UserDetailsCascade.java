package com.rajeshkawali.cascade;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
//Cascading is Hibernate's way of using transitive persistence model. Transitive persistence is a technique that allows you to propagate persistence to transient (object not yet saved in database) and detached sub-graphs (child objects) automatically. 
//For example, a newly created child object of already persistent parent object should automatically become persistent without a call to save() or persist() methods.
@Entity
public class UserDetailsCascade {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int user_id;
	@Column(name="user_name")
	private String user_name;
	
	@OneToMany(fetch=FetchType.LAZY, targetEntity=VehicleCascade.class, cascade=CascadeType.ALL)
	@JoinTable(name="UserID_VehicleID",joinColumns=@JoinColumn(name="u_id"),inverseJoinColumns=@JoinColumn(name="v_id"))
	private Collection<VehicleCascade> vehicle= new ArrayList<VehicleCascade>();
	
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
	public Collection<VehicleCascade> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<VehicleCascade> vehicle) {
		this.vehicle = vehicle;
	}

}
