package com.revature.threads;

import java.util.ArrayList;
import java.util.Collections;

public class ProcessingExample {
	private static ArrayList<Integer> a;
	private static ArrayList<Integer> ap;
	public static void main(String[] args) {
		//testParallel();
		synchronize();
	}
	private static void synchronize() {
		new Thread(() -> {test();}).start();
		Thread t = new Thread(() -> {test();});
		System.out.println(t.getState());
		t.start();
		System.out.println(t.getState());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getState());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getState());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getState());
		
	}
	
	private static synchronized void test() {
		System.out.println("Hello, I am a thing.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Goodbye you.");
	}
	private static void testParallel() {
		double avg=0;
		for(int i =0; i<10; i++) {
			avg += parallelComputation();
		}
		System.out.println("Parallel: "+avg/10);
		
		avg=0;
		for(int i =0; i<10; i++) {
			avg += serialComputation();
		}
		System.out.println("Serial: "+avg/10);
		System.out.println(a.equals(ap));
	}
	private static double parallelComputation() {
		ap = new ArrayList<Integer>(5000000);
		for(int i = 0; i<5000000; i++) {
			ap.add(50);
		}
		//System.out.println(a);
		double start = 0;
        double end = 0;
        
        Runnable r1 = () -> {
        	for(int i=1666660; i<3333330; i++) {
        		ap.set(i, ap.get(i)-i);
        	}
        };      
        Runnable r2 = () -> {
        	for(int i=3333330; i<5000000; i++) {
        		ap.set(i, ap.get(i)-i);
        	}
        }; 
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        start = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        for(int i = 0; i<1666660; i++) {
        	ap.set(i, ap.get(i)-i);
        }
        try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        end = System.currentTimeMillis();
        //System.out.println((end-start));
        //System.out.println(a);
        return end-start;
		
	}
	private static double serialComputation() {
		a = new ArrayList<Integer>(5000000);
		for(int i = 0; i<5000000; i++) {
			a.add(50);
		}
		//System.out.println(a);
		double start = 0;
        double end = 0;
        
        start = System.currentTimeMillis();
        for(int i = 0; i<5000000; i++) {
        	a.set(i, a.get(i)-i);
        }
        
        end = System.currentTimeMillis();
        //System.out.println((end-start));
        //System.out.println(a);
        return end-start;
		
	}
}
