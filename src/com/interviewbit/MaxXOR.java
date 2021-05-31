package com.interviewbit;

import java.util.ArrayList;

public class MaxXOR {
	public static void main(String[] args) {
		solve(2);
	}
	public static ArrayList<Integer> solve(int A) {
		ArrayList<Integer> result = new ArrayList<>();
		//int[][] arr = new int[A][A];
		for(int i=1; i<=A; i++) {
			for(int j=1; j<=A; j++) {
				//arr[i][j]=i*10+j;
				if(i!=j)
					result.add(i^j);
			}
		}
		System.out.println(result);
		System.out.println(result.stream().reduce(Integer::max));
		return result;
	}
}
