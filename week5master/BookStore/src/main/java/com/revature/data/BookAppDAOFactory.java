package com.revature.data;

import com.revature.data.hibernate.AddressHibernate;
import com.revature.data.hibernate.AuthorHibernate;
import com.revature.data.hibernate.BookHibernate;
import com.revature.data.hibernate.CustomerHibernate;
import com.revature.data.hibernate.EmployeeHibernate;
import com.revature.data.hibernate.GenreHibernate;
import com.revature.data.hibernate.PurchaseHibernate;
import com.revature.data.hibernate.UserHibernate;
import com.revature.data.oracle.AddressOracle;
import com.revature.data.oracle.AuthorOracle;
import com.revature.data.oracle.BookOracle;
import com.revature.data.oracle.CustomerOracle;
import com.revature.data.oracle.EmployeeOracle;
import com.revature.data.oracle.GenreOracle;
import com.revature.data.oracle.PurchaseOracle;
import com.revature.data.oracle.UserOracle;

public class BookAppDAOFactory {
	private static BookAppDAOFactory bf = new BookAppDAOFactory();
	private static final String TYPE = "Hibernate";
	private BookAppDAOFactory() {
		super();
	}
	public static synchronized BookAppDAOFactory getInstance() {
		if(bf==null) {
			bf = new BookAppDAOFactory();
		}
		return bf;
	}
	public AuthorDAO getAuthorDAO() {
		switch(TYPE) {
		case "Oracle": return new AuthorOracle();
		case "Hibernate": return new AuthorHibernate();
		default: throw new RuntimeException("Could not determine DAO type");
		}
	}
	public GenreDAO getGenreDAO() {
		switch(TYPE) {
		case "Oracle": return new GenreOracle();
		case "Hibernate": return new GenreHibernate();
		default: throw new RuntimeException("Could not determine DAO type");
		}
	}
	public BookDAO getBookDAO() {
		switch(TYPE) {
		case "Oracle": return new BookOracle();
		case "Hibernate": return new BookHibernate();
		default: throw new RuntimeException("Could not determine DAO type");
		}
	}
	public AddressDAO getAddressDAO() {
		switch(TYPE) {
		case "Oracle": return new AddressOracle();
		case "Hibernate": return new AddressHibernate();
		default: throw new RuntimeException("Could not determine DAO type");
		}
	}
	public UserDAO getUserDAO() {
		switch(TYPE) {
		case "Oracle": return new UserOracle();
		case "Hibernate": return new UserHibernate();
		default: throw new RuntimeException("Could not determine DAO type");
		}
	}
	public EmployeeDAO getEmployeeDAO() {
		switch(TYPE) {
		case "Oracle": return new EmployeeOracle();
		case "Hibernate": return new EmployeeHibernate();
		default: throw new RuntimeException("Could not determine DAO type");
		}
	}
	public CustomerDAO getCustomerDAO() {
		switch(TYPE) {
		case "Oracle": return new CustomerOracle();
		case "Hibernate": return new CustomerHibernate();
		default: throw new RuntimeException("Could not determine DAO type");
		}
	}
	public PurchaseDAO getPurchaseDAO() {
		switch(TYPE) {
		case "Oracle": return new PurchaseOracle();
		case "Hibernate": return new PurchaseHibernate();
		default: throw new RuntimeException("Could not determine DAO type");
		}
	}
}
