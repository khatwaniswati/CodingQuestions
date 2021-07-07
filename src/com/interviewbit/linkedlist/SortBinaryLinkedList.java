package com.interviewbit.linkedlist;

import java.util.Arrays;

public class SortBinaryLinkedList {
	public static void main(String[] args) {

		ListNode a = LinkedListUtil.createNodesFromList(Arrays.asList(1, 0, 0, 1));
		//ListNode a = LinkedListUtil.createNodesFromList(Arrays.asList(0,0,1,1,0));
		//ListNode a = LinkedListUtil.createNodesFromList(Arrays.asList(1,0));
		ListNode sortedNode = solve(a);
		LinkedListUtil.printList(sortedNode);
	}

	public static ListNode solve(ListNode A) {
		int zeroCnt = 0;
		int oneCnt = 0;
		ListNode copyOfA=A;
		while (A != null) {
			if (A.val == 0)
				zeroCnt += 1;
			else
				oneCnt += 1;
			A = A.next;
		}
		//LinkedListUtil.printList(copyOfA);
		//LinkedListUtil.printList(A);
		ListNode headNode = copyOfA;
		if (zeroCnt > 0) {
			headNode.val=0;
			ListNode parent = headNode;
			for (int i = 1; i < zeroCnt; i++) {
				parent.next.val = 0;
				parent = parent.next;
			}
			for (int i = 0; i < oneCnt; i++) {
				parent.next.val=1;
				parent = parent.next;
			}
		} else if (oneCnt > 0) {
			headNode.val=1;
			ListNode parent = headNode;
			for (int i = 1; i < oneCnt; i++) {
				parent.next.val=1;
				parent = parent.next;
			}
		}
		return headNode;
	}
}
