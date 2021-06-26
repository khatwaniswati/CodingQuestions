package com.hackerrank.morganstanley;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class AtomicVariableTest {

	private static AtomicInteger counter = new AtomicInteger(0);

	static class Decrementer extends Thread {

		public void run() {

			counter.decrementAndGet(); // #1
		}
	}

	static class Incrementer extends Thread {

		public void run() {

			counter.incrementAndGet(); // #2
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			//System.out.println("i:"+i);
			new Incrementer().start();
			//System.out.println("counter:"+counter);
			new Decrementer().start();
		}
		System.out.println(counter);
		//getDetails();
	}

	public static void getDetails() {
		Map<String, Integer> map = new HashMap<>();
		String a = "abc";
		String b = new String("abc");
		map.put(a, 10);
		map.put(b, 20);
		map.put(new String("abc"), 30);
		System.out.println(map.get("abc"));
	}

}
