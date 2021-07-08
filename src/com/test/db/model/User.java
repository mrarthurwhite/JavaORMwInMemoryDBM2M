package com.test.db.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class User {

	private int userid;
	private String firstName;
	private Set<Address> addresses = new HashSet<Address>(0);
	
	public int getUserid() {return userid;}
	public void setUserid(int userid) {	this.userid = userid;}
	
	public String getFirstName() {return firstName;	}
	public void setFirstName(String firstName) {this.firstName = firstName;	}
	
	public Set<Address> getAddresses() {return this.addresses;}
	public void setAddresses(Set<Address> address) {this.addresses = address;}
	
	public String allAddresses() {
		String addresses="";
		Iterator<Address> current_address = this.addresses.iterator(); 
		while (current_address.hasNext()){
			addresses += " \t" +current_address.next() + "\n";
		}
		return addresses;
	}
	
	@Override
	public String toString() {
		String user= "User [userid=" + userid + ", firstName=" + firstName+  "]\n";
		return user + allAddresses();
	}
	
	
}
