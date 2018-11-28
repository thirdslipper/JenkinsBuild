package com.revature.hello;

public class Method {
	public static final int CONSTANT_VALUE = 5;
	
	public static void main(String[] args) {
		Method.method();
		method();
		Method.method("pizza");
		Method.method("pizza", 4);
		Method.method(4);
	}

	public static void method() {
		System.out.println("method() called.");
	}	
	private static void method(String string) {
		System.out.println("method(String) called with argument: "+string);
	}
	public static void method(String hello, int i) {
		System.out.println("method(String, int) called with arguments "+hello +" "+i);
	}
	public static void method(int i) {
		System.out.println("method(int) called with argument "+i);
	}
}
