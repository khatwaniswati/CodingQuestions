package com.interviewbit.linkedlist;

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	@Override
	public String toString() {
		return val + " ";
	}

}

public class LinkedListUtil {

	public static int findLengthOfLinkedList(ListNode x) {
		int len = 1;
		while (x.next != null) {
			len++;
			x = x.next;
		}
		return len;
	}

	public static void printList(ListNode n) {
		while (n != null) {
			System.out.print(n.toString());
			n = n.next;
		}
		System.out.println();
	}

}
