package com.revature.finalexample;

import com.revature.beans.Bean;

public class FinalExample {
	public static void main(String[] args) {

		B b = new B();
		C c = new C();
		
		b.method();
		c.method();
		
		A a = new A();
		// final variables cannot be reassigned. The objects they correspond to CAN be mutated.
		System.out.println(a.x);
		//a.x = 6;
		System.out.println(a.b);
		//a.b = new Bean();
		a.b.setColor("red");
		System.out.println(a.b);
	}
}

// final classes cannot be extended.
final class A {
	final int x = 5;
	final Bean b = new Bean();
}

class B /*extends A*/{
	// final methods cannot be overridden
	final void method() {
		System.out.println("This is a method.");
	}
}

final class C extends B {
	/*final void method() {
		System.out.println("Overrridden!");
	}*/
}