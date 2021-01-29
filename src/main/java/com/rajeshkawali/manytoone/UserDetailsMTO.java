package com.rajeshkawali.manytoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class UserDetailsMTO {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequ_id")
	@SequenceGenerator(name = "sequ_id", sequenceName = "sequ_id",initialValue= 1, allocationSize = 1)
	@Column(name="user_id")
	private int user_id;
	@Column(name="user_name")
	private String user_name;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=VehicleMTO.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "vehicleID", referencedColumnName = "vehicle_id", nullable = false, insertable = true, updatable = true)
	//@NotFound(action = NotFoundAction.IGNORE) // If this object is not found just ignore/throw exception it
	private VehicleMTO vehicle;
	
	
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
	public VehicleMTO getVehicle() {
		return vehicle;
	}
	public void setVehicle(VehicleMTO vehicle) {
		this.vehicle = vehicle;
	}
	
}
