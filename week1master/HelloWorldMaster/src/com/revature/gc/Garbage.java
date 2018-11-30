package com.revature.gc;

public class Garbage {
	private String name;

	public Garbage(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Garbage [name=" + name + "]";
	}
	
	/*
	 * Finalize:
	 * 		Finalize gets called BY garbage collection WHEN garbage collection is about to 
	 * 		free that memory. Finalize DOES NOT DELETE THE OBJECT.
	 * 		Finalize DOES NOT DO ANYTHING AT ALL.
	 * 		NO
	 * 	FINALIZE DOES NOTHING
	 * 	NOTHING
	 * 	EVER
	 * 
	 * Finalize exists so that you can have one chance to close resources and perform last rites
	 * 	before the object is deleted.
	 */
	@Override
	protected void finalize() throws Throwable {
		System.out.println(this);
		super.finalize();
	}
}
