package com.interviews;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerOlderWay {

	private static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {
		Thread producer = new Thread(()-> {
			try {
				produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread consumer = new Thread(()-> {
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		producer.start();
		consumer.start();
	}

	private static void produce() throws InterruptedException {
		System.out.println("produce");
		Thread.sleep(10000);
		synchronized (queue) {
			for (int i = 0; i < 100; i++) {
				queue.offer(i);
			}
			queue.notify();
			System.out.println("Queue ready");
		}
	}

	private static void consume() throws InterruptedException {
		System.out.println("consume");
		synchronized (queue) {
			if(queue.isEmpty())
				queue.wait(11000);
			while (!queue.isEmpty()) {
				System.out.println("Polling:"+queue.poll());
			}
		}
		
	}
}
