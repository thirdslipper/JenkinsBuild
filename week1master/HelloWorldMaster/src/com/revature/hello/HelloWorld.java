package com.revature.hello;

public class HelloWorld {
	public static void main(String[] bob) {
		System.out.println("Hello World");

		HelloWorld h = new HelloWorld();
		HelloWorld h2 = h;
		System.out.println(h);
	}

	private String message;

	/*
	 * If you provide no other constructor for a class, Java writes a default
	 * no-arguments constructor.
	 * 
	 * public HelloWorld() { super(); }
	 */
	public HelloWorld() {
		this("Hello, World.");
	}

	public HelloWorld(String message) {
		// implicit call to super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorld [message=" + message + "]";
	}
}
