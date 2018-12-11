package com.revature.data;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;

public class UserFake implements UserDao{
	private static List<User> users = new ArrayList<User>();
	private static AccountDao ad = new AccountFake();
	{
		User u = new User();
		u.setId(1);
		u.setAccounts(new ArrayList<Account>());
		u.getAccounts().add(ad.getAccount(1));
		u.getAccounts().add(ad.getAccount(2));
		u.setUsername("bob");
		u.setPassword("marley");
		users.add(u);

		u = new User();
		u.setId(2);
		u.setAccounts(new ArrayList<Account>());
		u.getAccounts().add(ad.getAccount(3));
		u.getAccounts().add(ad.getAccount(4));
		u.setUsername("derrek");
		u.setPassword("chris");
		users.add(u);

		u = new User();
		u.setId(3);
		u.setAccounts(new ArrayList<Account>());
		u.getAccounts().add(ad.getAccount(5));
		u.getAccounts().add(ad.getAccount(6));
		u.setUsername("david");
		u.setPassword("david");
		users.add(u);

		u = new User();
		u.setId(4);
		u.setAccounts(new ArrayList<Account>());
		u.getAccounts().add(ad.getAccount(7));
		u.getAccounts().add(ad.getAccount(8));
		u.setUsername("steven");
		u.setPassword("mateusz");
		users.add(u);

		u = new User();
		u.setId(5);
		u.setAccounts(new ArrayList<Account>());
		u.getAccounts().add(ad.getAccount(9));
		u.getAccounts().add(ad.getAccount(10));
		u.setUsername("Tyler");
		u.setPassword("warren");
		users.add(u);
	}
	public User login(String username, String password) {
		for(User u : users) {
			if(u.getUsername().equals(username)&&u.getPassword().equals(password))
				return u;
		}
		return null;
	}

	public User getUser(String username) {
		for(User u : users) {
			if(u.getUsername().equals(username))
				return u;
		}
		return null;
	}

	public List<User> getUsers() {
		return users;
	}

	public void saveUser(User u) {
		users.add(u);
		System.out.println("User successfully registered!");
	}

	public void updateUser(User u) {
		// This is unnecessary without a real persistence layer.
	}

	public void deleteUser(User u) {
		users.remove(u);
	}
	public void displayUsers() {
		for (User u : users) {
			System.out.println(u.getUsername());
		}
	}
}
