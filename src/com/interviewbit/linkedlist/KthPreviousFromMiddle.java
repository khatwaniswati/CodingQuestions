package com.interviewbit.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for singly-linked list. class ListNode { public int val; public
 * ListNode next; ListNode(int x) { val = x; next = null; } }
 */
public class KthPreviousFromMiddle {
	public static void main(String[] args) {
		// ListNode createNodesFromList =
		// LinkedListUtil.createNodesFromList(Arrays.asList(3, 4, 7, 5, 6, 16, 15, 61,16));//3
		// ListNode createNodesFromList =LinkedListUtil.createNodesFromList(Arrays.asList(1 ,14 ,6 ,16 ,4 ,10));//2
		// ListNode createNodesFromList =LinkedListUtil.createNodesFromList(Arrays.asList(1,14,6,16,4,10));//10
		ListNode createNodesFromList = LinkedListUtil.createNodesFromList(Arrays.asList(468, 335));// 1
		KthPreviousFromMiddle m = new KthPreviousFromMiddle();
		System.out.println(m.solve(createNodesFromList, 1));
	}

	public int solve(ListNode A, int B) {
		ListNode fast = A;
		ListNode slow = A;
		int result = -1;
		List<Integer> lst = new ArrayList<>();
		while (fast != null && fast.next != null) {
			if (lst.size() > B)
				lst.remove(0);

			lst.add(slow.val);
			fast = fast.next.next;
			slow = slow.next;
		}
		if (!lst.isEmpty() && lst.size() >= B)
			result = lst.get(lst.size() - B);
		return result;
	}

	public int solveCopy(ListNode A, int B) {
		if (A == null)
			return -1;
		int length = 0;
		ListNode tmp = A;
		while (tmp != null) {
			length++;
			tmp = tmp.next;
		}
		int ix = (length / 2) + 1 - B - 1;
		if (ix < 0)
			return -1;
		while (ix > 0) {
			A = A.next;
			ix--;
		}
		return A.val;
	}
}
