package com.revature.data;

public class BookAppDAOFactory {
	private static BookAppDAOFactory bf = null;
	private static final String TYPE = "Oracle";
	
	private BookAppDAOFactory() {
		super();
	}
	public static synchronized BookAppDAOFactory getInstance() {
		if(bf==null) {
			bf = new BookAppDAOFactory();
		}
		return bf;
	}
	public GenreDAO getGenreDAO() {
		switch(TYPE) {
		case "Oracle": return new GenreOracle();
		default: throw new RuntimeException("Could not determine DAO type");
		}
	}
}
