package com.revature.pattern;

public class Cracker implements Cheesable{

	@Override
	public void spreadCheese(String type) {
		System.out.println("Mmm, crackers and "+type);
	}

}
