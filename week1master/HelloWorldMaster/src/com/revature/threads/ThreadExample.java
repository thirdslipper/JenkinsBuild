package com.revature.threads;

public class ThreadExample {
	public static void main(String[] args) {
		System.out.println("This is the main thread.");
		//thread();
		//runnable();
		lambda();
		
		System.out.println("End of main thread.");
	}

	private static void lambda() {
		Runnable run = () -> {
			System.err.println("I'm a thread (Runnable Lambda)!");
			try {
				Thread.sleep(5000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.err.println("Thread execution ending.");
		};
		Thread thread = new Thread(run);
		thread.start();
		System.out.println("Started a new thread.");
		System.out.println("Is the thread alive? "+thread.isAlive());
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Is the thread alive? "+thread.isAlive());
		System.out.println("The other thread is dead. Long live the main thread.");
	}

	private static void runnable() {
		Thread thread = new Thread(new MyRunnable());
		thread.start();
		System.out.println("Started a new thread.");
		System.out.println("Is the thread alive? "+thread.isAlive());
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Is the thread alive? "+thread.isAlive());
		System.out.println("The other thread is dead. Long live the main thread.");
	}

	private static void thread() {
		Thread thread = new MyThread();
		thread.start();
		System.out.println("Started a new thread.");
		System.out.println("Is the thread alive? "+thread.isAlive());
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Is the thread alive? "+thread.isAlive());
		System.out.println("The other thread is dead. Long live the main thread.");
	}
}
class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.err.println("I'm a thread (Runnable)!");
		try {
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println("Thread execution ending.");
	}
}

class MyThread extends Thread{
	public void run() {
		System.err.println("I'm a thread!");
		try {
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println("Thread execution ending.");
	}
}