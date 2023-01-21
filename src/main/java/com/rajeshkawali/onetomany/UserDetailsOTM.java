package com.rajeshkawali.onetomany;

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
/*
In Hibernate, the "FetchType" enum is used to specify the fetching strategy for a relationship between entities. 
There are two values in the FetchType enum: LAZY and EAGER.

FetchType.LAZY: When a relationship is marked as LAZY, 
it means that the associated entities will not be automatically loaded when the parent entity is loaded. 
Instead, the associated entities will be loaded only when they are explicitly accessed by the application. 
This is useful when an entity has a lot of associated entities that are 
not needed in most cases, as it can improve performance by loading only the data that is actually needed.

FetchType.EAGER: When a relationship is marked as EAGER, it means that the associated entities will be 
automatically loaded when the parent entity is loaded. This means that the associated entities will 
always be available, even if they are not explicitly accessed by the application. 
This can be useful when an entity has a small number of associated entities that are always needed, 
but it can also lead to poor performance if the associated entities are large or if there are many of them.
*/
@Entity
public class UserDetailsOTM {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int user_id;
	@Column(name="user_name")
	private String user_name;
	
	@OneToMany(fetch=FetchType.LAZY, targetEntity=VehicleOTM.class, cascade=CascadeType.ALL)
	@JoinTable(name="UserID_VehicleID",joinColumns=@JoinColumn(name="u_id"),inverseJoinColumns=@JoinColumn(name="v_id"))
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
