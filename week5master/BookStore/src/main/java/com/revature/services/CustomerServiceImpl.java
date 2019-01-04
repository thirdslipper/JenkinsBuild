package com.revature.services;

import java.util.Set;

import com.revature.beans.Customer;
import com.revature.data.BookAppDAOFactory;
import com.revature.data.CustomerDAO;
import com.revature.data.UserDAO;

public class CustomerServiceImpl implements CustomerService {
	private BookAppDAOFactory bf = BookAppDAOFactory.getInstance();
	private UserDAO ud = bf.getUserDAO();
	private CustomerDAO cd = bf.getCustomerDAO();
	
	@Override
	public Customer getCustomer(String username, String password) {
		Customer cust = new Customer(0, username, password);
		cust = (Customer) ud.getUser(cust);
		return cust;
	}

	@Override
	public Customer getCustomerById(int i) {
		Customer cust = new Customer(i);
		cust = (Customer) ud.getUser(cust);
		return cust;
	}

	@Override
	public Set<Customer> getCustomers() {
		Set<Customer> custList = cd.getCustomers();
		return custList;
	}

	@Override
	public void deleteCustomer(Customer cust) {
		cd.deleteCustomer(cust);
	}

	@Override
	public void updateCustomer(Customer cust) {
		cd.updateCustomer(cust);
	}

	@Override
	public void addCustomer(Customer cust) {
		cd.addCustomer(cust);
	}

}
