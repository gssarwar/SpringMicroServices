package com.gs.rest.userJPA;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOServiceJPA {
	
	
	
	private static List<UserJPA>  userList = new ArrayList<UserJPA>();
	static{
		userList.add(new UserJPA(1,"sarwar1",new Date()));
		userList.add(new UserJPA(2,"sarwar2",new Date()));
		userList.add(new UserJPA(3,"sarwar3",new Date()));
	}
	private static int userCount = 3 ;
	
	//find all user 
	public List<UserJPA> findAll(){
		return userList ;
	}
	//save u user 
	public UserJPA Save(UserJPA user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		userList.add(user);
		return user;
	}
	//find u ser 
	public UserJPA findOne(int id) {
		for (UserJPA user : userList) {
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
			public UserJPA deleteById(int id) {
				Iterator<UserJPA> iterator = userList.iterator();
				while(iterator.hasNext()) {
					UserJPA user = iterator.next();
					if (user.getId() == id) {
						iterator.remove();
						return user;
					}
				}
				return null;
			}
	
}
