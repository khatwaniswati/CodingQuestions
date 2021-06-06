package com.interviewbit.linkedlist;

public class SwapDemo {
	private static void swap(ListNode a, ListNode b) {
		ListNode temp = a;
		a=b;
		b=temp;
		System.out.println(LinkedListUtil.findLengthOfLinkedList(a)+" "+LinkedListUtil.findLengthOfLinkedList(b));
		System.out.println(a);
		System.out.println(b);
	}
}
