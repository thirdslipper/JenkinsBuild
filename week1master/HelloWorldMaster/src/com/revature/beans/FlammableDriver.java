package com.revature.beans;

public class FlammableDriver {
	public static void main(String[] args) {
		Bean b = new Bean();
		burn(b);
		burn(new Dog());
	}
	
	public static void burn(Flammable f) {
		System.out.println("Setting "+f+ " on fire.");
	}
	public static void burn(Object o) {
		if(o instanceof Flammable) {
			System.out.println("Setting "+o+ " on fire.");
		} else {
			throw new RuntimeException("Not flammable.");
		}
	}
}
