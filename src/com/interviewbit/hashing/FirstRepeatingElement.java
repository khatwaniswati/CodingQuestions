package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FirstRepeatingElement {
	public static void main(String[] args) {
		System.out.println(
				solve(new ArrayList<>(Arrays.asList(8, 15, 1, 10, 5, 19, 19, 3, 5, 6, 6, 2, 8, 2, 12, 16, 3))));
		System.out.println(
				copiedSolve(new ArrayList<>(Arrays.asList(8, 15, 1, 10, 5, 19, 19, 3, 5, 6, 6, 2, 8, 2, 12, 16, 3))));
		// 10, 5, 3, 4, 3, 5, 6-->5
		// 6, 10, 5, 4, 9, 120-->-1
		// 8, 15, 1, 10, 5, 19, 19, 3, 5, 6, 6, 2, 8, 2, 12, 16, 3-->8
	}

	public static int solve(ArrayList<Integer> A) {
		HashSet<Integer> sett = new HashSet<>();
		int minIndex = A.size() + 1;
		for (int i = 0; i < A.size(); i++) {
			boolean add = sett.add(A.get(i));
			//System.out.println(i + " " + add + " " + A.indexOf(A.get(i)));
			if (!add && A.indexOf(A.get(i)) < minIndex) {
				minIndex = A.indexOf(A.get(i));
			}
			//System.out.println(minIndex);
		}
		if (minIndex == A.size() + 1)
			return -1;
		return A.get(minIndex);
	}

	public static int copiedSolve(ArrayList<Integer> A) {
		HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
		int ind_ans = 999999;
		for (int i = 0; i < A.size(); i++) {
			if (mp.containsKey(A.get(i))) {
				ind_ans = Math.min(mp.get(A.get(i)), ind_ans);
				// return i;
				mp.put(A.get(i), ind_ans);
			} else {
				mp.put(A.get(i), i);
			}
		}
		if (ind_ans != 999999)
			return A.get(ind_ans);
		else
			return -1;
	}
}
