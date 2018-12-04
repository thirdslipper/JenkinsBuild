package com.revature.pattern;

public class FactoryExample {
	// A factory provides use with an instance of an interface such that we do not need
	// to know the implementation class of said interface.
	public Cheesable getCheesable() {
		return new Cracker();
	}
}
