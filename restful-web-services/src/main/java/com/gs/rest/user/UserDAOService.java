package com.gs.rest.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
	
	
	
	private static List<User>  userList = new ArrayList<User>();
	static{
		userList.add(new User(1,"sarwar1",new Date()));
		userList.add(new User(2,"sarwar2",new Date()));
		userList.add(new User(3,"sarwar3",new Date()));
	}
	private static int userCount = 3 ;
	
	//find all user 
	public List<User> findAll(){
		return userList ;
	}
	//save u user 
	public User Save(User user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		userList.add(user);
		return user;
	}
	//find u ser 
	public User findOne(int id) {
		for (User user : userList) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	/*
	 * //find u ser //wrong implementation public User delete(int id) { for (User
	 * user : userList) { if (user.getId() == id) { userList.remove(user); return
	 * user; } } return null; }
	 */
		//find u ser 
		//wrong implementation
			public User deleteById(int id) {
				Iterator<User> iterator = userList.iterator();
				while(iterator.hasNext()) {
					User user = iterator.next();
					if (user.getId() == id) {
						iterator.remove();
						return user;
					}
				}
				return null;
			}
	
}
