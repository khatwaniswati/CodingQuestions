package com.interviewbit.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KthSmallestElementInArray {
	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(2,1,4,3,2);
		System.out.println(kthsmallest(lst, 3));
	}

	public static int kthsmallest(final List<Integer> A, int B) {
		List<Integer> collect = A.stream().sorted().collect(Collectors.toList());
		return collect.get(B-1);
	}
}
