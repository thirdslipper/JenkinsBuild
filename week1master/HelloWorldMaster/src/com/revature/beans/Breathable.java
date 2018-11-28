package com.revature.beans;

public interface Breathable {
	// Interfaces cannot have non-public members (java 8 or below)
	// Interface methods are implicitly abstract
	// Abstract method: no method body is provided. Not fully implemented
	
	/*public abstract*/ void breathes();
	
	// As of Java 8: Interfaces can have default implementations
	default void hold() {
		System.out.println("Holding breath.");
	}
	
	// As of Java 8: Interfaces can have member variables
	// Interface variables are implicitly public, static, and final
	String AIR = "Oxygen";
}
