package com.tap.dao;

import java.util.List;

import com.tap.model.user;

public interface userDAO {

	int addUser(user user);

	user getUser(int userId);

	void updateUser(user user);

	user deleteUser(int userId);

	List<user> getAllUser();
	
	user getUserByEmail(String email);

}
