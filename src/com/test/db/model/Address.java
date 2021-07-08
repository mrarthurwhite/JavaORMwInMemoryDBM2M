package com.test.db.model;

import java.util.HashSet;
import java.util.Set;



/**
 * 	This class contains the course details.
 * 	
 */
public class Address implements java.io.Serializable {
	


	private long addressId;
	private String address;
	private Set<User> users = new HashSet<User>(0);

	public Address() {
	}

	public Address(String addy) {
		this.address = addy;
	}

	public long getAddressId() {return this.addressId;	}
	public void setAddressId(long addressId) {	this.addressId = addressId;}

	public String getAddress() {return this.address;}
	public void setAddress(String st) {	this.address = st;}


	/**
	 * @return the users
	 */
	public Set<User> getUsers() {	return users;}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {	this.users = users;}

	@Override
	public String toString() {
		return "Address [address=" + address +  "]";
	}
}
