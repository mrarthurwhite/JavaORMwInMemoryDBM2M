package com.test.db.dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.test.db.model.Address;
import com.test.db.model.User;
import com.test.db.util.HibernateUtil;

public class UserDao {

	public void addUser(User user) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	public void deleteUser(int userid) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			User user = (User) session.load(User.class, new Integer(userid));
			session.delete(user);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	public void updateUser(User user) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			users = session.createQuery("from User").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return users;
	}

	public User getUserById(int userid) {
		User user = null;
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			String queryString = "from User where id = :id";
			Query query = session.createQuery(queryString);
			query.setInteger("id", userid);
			user = (User) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return user;
	}
	
	
	public List<User> printAllUsers(){
		List<User> allUsers = new ArrayList<User>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			// the typical "from Employee" does not seem to be working
			Criteria c = session.createCriteria(User.class);
			Criterion c1 = (Restrictions.like("firstName", "%"));
			c.add(c1);
			allUsers = c.list();		
			System.out.println( getUsersAddresses(allUsers) );
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return allUsers;
		
	}
	
	
	private String getUsersAddresses( List<User> users) {
		String list_of_users_w_addresses = "";
		User user ;
		Address addy;
		for (int i = 0 ; i < users.size();i++) {
			user = users.get(i);
			list_of_users_w_addresses = list_of_users_w_addresses + user.toString();			
			Set<Address> addys = user.getAddresses();
			Iterator addyIt = addys.iterator(); 
			while (addyIt.hasNext()){
				addy = (Address) addyIt.next();
				list_of_users_w_addresses = list_of_users_w_addresses + " " +addy + "\n";
			}
		}
		return list_of_users_w_addresses;
	}
}
