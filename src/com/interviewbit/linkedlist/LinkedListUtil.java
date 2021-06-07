package com.interviewbit.linkedlist;

import java.util.List;

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

	public static ListNode createNodesFromList(List<Integer> lst) {
		Integer head = lst.get(0);
		ListNode headNode = new ListNode(head);
		ListNode parent = headNode;
		for (int i = 1; i < lst.size(); i++) {
			ListNode newNode = new ListNode(lst.get(i));
			parent.next = newNode;
			parent = newNode;
		}
		return headNode;
	}
}
