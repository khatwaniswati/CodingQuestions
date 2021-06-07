package com.interviewbit.linkedlist;

import java.util.Arrays;

public class LinkedListIntersectionNode {
	public static void main(String[] args) {
		ListNode a = LinkedListUtil.createNodesFromList(Arrays.asList(4, 6, 7, 1));
		ListNode b = LinkedListUtil.createNodesFromList(Arrays.asList(9, 3, 5, 7, 1));
		/*
		 * ListNode a = LinkedListUtil.createNodesFromList(Arrays.asList(1, 2));
		 * ListNode b = LinkedListUtil.createNodesFromList(Arrays.asList(3, 4, 5));
		 */

		ListNode intersectionNode = getIntersectionNode(b, a);
		LinkedListUtil.printList(intersectionNode);
	}

	public static ListNode getIntersectionNode(ListNode a, ListNode b) {
		if (a == null || b == null)
			return null;
		int lenA = LinkedListUtil.findLengthOfLinkedList(a);
		int lenB = LinkedListUtil.findLengthOfLinkedList(b);

		// b should always b bigger list
		if (lenA > lenB) {
			ListNode temp = a;
			a = b;
			b = temp;
		}
		// skip d elements from b
		int d = LinkedListUtil.findLengthOfLinkedList(b) - LinkedListUtil.findLengthOfLinkedList(a);
		for (int i = 0; i < d; i++) {
			b = b.next;
		}
		while (a != null && b != null) {
			if (a == b)
				return a;
			a = a.next;
			b = b.next;
		}
		return null;
	}

}