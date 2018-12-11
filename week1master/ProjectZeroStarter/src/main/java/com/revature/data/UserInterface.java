package com.revature.data;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Address;
import com.revature.beans.User;
import com.revature.util.Input;

public class UserInterface {
	Input kb = null;
	UserFake user = null;
	AccountFake acc = null;
	User loggedInUser = null;
	boolean loggedIn = false;

	public UserInterface() {
		//call welcome and other methods, or choose not to
		kb = Input.getInput();
		user = new UserFake();
		
		user.displayUsers();
		
		welcome();
	}
	//null accounts in user, empty values, write a method to check for valid input?
	public void registerUser() {
		User newUser = new User();
		System.out.println("Enter your name: ");
		newUser.setName(kb.getString());
		System.out.println("Enter your email: ");
		newUser.setEmail(kb.getString());
		System.out.println("Enter your Phone: ");
		newUser.setPhone(kb.getString());

		Address add = new Address();
		System.out.println("For your address: \n\tStreet 1: ");
		add.setStreet1(kb.getString());
		System.out.println("\tStreet2: ");
		add.setStreet2(kb.getString());
		System.out.println("\tCity: ");
		add.setCity(kb.getString());
		// can add error-checking for 2 letter state? or check map to all 50
		System.out.println("\tState: ");
		add.setState(kb.getString());
		System.out.println("\tZip: ");
		add.setZip(kb.getString());

		// check userfake list for pre-existing username
		System.out.println("For your account login: \n\tUsername: ");
		newUser.setUsername(kb.getString());
		System.out.println("\tPassword: ");
		newUser.setPassword(kb.getString());

		newUser.setAddress(add);
		int id = user.getUsers().size();
		newUser.setId(id);
		newUser.setAdmin(false);
		newUser.setEmployee(false);
		user.saveUser(newUser);
	}
	public boolean loginUser() {
		boolean stopLogin = false;
		while (!loggedIn && !stopLogin) {
			String username = "", password = "", retry = "";
			System.out.println("Username: ");
			username = kb.getString().toLowerCase().trim();
			System.out.println("Password: ");
			password = kb.getString();

			loggedInUser = user.login(username, password);
		
			//potential control flow errors recalling method login()
			if (loggedInUser == null) {
				System.out.println("Login failed, retry?"
						+ "\n\t1. Yes"
						+ "\n\t2. No");
				retry = kb.getString();
				try {
					 if (retry.toLowerCase().trim().equals("no") || Integer.parseInt(retry) == 2) {
						stopLogin = !stopLogin;
					}
				} catch (NumberFormatException e) {
					System.out.println("input error");
				}
			} else {
				loggedIn = true;
			}
		}
		if (loggedIn)
			return true;
		return false;
		 
	}
	public void applyForAccount() { 

	}
	public void applyForJointAccount() { 

	}
	//add exit option?
	public void welcome() {
		String input = "";
		System.out.println("Welcome to the bank!"
				+ "\nWhat would you like to do?"
				+ "\n1. Register"
				+ "\n2. Login");
		input = kb.getString();
		try {
			if (input.toLowerCase().trim().equals("register")){
				registerUser();
			} else if (input.toLowerCase().trim().equals("login")) {
				loggedIn = loginUser();
			} else if (Integer.parseInt(input) == 1) {
				registerUser();
			} else if (Integer.parseInt(input) == 2) {
				loggedIn = loginUser();
			} else {
				System.out.println("Invalid input.");
				welcome();
			}

		} catch (NumberFormatException e) {
			System.out.println("input error");
			//e.printStackTrace();
			welcome();
		}

	}
}
