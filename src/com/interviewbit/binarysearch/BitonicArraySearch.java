package com.interviewbit.binarysearch;

import java.util.Arrays;
import java.util.List;

public class BitonicArraySearch {

	public static void main(String[] args) {
		//List<Integer> asList = Arrays.asList(3, 9, 10, 20, 17, 5, 1);//20
		//List<Integer> asList = Arrays.asList(5, 6, 7, 8, 9, 10, 3, 2, 1);//30
		//List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11 );//12
		List<Integer> asList = Arrays.asList(1, 20, 50, 40, 10 );//5
		System.out.println(solve(asList, 5));
	}

	public static int solve(List<Integer> A, int B) {
		int len = A.size();
		int low = 0;
		int high = len - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (B == A.get(mid))
				return mid;
			else if (B > A.get(mid)) {
				if (mid+1<len && A.get(mid + 1) > A.get(mid))
					low = mid + 1;
				else
					high = mid - 1;
			} else {// B<A.get(mid)
				if (mid+1<len && A.get(mid + 1) > A.get(mid))
					high = mid - 1;
				else
					low = mid + 1;
			}
		}
		return -1;
	}

}
