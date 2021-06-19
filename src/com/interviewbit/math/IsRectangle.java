package com.interviewbit.math;

import java.util.ArrayList;
import java.util.List;

public class IsRectangle {
	public static void main(String[] args) {
		System.out.println(solve(1, 1, 1, 1));
		System.out.println(solve(1, 2, 3, 4));
		System.out.println(solve(2,3,2,2));
	}

	public static int solve(int A, int B, int C, int D) {
		List<Integer> uniqueSidesCount = new ArrayList<>();
		uniqueSidesCount.add(A);
		uniqueSidesCount.add(B);
		uniqueSidesCount.add(C);
		uniqueSidesCount.add(D);
		long count = uniqueSidesCount.stream().distinct().count();
		if(count==2 || count==1) {
			int first = uniqueSidesCount.get(0);
			return uniqueSidesCount.stream().filter(i->i==first).count()%2==0?1:0;
		}else {
			return 0;
		}
	}
}
