package com.revature.strings;

public class StringExample {
	public static void main(String[] args) {
		//stringPool();
		stringBuilder();
	}

	/*
	 * String		|	StringBuilder	|	StringBuffer
	 * ----------------------------------------------------
	 * final		|	final			|	final
	 * immutable	|	mutable			|	mutable
	 * thread-safe	|	not thread-safe	|	thread-safe
	 * fast			|	fast			|	slow
	 */
	private static void stringBuilder() {
		StringBuilder sb = new StringBuilder("Hello");
		sb.append(" World");
		sb.reverse();
		System.out.println(sb.toString());
		
		String s = "Hello";
		s = s+" World";
		char c[] = s.toCharArray();
		for(int i = 0; i< c.length/2; i++) {
			char temp = c[i];
			c[i]=c[c.length-(i+1)];
			c[c.length-(i+1)] = temp;
		}
		s = new String(c);
		System.out.println(s);
	}

	private static void stringPool() {
		String s = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		
		System.out.println("s==s2: "+(s==s2));
		System.out.println("s==s3: "+(s==s3));
		
		System.out.println("s.equals(s2): "+s.equals(s2));
		System.out.println("s.equals(s3): "+s.equals(s3));
		
		s3 = s3.intern();
		System.out.println("s==s2: "+(s==s2));
		System.out.println("s==s3: "+(s==s3));
	}
}
