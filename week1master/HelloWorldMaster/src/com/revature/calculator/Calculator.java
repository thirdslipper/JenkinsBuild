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
	
	public T add(T a, T... b) {
		T ret = a;
		for(T t : b) {
			ret = add(ret, t);
		}
		return ret;
	}
	
	public T sub(T a, T b) {
		Number ret = a.doubleValue()-b.doubleValue();
		if(a instanceof Float || a instanceof Double) {
			return (T) ret;
		}
		ret = Math.round(ret.doubleValue());
		return (T) ret;
	}
	public T mult(T a, T b) {
		Number ret = a.doubleValue()*b.doubleValue();
		if(a instanceof Float || a instanceof Double) {
			return (T) ret;
		}
		ret = Math.round(ret.doubleValue());
		return (T) ret;
	}
	public T div(T a, T b) {
		Number ret = a.doubleValue()/b.doubleValue();
		if(a instanceof Float || a instanceof Double) {
			return (T) ret;
		}
		ret = Math.round(ret.doubleValue());
		return (T) ret;
	}
	
	
	public T sub(T a, T...b) {
		T ret = a;
		for (T n : b) {
			ret = sub(ret, n);
		}
		return ret;
	}
	public T mult(T a, T...b) {
		T ret = a;
		for (T n : b) {
			ret = mult(ret, n);
		}
		return ret;
	}
	public T div(T a, T...b) {
		T ret = a;
		for (T n : b) {
			ret = div(ret, n);
		}
		return ret;
	}
}
