package com.interviewbit.linkedlist;

import java.util.Arrays;

class RemoveDuplicatesFromSortedList {
	public static void main(String[] args) {
		/*
		 * ListNode deleteDuplicates = deleteDuplicates(
		 * LinkedListUtil.createNodesFromList(Arrays.asList(1 , 1 , 1 , 2 , 2 , 2 , 2 ,
		 * 2 , 2 , 3 , 3 , 5 , 5 , 6 , 7 , 7 , 7 , 7 , 7 , 8 , 8 , 9 , 10 , 11 , 11 , 11
		 * , 11 , 12 , 12 , 12 , 13 , 13 , 13 , 14 , 14 , 14 , 14 , 14 , 15 , 16 , 16 ,
		 * 17 , 17 , 17 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 19 , 19 , 19 , 19 , 20 , 20
		 * )));
		 */
		ListNode deleteDuplicates = deleteDuplicates(LinkedListUtil.createNodesFromList(Arrays.asList(1, 1, 2, 3 , 3)));
		LinkedListUtil.printList(deleteDuplicates);
	}

	public static ListNode deleteDuplicates(ListNode A) {
		ListNode result = A;
		while (A != null) {
			while (A.next != null && A.val == A.next.val) {
				A.next = A.next.next;
			}
			A = A.next;
		}
		return result;
	}
}