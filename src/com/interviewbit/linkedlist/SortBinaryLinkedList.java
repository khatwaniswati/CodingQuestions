package com.interviewbit.linkedlist;

import java.util.Arrays;

public class SortBinaryLinkedList {
	public static void main(String[] args) {

		//ListNode a = LinkedListUtil.createNodesFromList(Arrays.asList(1, 0, 0, 1));
		//ListNode a = LinkedListUtil.createNodesFromList(Arrays.asList(0,0,1,1,0));
		ListNode a = LinkedListUtil.createNodesFromList(Arrays.asList(1,0));
		ListNode sortedNode = solve(a);
		LinkedListUtil.printList(sortedNode);
	}

	public static ListNode solve(ListNode A) {
		int[] arr = new int[2];
		ListNode result=A;
		while (A != null) {
			if (A.val == 0)
				arr[0] += 1;
			else
				arr[1] += 1;
			A = A.next;
		}
		LinkedListUtil.printList(result);
		LinkedListUtil.printList(A);
		int zeroCnt = arr[0];
		int oneCnt = arr[1];
		ListNode headNode = null;
		if (zeroCnt > 0) {
			headNode = new ListNode(0);
			ListNode parent = headNode;
			for (int i = 1; i < zeroCnt; i++) {
				ListNode newNode = new ListNode(0);
				parent.next = newNode;
				parent = newNode;
			}
			for (int i = 0; i < oneCnt; i++) {
				ListNode newNode = new ListNode(1);
				parent.next = newNode;
				parent = newNode;
			}
		} else if (oneCnt > 0) {
			headNode = new ListNode(1);
			ListNode parent = headNode;
			for (int i = 1; i < oneCnt; i++) {
				ListNode newNode = new ListNode(1);
				parent.next = newNode;
				parent = newNode;
			}
		}
		return headNode;
	}
}
