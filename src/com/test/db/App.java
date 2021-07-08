package com.test.db;

import java.util.HashSet;
import java.util.Set;

import com.test.db.dao.UserDao;
import com.test.db.model.User;
import com.test.db.model.Address;
public class App {

	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		// Create new user
		User user = new User();
			user.setFirstName("Arthur");
		// Create addresses
			Set<Address> addresses = new HashSet<Address>();
			addresses.add(new Address("1 Prosperity Lane, Bergen, Norway"));
			addresses.add(new Address("1 Success Dr, London, UK"));
			addresses.add(new Address("1 Victory Lane, Zurich, Switzerland"));
		user.setAddresses(addresses);
		// add the user to the DB
		userDao.addUser(user);

		// Get all users
		 userDao.printAllUsers();

	}
}
