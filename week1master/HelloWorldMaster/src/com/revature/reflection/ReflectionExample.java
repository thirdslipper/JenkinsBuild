package com.revature.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.revature.beans.Bean;

public class ReflectionExample {
	/*
	 * Reflection is a Java API for examining and modifying code at runtime
	 */
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		//beans();
		// Strings are immutable?
		// Why are they?
		// Because of the String Pool?
		/*
		 * "Hello" -> String Pool: "Hello"
		 * "Hello" ->
		 * "GoodBye" -> String Pool: "Hello", "GoodBye"
		 */
		stringPool();
	}

	private static void stringPool() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String s = "Hello";
		Field[] stringFields = s.getClass().getDeclaredFields();
		for(Field f: stringFields) {
			System.out.println(f);
		}
		Field valueField = s.getClass().getDeclaredField("value");
		valueField.setAccessible(true);
		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(valueField, valueField.getModifiers() & ~Modifier.FINAL);
		char[] c = {'G', 'o', 'o', 'd', 'B', 'y', 'e' };
		valueField.set(s, c);
		
		String s2 = "Hello";
		System.out.println(s2);
		System.out.println(s);
		String one = "Hello";
		String two = "G";
		System.out.println("Hello" + "GoodBye");
		System.out.println(one+two);
		String s5 = "Hello"+"World";
		System.out.println(s5);
		String s6 = new String("Hello");
		System.out.println(s6);
		String s7 = "H" + "ello";
		System.out.println(s7);
		String s8 = new String("Hel");
		String s9 = new String("lo");
		String s10= s8+s9;
		System.out.println(s10);
		s10= s10.intern();
		System.out.println("Hello");
	}

	private static void beans() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class<Bean> beanClass = Bean.class;
		System.out.println(beanClass);
		
		Bean beanObject = new Bean();
		//beanObject.color = "red";
		beanObject.setColor("red");
		System.out.println(beanObject);
		beanObject.setStrain("Red bean");
		System.out.println(beanObject);
		
		System.out.println("\tDeclared Methods");
		// All the methods declared in the class
		// Excludes inherited methods
		Method[] methods = beanClass.getDeclaredMethods();
		for(Method m: methods) {
			System.out.println("\t\t"+m);
		}
		
		System.out.println("\tPublic Methods");
		// All public methods including inherited
		methods = beanClass.getMethods();
		for(Method m : methods) {
			System.out.println("\t\t"+m);
		}
		
		System.out.println("\tConstructors");
		Constructor<Bean>[] constructors = (Constructor<Bean>[]) beanClass.getConstructors();
		for(Constructor<Bean> c: constructors) {
			System.out.println("\t\t"+c);
		}
		
		System.out.println("\tFields");
		Field[] fields = beanClass.getDeclaredFields();
		for(Field f: fields) {
			System.out.println("\t\t"+f);
		}
		
		System.out.println(beanObject);
		Field colorField = beanObject.getClass().getDeclaredField("color");
		colorField.setAccessible(true);
		colorField.set(beanObject, "dog");
		System.out.println(beanObject);
	}
}
