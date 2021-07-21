package com.interviewbit.linkedlist;

import java.util.Arrays;

class RemoveNthNodeFromListEnd {
	public static void main(String[] args) {
		ListNode A = LinkedListUtil.createNodesFromList(Arrays.asList(20,380,349,322,389,424,429,120,64,691,677,58,327,631,916,203,484,918,596,252,509,644,33,460 ));
		ListNode result = removeNthFromEnd(A, 82);
		LinkedListUtil.printList(result);
	}

	public static ListNode removeNthFromEnd(ListNode A, int B) {
		ListNode result = A;
		int listSize = findLengthOfLinkedList(A);
		if(listSize<B) {
			result = A.next;
			return result;
		}
		int count = 0;
		ListNode prev = null;
		while (A != null) {
			if (count == listSize - B) {
				if (prev != null)
					prev.next = A.next;
				else
					result = A.next;
				break;
			}
			count++;
			prev = A;
			A = A.next;
		}
		return result;
	}

	public static int findLengthOfLinkedList(ListNode x) {
		if (x == null)
			return 0;
		int len = 1;
		while (x.next != null) {
			len++;
			x = x.next;
		}
		return len;
	}
}