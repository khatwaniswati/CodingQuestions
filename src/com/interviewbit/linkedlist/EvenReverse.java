package com.interviewbit.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Definition for singly-linked list. class ListNode { public int val; public
 * ListNode next; ListNode(int x) { val = x; next = null; } }
 */
/**
 * 
 * Store the even positioned and odd positioned nodes in 2 vectors. now reverse
 * the even position vectors and then Recombine them to form a linked list. All
 * of this will happen in O(n) time. 1 2 3 4 -> 1 4 3 2 1 2 3 -> 1 2 3
 *
 */
public class EvenReverse {
	public static void main(String[] args) {
		ListNode A = LinkedListUtil.createNodesFromList(Arrays.asList(1, 2, 3));
		LinkedListUtil.printList(A);
		ListNode result = solve(A);
		LinkedListUtil.printList(result);
	}

	public static ListNode solve(ListNode A) {
		ListNode trav = A;
		int counter = 1;
		List<Integer> even = new ArrayList<>();
		List<Integer> odd = new ArrayList<>();
		while (trav != null) {
			if (counter % 2 == 0) {
				even.add(trav.val);
			} else {
				odd.add(trav.val);
			}
			trav = trav.next;
			counter++;
		}
		Collections.reverse(even);

		// System.out.println(even);
		// System.out.println(odd);

		trav = A;
		counter = 1;
		int evenCounter = 0;
		int oddCounter = 0;
		while (trav != null) {
			if (counter % 2 == 0) {
				trav.val = even.get(evenCounter);
				evenCounter++;
			} else {
				trav.val = odd.get(oddCounter);
				oddCounter++;
			}
			trav = trav.next;
			counter++;
		}
		return A;
	}
}
