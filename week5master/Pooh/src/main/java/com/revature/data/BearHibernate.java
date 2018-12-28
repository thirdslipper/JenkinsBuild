package com.revature.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		// Criteria
		/*
		 * API for querying data programatically.
		 * WE just use Java to query our database.
		 * WE can only perform DQL with Criteria.
		 */
		Session s = hu.getSession();
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<Bear> criteria = builder.createQuery(Bear.class);
		Root<Bear> root = criteria.from(Bear.class);
		criteria.select(root);
		List<Bear> bears = s.createQuery(criteria).getResultList();
		return new HashSet<Bear>(bears);
	}

	@Override
	public Set<Bear> getBearsHQL() {
		// HQL - an interface of Hibernate
		/*
		 * Hibernate Query Language
		 * An object based query language for querying relational databases
		 * without any knowledge of their underlying schemas or of SQL.
		 * We can perform DQL and DML
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
