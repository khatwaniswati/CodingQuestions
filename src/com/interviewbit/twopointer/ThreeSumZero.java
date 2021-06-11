package com.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumZero {
	public static void main(String[] args) {
		// 1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3
		// output [[-5, 0, 5], [-5, 1, 4], [-4, -1, 5], [-4, 0, 4], [-4, 1, 3], [-3, -2,
		// 5], [-3, -1, 4], [-3, 0, 3], [-2, -1, 3], [-2, 1, 1], [-1, 0, 1], [0, 0, 0]]
		// -1, 0, 1, 2, -1, -4 //[[-1, -1, 2], [-1, 0, 1]]
		// 2147483647, -2147483648, -2147483648, 0, 1
		System.out.println(threeSum(new ArrayList<>(Arrays.asList(2147483647, -2147483648, -2147483648, 0, 1))));
	}

	public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> resultArrayList = new ArrayList<>();
		Collections.sort(A);
		for (int i = 0; i < A.size() - 2; i++) {// 3 elements sum so last element should have index n-3
			int ptr1 = i + 1;
			int ptr2 = A.size() - 1;

			while (ptr1 < ptr2) {
				long sum = (long) A.get(i) + (long) A.get(ptr1) + (long) A.get(ptr2);
				if (sum == 0) {
					ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(A.get(i), A.get(ptr1), A.get(ptr2)));
					if (!resultArrayList.contains(arrayList)) {
						resultArrayList.add(arrayList);
					}
					ptr2--;
				} else if (sum > 0)
					ptr2--;
				else
					ptr1++;
			}
		}
		return resultArrayList;
	}

}
