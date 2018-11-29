package com.revature.calculator;

/*
 * Generic
 * 	The ability to parameterize a class so that it can take multiple different kinds
 * 	of objects. These parameters are checked at compile time and then all generic
 * 	references are erased.
 */
public class Calculator<T extends Number> {
	
	public static void main(String...strings) {
		Calculator<Integer> calc = new Calculator<Integer>();
		System.out.println(calc.add(5, 6));
	}
	
	public T add(T a, T b) {
		Number ret = a.doubleValue()+b.doubleValue();
		if(a instanceof Float || a instanceof Double) {
			return (T) ret;
		}
		ret = Math.round(ret.doubleValue());
		return (T) ret;
	}
	
	//write a method which takes in any number of variables and sums them all.

}
