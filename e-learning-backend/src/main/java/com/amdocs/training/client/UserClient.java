package com.amdocs.training.client;

import java.util.ArrayList;
import java.util.List;

import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.User;
public class UserClient {
public static void main(String[] args) {
	
		//List<User> users=new ArrayList<>();
	
		User user=new User();
		user.setUser_id(101);
		user.setPassword("rahul");
		UserDAO dao = new UserDAOImpl();
		boolean x=dao.isValidUser(user);
		
//		User user = new User(102, "Rahul", 9586234712L,"rahul@gmail.com","banglore","2021-12-21","rahul","img1.jpg");
//		if(dao.saveUser(user)) {
//		System.out.println("User Added Successfully");
//		}
//		else {
//		System.out.println("Error Cannot Insert");
//		}
//		user.forEach((n)-> System.out.println(n));
		System.out.println(x);
	}
}