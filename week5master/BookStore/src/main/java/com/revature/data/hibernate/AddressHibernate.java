package com.revature.data.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Address;
import com.revature.data.AddressDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class AddressHibernate implements AddressDAO{
	private HibernateUtil hu=HibernateUtil.getInstance();
	
	@Override
	public int addAddress(Address address) {
		Session s = hu.getSession();
		Transaction t = s.beginTransaction();
		Integer id = 0;
		try {
			id = (Integer) s.save(address);
			t.commit();
		} catch(Exception e) {
			t.rollback();
			LogUtil.logException(e, AddressHibernate.class);
		} finally {
			s.close();
		}
		return id;
	}

	@Override
	public Address getAddress(int id) {
		Session s = hu.getSession();
		Address a = s.get(Address.class, id);
		s.close();
		return a;
	}

	@Override
	public void deleteAddress(Address address) {
		Session s = hu.getSession();
		Transaction t = s.beginTransaction();
		s.delete(address);
		t.commit();
		s.close();
	}

	@Override
	public void updateAddress(Address address) {
		Session s = hu.getSession();
		Transaction t = s.beginTransaction();
		s.update(address);
		t.commit();
		s.close();
	}

}
