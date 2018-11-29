package com.revature.calculator;

import java.util.function.Predicate;

public class LambdaPredicate {
	/*
	 * A lambda function is a piece of code that is written to perform a single function once.
	 * If you want to reuse code, you should write a class.
	 * Class: a reusable code module.
	 * A lambda lets write a class in a single line.
	 * 
	 * Function Interface: Single abstract method
	 * Predicate interface: a functional method for testing methods.
	 * 		test()
	 */
	
	public static void main(String[] args) {
		Predicate<Calculator<Long>> p = (i) -> i.add(4l,5l)==9;
		
		Calculator<Long> c = new Calculator<Long>();
		System.out.println(p.test(c));
		Predicate<Calculator<Long>> p2 = (i) -> {
			Long l = i.div(5l,  0l);
			return Long.MAX_VALUE == l;
		};
		System.out.println(p2.test(c));
		Predicate<Calculator<Long>> p3 = p.and(p2);
		System.out.println(p3.test(c));
	}
}
