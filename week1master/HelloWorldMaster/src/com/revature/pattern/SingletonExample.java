package com.revature.pattern;

public class SingletonExample {
	// Rule 2: private static instance of the class
	private static SingletonExample instance = null;
	
	
	private String messsag = "Hello";
	
	// Rule 1: private Constructor
	private SingletonExample() {
		
	}
	
	// Rule 3: public static accessor method
	public static synchronized SingletonExample getSingletonExample() {
		if(instance == null) {
			instance = new SingletonExample();
		}
		return instance;
	}

	public String getMesssag() {
		return messsag;
	}

	public void setMesssag(String messsag) {
		this.messsag = messsag;
	}
	
	
}
