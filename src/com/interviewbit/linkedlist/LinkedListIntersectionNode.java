package com.interviewbit.linkedlist;

public class LinkedListIntersectionNode {
	public static void main(String[] args) {

		ListNode a = new ListNode(4);
		ListNode b = new ListNode(9);

		ListNode newNode = new ListNode(6);
		a.next = newNode;
		ListNode newNode2 = new ListNode(7);
		newNode.next = newNode2;
		ListNode newNode3 = new ListNode(1);
		newNode2.next = newNode3;

		ListNode newNodeB = new ListNode(3);
		b.next = newNodeB;
		ListNode newNodeB2 = new ListNode(5);
		newNodeB.next = newNodeB2;
		ListNode newNodeB3 = new ListNode(7);
		newNodeB2.next = newNodeB3;
		ListNode newNodeB4 = new ListNode(1);
		newNodeB3.next = newNodeB4;

		/*
		 * ListNode a = new ListNode(1); ListNode b = new ListNode(3);
		 * 
		 * ListNode newNode = new ListNode(2); a.next = newNode;
		 * 
		 * ListNode newNodeB = new ListNode(4); b.next = newNodeB; ListNode newNodeB2 =
		 * new ListNode(5); newNodeB.next = newNodeB2;
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
