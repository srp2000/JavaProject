package com.amdocs.training.dao;

import java.util.List;

import com.amdocs.training.model.User;

public interface UserDAO {
	boolean saveUser(User user);
	List<User> viewUser();
	User getUserById(int a);
	int deleteUser(int a);
	boolean isValidUser(User user);
}
