package com.rajeshkawali.mappedby;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/*
In Hibernate, the "mappedBy" attribute is used to specify the property in 
the associated class that is the owner of a relationship defined 
using the @OneToOne, @OneToMany, or @ManyToMany annotations.

When the mappedBy attribute is specified on one side of a relationship, 
it tells Hibernate that the other side of the relationship is the owner 
and should be responsible for managing the association. 
Hibernate will then use the value of the mappedBy attribute to 
determine which property in the associated class represents the foreign key.
*/
@Entity
public class UserDetailsOTM {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int user_id;
	@Column(name = "user_name")
	private String user_name;

	/*
	 In Hibernate, the @OneToMany annotation is used to define a one-to-many
	 relationship between two entities.
	 
	 In the example you provided, @OneToMany(mappedBy = "user") is used to
	 indicate that the relationship is one-to-many, where one user entity is
	 associated with many entities of the class that has this annotation. The
	 mappedBy attribute is used to specify the property of the associated class
	 that is the owner of the relationship.
	 */
	// mappedBy - It will not create new table for mapping of two tables id's, instead it will store user_id in Vehicle table.
	@OneToMany(mappedBy = "user")
	private Collection<VehicleOTM> vehicle = new ArrayList<VehicleOTM>();

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
