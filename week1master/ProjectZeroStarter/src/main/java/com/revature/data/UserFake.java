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
		
		u = new User();
		u.setId(6);
		u.setAccounts(new ArrayList<Account>());
		u.setUsername("notbob");
		u.setPassword("marley");
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
	public void applyForAccount(String accType, User u) {
		Account newAccount = new Account();
		newAccount.setType(accType);
		if (u.getPendingAccounts() == null) {
			System.out.println("pending: " + u.getPendingAccounts().size());
			List<Account> newApplication = new ArrayList<Account>();
			u.setPendingAccounts(newApplication);
		}
		u.getPendingAccounts().add(newAccount);
		System.out.println();
		System.out.println(u.getUsername() + ", you have applied for individual " + accType + " account successfully.");
	}
	public void applyForJointAccount(String accType, User u, User otherU) {
		List<Account> uPending = u.getPendingAccounts();
		if (uPending == null) {
			uPending = new ArrayList<Account>();
			u.setPendingAccounts(uPending);
		}
		List<Account> otherUPending = otherU.getPendingAccounts();
		if (otherUPending == null) {
			otherUPending = new ArrayList<Account>();
			otherU.setPendingAccounts(otherUPending);
		}
		Account newAcc = new Account();
		newAcc.setId(ad.getAccounts().size());
		newAcc.setBalance(0.0);
		newAcc.setJoint(true);
		newAcc.setType(accType);
		
		uPending.add(newAcc);
		otherUPending.add(newAcc);	
		System.out.println("Applied for joint " + accType + " account with " + otherU.getUsername() + " successfully.");
	}	
/*	public void displayUsers() {
		for (User u : users) {
			System.out.println(u.getUsername());
		}
	}*/
}
