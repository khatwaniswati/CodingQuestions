package com.interviewbit.linkedlist;

import java.util.Arrays;

class MergeTwoSortedLinkedList {

	public static void main(String[] args) {
		ListNode l1 = LinkedListUtil.createNodesFromList(Arrays.asList(0));
		ListNode l2 = LinkedListUtil.createNodesFromList(Arrays.asList());
		MergeTwoSortedLinkedList m = new MergeTwoSortedLinkedList();
		LinkedListUtil.printList(m.mergeTwoLists(l1, l2));
	}

	public ListNode mergeTwoLists(ListNode A, ListNode B) {
		ListNode l1Pointer = A;
		ListNode l2Pointer = B;
		ListNode resultHead = null;
		ListNode trav = null;
		while (l1Pointer != null && l2Pointer != null) {
			int nodeVal = 0;
			if (l1Pointer.val < l2Pointer.val) {
				nodeVal = l1Pointer.val;
				l1Pointer = l1Pointer.next;
			} else {
				nodeVal = l2Pointer.val;
				l2Pointer = l2Pointer.next;
			}
			if (resultHead == null) {
				resultHead = new ListNode(nodeVal);
				trav = resultHead;
			} else {
				ListNode newNode = new ListNode(nodeVal);
				trav.next = newNode;
				trav=trav.next;
			}
		}
		while (l1Pointer != null) {
			if (resultHead == null) {
				resultHead = new ListNode(l1Pointer.val);
				trav = resultHead;
			} else {
				ListNode newNode = new ListNode(l1Pointer.val);
				trav.next = newNode;
				trav = trav.next;
			}
			l1Pointer = l1Pointer.next;
		}
		while (l2Pointer != null) {
			if (resultHead == null) {
				resultHead = new ListNode(l2Pointer.val);
				trav = resultHead;
			} else {
				ListNode newNode = new ListNode(l2Pointer.val);
				trav.next = newNode;
				trav = trav.next;
			}
			l2Pointer = l2Pointer.next;
		}
		return resultHead;
	}

}