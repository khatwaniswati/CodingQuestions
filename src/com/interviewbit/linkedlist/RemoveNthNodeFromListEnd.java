package com.interviewbit.linkedlist;

import java.util.Arrays;

class RemoveNthNodeFromListEnd {
	public static void main(String[] args) {
		ListNode A = LinkedListUtil.createNodesFromList(Arrays.asList(1,2,3,4,5));
		ListNode result = removeNthFromEnd(A, 2);
		LinkedListUtil.printList(result);
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode result = head;
		
		return result;
	}
}