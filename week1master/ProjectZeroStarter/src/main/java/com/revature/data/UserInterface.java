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
	User loggedInUser = null;
	boolean loggedIn = false;

	public UserInterface() {
		//call welcome and other methods, or choose not to
		kb = Input.getInput();
		user = new UserFake();

		//		user.displayUsers();

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
						return false;
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
	//Customers are able to register for an account and sign in
	public void welcome() {
		String input;
		Boolean exit = false;
		while (!exit) {
			input = "";
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
					//					loggedIn = true;
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
			if (loggedIn) {
				exit = !exit;
			}
		}
		userLoggedInUI();
	}
	//non admin, employee, provide user functionality to apply to open account/joint, just have 3 different UI
	//
	public void userLoggedInUI() {
		//check amount of accounts
		//		if (loggedInUser.getAccounts().size() == 0) { potential null pointer
		if (loggedInUser.getAccounts() == null) {
			String input = "";
			boolean done = false;
			while (!done) {
				System.out.println("You currently have no accounts."
						+ "\nWould you like to open an individual or joint account?"
						+ "\n\t1. Individual"
						+ "\n\t2. Joint"
						+ "\n\t3. No Thanks.");
				input = kb.getString().toLowerCase().trim();
				try {
					if (input.contains("individual")) {
						applicationInput("individual");
					} else if (input.equals("joint")) {
						applicationInput("joint");
					} else if (input.length() > 1 && input.startsWith("no")) {
						System.out.println("Thank you, have a nice day!");
					} else if (Integer.parseInt(input) == 1) {
						applicationInput("individual");
					} else if (Integer.parseInt(input) == 2) {
						applicationInput("joint");
					} else if (Integer.parseInt(input) == 3) {
						System.out.println("Thank you, have a nice day!");
					}
					done = !done;
				} catch (NumberFormatException e) {
					System.out.println("Invalid entry");
				}
			}
		}
	}
	public void applicationInput(String type) {
		String accType = "";
		while (!accType.equals("checking") && !accType.equals("savings)") ) {
			System.out.println("1. Checking or"
					+ "\n2. Savings?");
			accType = kb.getString().toLowerCase().trim();
		}
		if (type.equals("joint")) {
			User otherUser = null;
			boolean goBack = false;
			String otherUserName = "";
			while (otherUser == null && !goBack) {
				System.out.println("Who are you going to open your account with? or exit");
				otherUserName = kb.getString();
				otherUser = user.getUser(otherUserName);
				
				if (otherUser != null) {
					user.applyForJointAccount(accType, loggedInUser, otherUser);
				} else if (otherUserName.equals("exit")) {
					goBack = false;
				}
			}
		} else {
			user.applyForAccount(accType, loggedInUser);
		}
	}
}