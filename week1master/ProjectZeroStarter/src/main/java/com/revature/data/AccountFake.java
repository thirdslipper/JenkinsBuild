package com.revature.data;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;

public class AccountFake implements AccountDao{
	private static List<Account> accounts = new ArrayList<Account>();
	static {
		Account a;
		for(int i = 1; i<11; i++) {
			a = new Account();
			a.setId(i);
			a.setBalance(100.0);
			if(i%2==0)
				a.setType("Savings");
			else
				a.setType("Checking");
			accounts.add(a);
		}
	}
	public Account getAccount(int id) {
		for(Account a : accounts) {
			if(a.getId()==id)
				return a;
		}
		return null;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void saveAccount(Account a) {
		accounts.add(a);
	}

	public void updateAccount(Account a) {
		// Due to the nature of this dao, this method does nothing.
	}

	public void deleteAccount(Account a) {
		accounts.remove(a);
	}

}
