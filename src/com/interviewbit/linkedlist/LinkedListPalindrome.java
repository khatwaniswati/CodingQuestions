package com.interviewbit.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LinkedListPalindrome {
	public static void main(String[] args) {
		ListNode createNodesFromList = LinkedListUtil.createNodesFromList(Arrays.asList(10,7,10,7));
		System.out.println(lPalin(createNodesFromList));
	}

	public static int lPalin(ListNode A) {
		List<Integer> s = new ArrayList<>();
		List<Integer> rev = new ArrayList<>();
		while (A != null) {
			s.add(A.val);
			rev.add(A.val);
			A = A.next;
		}
		Collections.reverse(rev);
		System.out.println(s+" "+rev);
		if (s.equals(rev))
			return 1;
		else
			return 0;
	}
}
