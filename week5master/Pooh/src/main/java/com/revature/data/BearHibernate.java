package com.revature.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Bear;
import com.revature.util.HibernateUtil;

public class BearHibernate implements BearDao{
	private static HibernateUtil hu = HibernateUtil.getInstance();
	@Override
	public Bear addBear(Bear b) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.save(b);
		tx.commit();
		s.close();
		return b;
	}

	@Override
	public Bear getBearById(int i) {
		Session s = hu.getSession();
		Bear b = s.get(Bear.class, i);
		s.close();
		return b;
	}

	@Override
	public Set<Bear> getBearsCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Bear> getBearsHQL() {
		// HQL - an interface of Hibernate
		/*
		 * Hibernate Query Language
		 * An object based query language for querying relational databases
		 * without any knowledge of their underlying schemas or of SQL.
		 */
		Session s = hu.getSession();
		String query = "from com.revature.beans.Bear";
		Query<Bear> q = s.createQuery(query, Bear.class);
		List<Bear> bearList = q.getResultList();
		s.close();
		return new HashSet<Bear>(bearList);
	}

	@Override
	public Bear updateBear(Bear b) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.update(b);
		tx.commit();
		s.close();
		return b;
	}

	@Override
	public void deleteBear(Bear b) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(b);
		tx.commit();
		s.close();
	}

}
