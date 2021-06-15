package com.interviewbit.hashing;

import java.util.Arrays;
import java.util.List;

public class DiffKHashing {
	public static int diffPossible(final List<Integer> A, int B) {
		if(A.size()==1)
			return 0;
		for (int i = 0; i < A.size(); i++) {
			if (A.contains(A.get(i) + B) && A.indexOf(A.get(i) + B)!=i ) {
				return 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(diffPossible(Arrays.asList(1,3,2), 0));
		//1, 5, 3 B=2 --> 1
		//1, 5, 4 B=2 -->0
		//0 B=0 -->0
		//1,3,2 B=0 -->0
		//1,3,3 B=0 -->1
	}

}
