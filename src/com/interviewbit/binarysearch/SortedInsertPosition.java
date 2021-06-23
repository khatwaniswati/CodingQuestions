package com.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortedInsertPosition {
	public static void main(String[] args) {
		System.out.println(searchInsert(new ArrayList<>(Arrays.asList(1, 3, 5, 6)), 5));
		System.out.println(searchInsert(new ArrayList<>(Arrays.asList( 3, 5, 6)), 2));
	}

	public static int searchInsert(ArrayList<Integer> a, int b) {
		int binarySearch = Collections.binarySearch(a, b);
		return binarySearch<0?(-1*binarySearch)-1:binarySearch;
	}
}
