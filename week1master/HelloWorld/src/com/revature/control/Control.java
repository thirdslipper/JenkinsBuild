package com.revature.control;

import java.util.Scanner;

public class Control {
	public static void main(String[] args) {
		//ifStatement();
		//loops();
		//enhance();
		//ternary();
		//shortCircuit();
		breakControl();
	}

	private static void breakControl() {
		// labels, breaks, and continues
		/*for (int i = 0; i< 10; i++) {
			System.out.println(i);
			if(i==5)
				continue;
			if(i==7)
				break;
			System.out.println(i);
		}*/
		loop1: for(int i = 0; i<4; i++) {
			loop2: for(int j=0; j<4; j++) {
				if(i==2 && j>1) {
					break loop1;
				}
				System.out.println(i+" "+j);
			}
		}
	}

	private static void shortCircuit() {
		int x = 6;
		int y = 6;
		int z = 7;
		System.out.println("x = "+(++x)+", y="+(y++)+", z="+z);
		
		if(x++ == ++y && ++x== z++) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		System.out.println("x = "+x+", y="+y+", z="+z);
	}

	private static void ternary() {
		// An operator which returns values based on the evaluation of a condition
		Scanner scan = new Scanner(System.in);
		System.out.println("Input a value: ");
		int x = scan.nextInt();
		
		// ternary form
		String s = x>3 ? "x is greater than 3" : "x is not greater than 3";
		System.out.println(s);
		
		s = x>3 ? "x is greater than 3" : (x==3 ? "x is 3" : "x is less than 3");
		System.out.println(s);
	}

	private static void enhance() {
		// regular for loop
		String[] arr = { "Horse", "Dog", "Bat", "Iguana" };
		for(int i = 0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
		
		//enhanced for loop
		for(String animal : arr) {
			System.out.println(animal);
		}
	}

	private static void ifStatement() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input a value: ");
		int x = scan.nextInt();
		
		// if else
		if(x>3) {
			System.out.println("x is greater than 3");
		} else {
			if(x == 3) {
				System.out.println("x is 3");
			} else {
				System.out.println("x is less than 3");
			}
		}
		
		if(x>3)
			System.out.println("x is greater than 3");
		else 
			if(x == 3) 
				System.out.println("x is 3");
			else
				System.out.println("x is less than 3");
	}

	private static void loops() {
		// for
		for (int i = 0; i< 10; i++) {
			System.out.println(i);
		}
		
		{
			int i = 0;
			
			while(i<10) {
				System.out.println(i);
				i++;
			}
		}
		
		// trying to get fancy
		{
			int i = 5;
			int j = 1;
			while(j<i) {
				System.out.println(j);
				j++;
				i--;
			}
		}
		for(int i = 5, j=1; j<i; j++, i--) {
			System.out.println(j);
		}
		
		/*for(;;) {
			System.out.println("hi.");
		}
		while(true) {
			System.out.println("hi.");
		}*/
		int i = 10;
		do {
			System.out.println(i);
			i++;
		} while(i<10);
	}
}
