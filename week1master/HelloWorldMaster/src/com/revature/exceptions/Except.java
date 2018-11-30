package com.revature.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

public class Except {
	public static void main(String[] args) {
		//checkedUnchecked();
		//exceptionHierarchy();
		try {
			method1();
			System.out.println("No exception.");
		} catch (TooMuchPieException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			//method2();
			return;
		} finally {
			System.out.println("This will always run, exception or no exception.");
		}
		System.out.println("is it?");
	}
	
	private static void method1() throws TooMuchPieException {
		System.out.println("Eating pie in method 1");
		Random rand = new Random();
		int i = rand.nextInt(2);
		if(i==0)
			throw new TooMuchPieException();
	}
	private static void method2() {
		System.out.println("eating pie in method 2");
		throw new RuntimeException();
	}
	private static void exceptionHierarchy() {
		try {
			System.out.println("Hello before throw");
			int i = 5/0;
			System.out.println("Hello after throw.");
		} catch (NullPointerException e) {
			System.err.println("Caught NullPointerException");
		} catch (ArithmeticException e) {
			System.err.println("Caught ArithmeticException");
			//return;
		} catch (RuntimeException e) {
			System.err.println("Caught RuntimeException");
		}
		catch(Exception e) {
			System.err.println("Caught Exception");
		}
		System.out.println("Hello after catch.");
	}

	private static void checkedUnchecked() {
		//int i = 5/0;
		//Integer i = null;
		//i.intValue();
		FileReader f;
		try {
			f = new FileReader("C:\\Users\\rlayn\\GitRepos\\1811-nov27-wvu\\week1master\\HelloWorldMaster\\src\\com\\revature\\exceptions\\Except.java");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
