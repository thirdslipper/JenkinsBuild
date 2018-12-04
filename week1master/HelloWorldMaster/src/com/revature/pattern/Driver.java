package com.revature.pattern;

public class Driver {

	public static void main(String[] args) {
		//singleton();
		factory();
	}

	private static void factory() {
		FactoryExample factory = new FactoryExample();
		Cheesable cheesable = factory.getCheesable();
		cheesable.spreadCheese("Brie");
	}

	private static void singleton() {
		//SingletonExample s = new SingletonExample();
		SingletonExample s1 = SingletonExample.getSingletonExample();
		SingletonExample s2 = SingletonExample.getSingletonExample();
		
		System.out.println(s1==s2);
		System.out.println(s1.getMesssag());
		System.out.println(s2.getMesssag());
		
		s1.setMesssag("Goodbye");
		System.out.println(s1.getMesssag());
		System.out.println(s2.getMesssag());
		
		SingletonExample s3 = SingletonExample.getSingletonExample();
		System.out.println(s3.getMesssag());
	}

}
