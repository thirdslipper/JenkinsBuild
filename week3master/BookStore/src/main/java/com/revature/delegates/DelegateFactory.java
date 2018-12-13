package com.revature.delegates;

public class DelegateFactory {
	private static DelegateFactory df;
	private DelegateFactory() {
		super();
	}
	public static synchronized DelegateFactory getInstance() {
		if(df==null) {
			df=new DelegateFactory();
		}
		return df;
	}
	
	public FrontControllerDelegate getDelegate(String name) {
		switch(name) {
		default: return null;
		}
	}
}
