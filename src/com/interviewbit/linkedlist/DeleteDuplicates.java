package com.interviewbit.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DeleteDuplicates {
	public static void main(String[] args) {
		ListNode A = LinkedListUtil.createNodesFromList(Arrays.asList(3,4,3,2,6,1,2,6));
		LinkedListUtil.printList(A);
		ListNode deleteDuplicates = moreImprovedDeleteDuplicates(A
				);
		
		// 1, 2, 3, 3, 4, 4, 5
		// 1,1,1,2,3
		//1,2,3,3,3
		//1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 6 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 7 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 9 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 10 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 12 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 13 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 14 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 15 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 16 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 17 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 18 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 
		LinkedListUtil.printList(deleteDuplicates);
	}

	public static ListNode deleteDuplicates(ListNode A) {
		List<Integer> result = new CopyOnWriteArrayList<>();
		List<Integer> removed = new ArrayList<>();
		while (A != null) {
			if (result.contains(A.val)) {
				result.remove(new Integer(A.val));
				removed.add(A.val);
			} else if (!removed.contains(A.val))
				result.add(A.val);
			A = A.next;
		}
		return LinkedListUtil.createNodesFromList(result);
	}

	public static ListNode improvedDeleteDuplicates(ListNode A) {
		List<Integer> resultLst = new ArrayList<>();
		while (A != null) {
			while (A!=null && A.next != null && A.val == A.next.val) {
				int val = A.val;
				while (A != null && A.val == val)
					A = A.next;
			}
			if(A!=null) {
				resultLst.add(A.val);
				A = A.next;
			}
		}
		
		return LinkedListUtil.createNodesFromList(resultLst);
	}
	
	public static ListNode moreImprovedDeleteDuplicates(ListNode head) {
		ListNode result = head;
		HashSet<Integer> resultLst = new HashSet<>();
		ListNode prev = null;
		while (head != null) {
			while(resultLst.contains(head.val)) {
				if(prev!=null) {
					if(head.next!=null && resultLst.contains(head.next.val)) {
						prev = head;
						head=head.next;
						continue;
					}
					prev.next=head.next;
				}
				if(head.next==null) {
					return result;
				}
				prev = head;
				head=head.next;
			}
			
			resultLst.add(head.val);
			
			prev = head;
			head=head.next;
		}
		
		return result;
	}
}
