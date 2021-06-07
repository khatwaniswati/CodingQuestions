package com.interviewbit.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionList {
	public static void main(String[] args) {
		ListNode createNodesFromList = LinkedListUtil.createNodesFromList(Arrays.asList(1,4,3,2,5,2));
		ListNode partition = partition(createNodesFromList, 3);
		LinkedListUtil.printList(partition);
	}
	public static ListNode partition(ListNode A, int B) {
		List<Integer> lst1 = new ArrayList<>();
		List<Integer> lst2 = new ArrayList<>();
		while(A!=null) {
			if(A.val>=B)
				lst2.add(A.val);
			else
				lst1.add(A.val);
			A=A.next;
		}
		lst1.addAll(lst2);
		return LinkedListUtil.createNodesFromList(lst1);
	}
}
