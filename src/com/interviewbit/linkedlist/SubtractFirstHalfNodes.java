package com.interviewbit.linkedlist;

/**
 * Definition for singly-linked list. class ListNode { public int val; public
 * ListNode next; ListNode(int x) { val = x; next = null; } }
 */
public class SubtractFirstHalfNodes {
	public static void main(String[] args) {
		ListNode a = new ListNode(1);

		ListNode newNode = new ListNode(2);
		a.next = newNode;
		ListNode newNode2 = new ListNode(3);
		newNode.next = newNode2;
		ListNode newNode3 = new ListNode(4);
		newNode2.next = newNode3;
		/*
		 * ListNode newNode4 = new ListNode(5); newNode3.next = newNode4;
		 */
		LinkedListUtil.printList(subtract(a));
	}

	public static ListNode subtract(ListNode A) {
		ListNode trav = A;
		ListNode result = A;
		int lenA = LinkedListUtil.findLengthOfLinkedList(A);
		int count = lenA / 2;

		for (int j = 0; j < lenA - count; j++) {
			trav = trav.next;
		}

		int[] lastNodes = new int[count];
		for (int i = lenA - count, counter = count - 1; i < lenA && counter >= 0; i++, counter--) {
			lastNodes[counter] = trav.val;
			trav = trav.next;
		}
		for (int i = 0; i < lastNodes.length; i++) {
			result.val = lastNodes[i] - result.val;
			result = result.next;
		}
		return A;
	}
}
