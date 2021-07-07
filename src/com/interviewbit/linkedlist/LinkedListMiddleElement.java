package com.interviewbit.linkedlist;

import java.util.Arrays;

class LinkedListMiddleElement {

	public static void main(String[] args) {
		ListNode createNodesFromList = LinkedListUtil.createNodesFromList(Arrays.asList(1,2,3,4,5,6,7));
		LinkedListMiddleElement m = new LinkedListMiddleElement();
		ListNode middleNode = m.middleNode(createNodesFromList);
		System.out.println(middleNode);
	}

	public ListNode middleNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

}