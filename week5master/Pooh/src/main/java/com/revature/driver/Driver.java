package com.revature.driver;


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.revature.beans.Bear;
import com.revature.beans.Cave;
import com.revature.beans.HoneyPot;
import com.revature.data.BearDao;
import com.revature.data.BearHibernate;
import com.revature.util.HibernateUtil;

public class Driver {
	private static HibernateUtil hu = HibernateUtil.getInstance();
	private static Logger log = Logger.getLogger(Driver.class);
	
	public static void main(String[] args) {
		//firstRetrieval(1);
		/*HoneyPot h = new HoneyPot();
		h.setHoneyAmount(75.0);;
		h.setVolume(655.0);;
		int i = makeHoneyPot(h);
		firstRetrieval(i);*/
		//log.trace(getHoneyPot(1));
		//log.trace(secondRetrieval(1));
		//buildABear();
		//log.trace(secondRetrieval(2));
		
		// difference between get and load
		/*HoneyPot h = getHoneyPot(3);
		log.trace(h);
		h = getHoneyPot(5);
		log.trace(""+h);*/
		/*HoneyPot h = loadHoneyPot(3);
		//log.trace(h);
		Session su = hu.getSession();
		h = su.load(HoneyPot.class,h.getHoneypotId());
		log.trace(h);
		su.close();*/
		
		//fixingLazyInitialization();
		
		//updateVsMerge();
		
		//automaticDirtyChecking();
		
		//savingDetachedObjects();
		
		//nativeQuery();
		
		//daos();
		
		// hql();
		
		namedQueries();
		
		hu.getSessionFactory().close();
	}
	private static void namedQueries() {
		Session s = hu.getSession();
		List<HoneyPot> h = s.createNamedQuery("getAllHoneypots", HoneyPot.class).getResultList();
		log.trace(h);
		
		h = s.createNamedQuery("getAllHoneypotsWithHoney", HoneyPot.class)
				.setParameter("amount", 75.0).getResultList();
		log.trace(h);
	}
	private static void hql() {
		Session s = hu.getSession();
		String query = "from com.revature.beans.Bear where bearColor = :color";
		Query<Bear> q = s.createQuery(query, Bear.class);
		q.setParameter("color", "pink");
		List<Bear> bearList = q.getResultList();
		s.close();
		log.trace(bearList);
	}
	private static void daos() {
		BearDao bd = new BearHibernate();
		log.trace(bd.getBearsHQL());
		log.trace(bd.getBearsCriteria());
	}
	private static void nativeQuery() {
		Session s = hu.getSession();
		HoneyPot h;
		String nativeSQL = "Select * from honey_pot where honeypot_id=:billybob";
		NativeQuery<HoneyPot> n = s.createNativeQuery(nativeSQL, HoneyPot.class);
		n.setParameter("billybob", 1);
		h = n.uniqueResult();
		log.trace(h);
		s.close();
	}
	private static void savingDetachedObjects() {
		Bear b = secondRetrieval(1);
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.save(b);
		tx.commit();
		s.close();
	}
	public static void automaticDirtyChecking() {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		HoneyPot h = s.get(HoneyPot.class, 3);
		log.trace(h);
		h.setVolume(h.getVolume()+1);
		//s.update(h);
		log.trace(h);
		h.setVolume(h.getVolume()+1);
		log.trace(h);
		tx.commit();
		s.close();
	}
	public static void updateVsMerge() {
		Bear b1 = secondRetrieval(1);
		Bear b2 = secondRetrieval(1);
		//log.trace(b1==b2);
		b1.setBearColor("white");
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		Bear b3 = (Bear) s.merge(b1);
		b2.setBearColor("pink");
		Bear b4 = (Bear) s.merge(b2);
		log.trace("b1 compare to b2: "+(b1==b2));
		log.trace("b1 compare to b3: "+(b1==b3));
		log.trace("b1 compare to b4: "+(b1==b4));
		log.trace("b2 compare to b3: "+(b2==b3));
		log.trace("b2 compare to b4: "+(b2==b4));
		log.trace("b3 compare to b4: "+(b3==b4));
		
		s.update(b2);
		tx.commit();
		s.close();
	}
	private static void fixingLazyInitialization() {
		Bear b = secondRetrieval(2);
		Session su = hu.getSession();
		su.update(b);
		log.trace(b.getCave().getResidents());
		su.close();	
		
	}
	private static HoneyPot loadHoneyPot(int id) {
		Session su = hu.getSession();
		HoneyPot h = su.load(HoneyPot.class, id);
		//h.getVolume();
		su.close();
		return h;
	}
	public static void buildABear() {
		Bear b = new Bear();
		Cave c = new Cave();
		HoneyPot h = new HoneyPot();
		h.setHoneyAmount(6.0);
		h.setVolume(7.0);
		b.setHoneyPot(h);
		c.setCaveType("Igloo");
		c.setSquareFootage(10.0);
		b.setCave(c);
		b.setHeight(5.0);
		b.setWeight(600.0);
		b.setBreed("Polar");
		b.setBearColor("White");

		Bear b2 = new Bear();
		b2.setCave(c);
		b2.setBreed("Polar");
		b2.setBearColor("White");
		b2.setHeight(3.0);
		b2.setWeight(300.0);
		b2.setHoneyPot(new HoneyPot());
		b2.getHoneyPot().setHoneyAmount(3.0);
		b2.getHoneyPot().setVolume(3.0);
		
		b.getBearCubs().add(b2);
		
		Session su = hu.getSession();
		Transaction tx = null;
		try {
			tx = su.beginTransaction();
			su.save(b);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			su.close();
		}
		
	}

	private static Bear secondRetrieval(int id) {
		Session su=hu.getSession();
		Bear b = su.get(Bear.class, id);
		su.close();
		return b;
	}

	public static HoneyPot getHoneyPot(int id) {
		Session su = hu.getSession();
		HoneyPot h = su.get(HoneyPot.class, id);
		su.close();
		return h;
	}

	public static int makeHoneyPot(HoneyPot h) {
		Session su = hu.getSession();
		Transaction tx = null;
		int i = 0;
		try {
			tx = su.beginTransaction();
			i = (Integer) su.save(h);
			log.trace("The generated id was: "+i);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			su.close();
		}
		return i;
	}

	public static void firstRetrieval(int id) {
		// open a session to the database
		Session su = hu.getSession();
		// retrieve a honeypot from the db;
		HoneyPot h = su.get(HoneyPot.class, id);
		log.trace(h);
		// close the session
		su.close();
	}
}
