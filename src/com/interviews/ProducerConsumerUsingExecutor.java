package com.interviews;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerUsingExecutor {

	static List<Integer> arr = new ArrayList<>();
	static ReentrantLock reentrantLock = new ReentrantLock();
	static Condition condition = reentrantLock.newCondition();

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(new Consumer());
		service.submit(new Producer());
		service.shutdown();
	}

	private static class Producer extends Thread {
		@Override
		public void run() {
			System.out.println("Inside Producer");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Adding");
			reentrantLock.lock();
			for (int i = 0; i < 100; i++) {
				arr.add(i);
			}
			System.out.println(arr);
			condition.signalAll();
			reentrantLock.unlock();
			System.out.println("Notifying");
		}
	}

	private static class Consumer extends Thread {
		@Override
		public void run() {
			System.out.println("Inside Consumer");
			reentrantLock.lock();
			try {
				while(arr.size()==0) {
					System.out.println("Waiting");
					condition.await();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Consumer before lock");
			if (!arr.isEmpty()) {
				System.out.println("Consumer printing");
				System.out.println(arr);
				arr.clear();
			} else {
				System.out.println("List is Empty");
			}
			reentrantLock.unlock();
		}
	}
}
