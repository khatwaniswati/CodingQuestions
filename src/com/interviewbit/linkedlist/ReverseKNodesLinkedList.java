package com.interviewbit.linkedlist;

import java.util.Arrays;

/**
 * Definition for singly-linked list. class ListNode { public int val; public
 * ListNode next; ListNode(int x) { val = x; next = null; } }
 */
public class ReverseKNodesLinkedList {
	public static void main(String[] args) {
		ListNode A = LinkedListUtil.createNodesFromList(Arrays.asList(1, 2, 3, 4, 5, 6));
		ListNode reverseList = reverseList(A, 2);
		LinkedListUtil.printList(reverseList);
	}

	public static ListNode reverseList(ListNode A, int B) {
		if(A==null)
			return A;
		ListNode helper = A;
		for (int i = B; i != 0; i--) {
			if(i>0 && helper==null)
				return A;
			helper=helper.next;
		}
		helper=A;
		ListNode prev = null;
		for (int i = B; i != 0; i--) {
			//swap
			ListNode temp = helper.next;
			helper.next=prev;
			prev = helper;
			helper=temp;
		}
		A.next=reverseList(helper, B);
		return prev;
	}
}
