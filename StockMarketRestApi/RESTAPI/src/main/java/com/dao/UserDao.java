package com.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jvnet.hk2.annotations.Service;

import com.dto.User;
import com.db.HibernateTemplate;

@Service
public class UserDao {
	private SessionFactory factory = null;

	public User getResByUserPass(String loginId,String password) {

		return (User)HibernateTemplate.getObjectByUserPass(loginId,password);
	}

	public int register(User user) {
		return HibernateTemplate.addObject(user);
	}

	public List<User> getAllUsers() {
		List<User> residents=(List)HibernateTemplate.getObjectListByQuery("From User");
		System.out.println("Inside All Users ..."+residents);
		return residents;	
	}

	public User getResident(int id) {
		return (User)HibernateTemplate.getObject(User.class,id);
	}


	public User getUser(String email,String password) {
		return (User)HibernateTemplate.getObjectByUserPass(email,password);
	}
	public void getResidents(int loginId) {
		String query= "from Resident where loginId = :loginId";

		System.out.println("get Residents is called...");
		List<Object> obj = (List<Object>) HibernateTemplate.getObjectListByQuery(query);
		System.out.println("Testing get Residents :" + obj); 
		for(Object res: obj){
			User resident = (User)res;
			System.out.println(resident.getName());
		}
	}

	public User getResByloginId(String loginId) {
		System.out.println((User)HibernateTemplate.getObjectByloginId(loginId));
		return (User)HibernateTemplate.getObjectByloginId(loginId);
	}
}
