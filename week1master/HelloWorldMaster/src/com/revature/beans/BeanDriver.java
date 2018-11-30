package com.revature.beans;

public class BeanDriver {
	public static void main(String[] args) {
		Bean b = new Bean();
		System.out.println(b);
		b.setStrain("Pinto");
		System.out.println(b);
		System.out.println(b.getStrain());
		Bean b2 = new Bean();
		b2.setStrain("Pinto");
		System.out.println("b.equals(b2): "+b.equals(b2));
		System.out.println("b==b2: "+(b==b2));
	}
}
