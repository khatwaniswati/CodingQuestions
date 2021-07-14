package com.codilityquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumCheezeMouseCanHave {

	private static int maxSum = Integer.MIN_VALUE;

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>(Arrays.asList(8, 5, 10, 100, 10, 5));
		recursiveCall(arr, 0);
		System.out.println("Sum:" + maxSum);
		
		List<Integer> arr2 = new ArrayList<>(Arrays.asList(1,2,3));
		maxSum = Integer.MIN_VALUE;
		recursiveCall(arr2, 0);
		System.out.println("Sum:" + maxSum);
		
		List<Integer> arr3 = new ArrayList<>(Arrays.asList(9,118,202,104,10));
		maxSum = Integer.MIN_VALUE;
		recursiveCall(arr3, 0);
		System.out.println("Sum:" + maxSum);
	}

	private static void recursiveCall(List<Integer> subList, int count) {
		if (subList.isEmpty()) {
			if (maxSum < count)
				maxSum = count;
		} else {
			if (subList.size() == 2) {
				count += Math.max(subList.get(0), subList.get(1));
				recursiveCall(Collections.emptyList(), count);
			} else if (subList.size() == 1) {
				count += subList.get(0);
				recursiveCall(Collections.emptyList(), count);
			} else {
				if (subList.size() > 2) {
					List<Integer> subSubList = subList.subList(2, subList.size());
					recursiveCall(subSubList, count + subList.get(0));

					List<Integer> subList2 = subList.subList(3, subList.size());
					recursiveCall(subList2, count + subList.get(1));
				}
			}
		}
	}

}
