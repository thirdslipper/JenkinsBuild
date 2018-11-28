package com.revature.scopes;

public class Scopes {
	/* Scopes
	 * The lifetime of a variable
	 * 
	 * Java has 4 scopes.
	 * 
	 * Class/Static scope - Variables which belong to a class.
	 * 	Variables in this scope are instantiated when the class
	 * 	loads and are available until the program terminates or
	 *  the class is "unloaded"
	 * Object/Instance scope - The object's fields/state.
	 * 	Variables in this scope exist for the lifetime of the object.
	 * Method scope - parameters and any variables defined within a method.
	 * 	Exist for the duration of the method call.
	 * Local/loop/block scope - any variable defined within a loop or curly braces.
	 */
	public Scopes() {
		System.out.println("Constructor");
	}
	public static int i;
	public int j;
	
	static {
		// static block. Code block that executes when the class is loaded.
		System.out.println("Static block");
		i = 5;
		//j = 5;
		//k=5;
	}
	
	{
		// instance block. code block that executes when an instance of a class is created.
		System.out.println("Instance block");
		i=5;
		j=5;
		//k=5;
	}
	
	public static void main(String[] args) {
		System.out.println("Main method.");
		Scopes s = new Scopes();
		//method scope
		int k;
		// block scope
		for(int l = 0; l<3; l++) {
			i=5;
			//j=4;
			k=5;
			l=5;
		}
		//l = 5;
		s.method(3);
	}
	
	private void method(int hi) {
		i = 5;
		j = 5;
		hi =3;
		//k = 5;
		//l = 3;
	}
}
