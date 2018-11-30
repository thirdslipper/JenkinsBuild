package com.revature.shadow;

public class ShadowingExample {

	public static void main(String[] args) {
		B b = new B();
		System.out.println(((A) b).x + " " + b.method()); //what does this print?
	}

}

class A {
	public int x = 42;

	public int method() {
		return x;
	}
}

class B extends A {
	public int x = 24;

	public int method() {
		return x;
	}
}
