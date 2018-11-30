package com.revature.beans;

public class Dog extends Animal {
	public String name;
	
	public Dog() {
		super();
	}
	
	public void speak() {
		System.out.println("Bark!");
	}

	@Override
	public void breathes() {
		System.out.println("pant!");
	}
}
