package com.revature.util;

import java.util.Scanner;
// Singleton Scanner
public final class Input {
	private static Input instance = null;
	private Scanner kb = null;
	
	private Input() {
		kb = new Scanner(System.in);
	}
	public static synchronized Input getInput() {
		if (instance == null) {
			instance = new Input();
		}
		return instance;
	}
	
	public String getString() {
		String input = kb.nextLine();
		return input;
	}
}
