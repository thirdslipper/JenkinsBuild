package com.revature.wrappers;

public class Wrappers {
	// primitives
	/*
	 * boolean - JVM dependent - Boolean
	 * byte - 1 byte - Byte
	 * char - 2 bytes - Character
	 * short - 2 bytes - Short
	 * int - 4 bytes - Integer
	 * float - 4 bytes - Float
	 * long - 8 bytes - Long
	 * double - 8 bytes - Double
	 */
	
	public static void main(String[] args) {
		System.out.println(Double.BYTES);
		Long l = new Long(56);
		l = 56l;
		//primitiveSizes();
		//convertibleIntValues();
		comparingPrimitivesAndWrappers();
	}
	
	private static void comparingPrimitivesAndWrappers() {
		int intPrimitive = 5;
		Integer intObject = 5;
		
		short shortPrimitive = 5;
		Short shortObject = 5;
		
		long longPrimitive = 5;
		Long longObject = 5l;
		
		// 5 is an integer. 5.0 is a double. 5f or 5.0f is a float
		float floatPrimitive = 5.0f;
		Float floatObject = 5f;
		
		double doublePrimitive = 5;
		Double doubleObject = 5.0;
		
		// Auto-unboxing - The JVM will automatically "unwrap" the object to a primitive type
		System.out.println("intPrimitive==intObject: "+(intPrimitive==intObject));
		// the == operator compares memory locations of two objects.
		System.out.println("intObject==new Integer(5): "+(intObject==new Integer(5)));
		
		System.out.println("intObject.equals(new Integer(5)): "+intObject.equals(new Integer(5)));
		System.out.println("intObject.equals(new Integer(4)): "+intObject.equals(new Integer(4)));
		// .equals of wrapper classes always returns false with a different object type
		System.out.println("intObject.equals(new Long(5)): "+intObject.equals(new Long(5)));
		// We can auto-box 5 to an integer
		System.out.println("intObject.equals(5): "+intObject.equals(5));
		System.out.println("intObject.equals(longObject.intValue()): "+intObject.equals(longObject.intValue()));
		System.out.println("intObject == (longObject.intValue()): "+(intObject == (longObject.intValue())));
		System.out.println("intObject == (longObject.intValue()): "+(new Integer(5) == (longObject.intValue())));
	}

	private static void convertibleIntValues() {
		int i;
		// a switch statement takes in Enums, Strings, and convertible int values.
		boolean bool = true;
		//i = bool;
		byte b = 8;
		i = b;
		char c = '8';
		i = c;
		short s = 8;
		i = s;
		int j = 8;
		i = j;
		float f = 8;
		i = (int) f; //have to explicitly cast
		long l = 8;
		i = (int) l;
		double d = 8;
		i = (int) d;
		Long longExample = (long)Integer.MAX_VALUE + 10;
		i = (int) longExample.longValue();
		System.out.println(i);
	}

	private static void primitiveSizes() {
		//byte -2^7-2^7-1
		System.out.println(Byte.MIN_VALUE+" - "+Byte.MAX_VALUE);
		//character? 0-2^16-1
		System.out.println((int)Character.MIN_VALUE+ " - "+ (int)Character.MAX_VALUE);
		// short? -2^15 - 2^15-1
		System.out.println(Short.MIN_VALUE+ " - "+ Short.MAX_VALUE);
		System.out.println("Float: "+ Float.MIN_VALUE + " - "+ Float.MAX_VALUE);
		float f = -5f;
		System.out.println(f);
		System.out.println("Integer: "+ Integer.MIN_VALUE + " - "+ Integer.MAX_VALUE);
		System.out.println("Long: "+Long.MIN_VALUE+ " - "+ Long.MAX_VALUE);
		System.out.println("Double: "+Double.MIN_VALUE+ " - "+ Double.MAX_VALUE);
	}
}
