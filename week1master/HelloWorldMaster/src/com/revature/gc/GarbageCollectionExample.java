package com.revature.gc;

public class GarbageCollectionExample {
	public static void main(String[] args) {
		Garbage g = null;
		for(int i = 0; i<5000; i++) {
			g = new Garbage(i+"");
		}
		System.out.println("kept"+g);
		//System.gc();
	}
}
