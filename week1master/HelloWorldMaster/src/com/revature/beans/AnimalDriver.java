package com.revature.beans;

public class AnimalDriver {
	public static void main(String[] args) {
		//animal();
		//dog();
		breathing();
	}

	private static void breathing() {
		Dog d = new Dog();
		d.breathes();
		Breathable b = d;
		b.breathes();
	}

	private static void dog() {
		Dog d = new Dog();
		d.setName("Richard");
		d.speak();
		Animal a = d;
		a.speak();
		Object o = a;
		d= (Dog) o;
		d.speak();
		System.out.println(d.getName());
		System.out.println(d.name);
		System.out.println(a.name);
	}

	private static void animal() {
//		Animal a = new Animal();
//		a.speak();
//		a.setName("Richard");
//		a.speak();
//		a.name="Milton";
//		a.speak();
	}
}
