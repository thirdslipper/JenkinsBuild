package com.revature.pattern;

public class Toast implements Cheesable{

	@Override
	public void spreadCheese(String type) {
		System.out.println("Mmm, toast and "+type);
	}

}
