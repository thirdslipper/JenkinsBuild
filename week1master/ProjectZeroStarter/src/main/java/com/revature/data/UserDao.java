package com.revature.data;

import java.util.List;

import com.revature.beans.User;

public interface UserDao {
	User login(String username, String password);
	User getUser(String username);
	List<User> getUsers();
	void saveUser(User u);
	void updateUser(User u);
	void deleteUser(User u);
}
