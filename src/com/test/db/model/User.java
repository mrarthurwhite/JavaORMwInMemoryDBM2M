package com.test.db.model;

import java.util.HashSet;
import java.util.Set;

public class User {

	private int userid;
	private String firstName;
	private Set<Address> addresses = new HashSet<Address>(0);
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> address) {
		this.addresses = address;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstName=" + firstName
				+  "]";
	}
	
	
}
