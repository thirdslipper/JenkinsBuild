package com.revature.data;

import java.util.List;

import com.revature.beans.Account;

public interface AccountDao {
	Account getAccount(int id);
	List<Account> getAccounts();
	void saveAccount(Account a);
	void updateAccount(Account a);
	void deleteAccount(Account a);
	boolean withdraw(int amount);
	boolean deposit(int amount);
	boolean transferFunds(int amount, Account a);
}
