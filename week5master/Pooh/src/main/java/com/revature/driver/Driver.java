package com.revature.driver;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Bear;
import com.revature.beans.Cave;
import com.revature.beans.HoneyPot;
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
		log.trace(secondRetrieval(2));
		
		hu.getSessionFactory().close();
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
