package com.revature.beans;

public abstract class Animal implements Breathable{
	public String name;

	public String getName() {
		System.out.println("Animal's getName()");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void speak() {
		System.out.println("Hello, I am "+name);
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}	
}
