package com.interviewbit.arrays;

import java.util.Arrays;

class MergeIntervals {

	public static void main(String[] args) {
		int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
		int[][] arrResult = merge(arr);
		for (int[] is : arrResult) {
			System.out.println(Arrays.toString(is));
		}
	}

	public static int[][] merge(int[][] intervals) {
		int[][] result = new int[intervals.length][2];
		int cntReduce=0;
		for (int i = 0; i < intervals.length-1; i++) {
			int[] first = intervals[i];
			int[] second = intervals[i+1];
			System.out.println("fi:"+Arrays.toString(first));
			System.out.println("se:"+Arrays.toString(second));
			if(second[0]<=first[1]) {
				result[i][0] = Math.min(first[0], second[0]);
				result[i][1] = Math.max(first[1], second[1]);
				cntReduce++;
				i++;
			}else {
				result[i][0] = first[0];
				result[i][1] = first[1];
			}
		}
		result[intervals.length-1-cntReduce][0] = intervals[intervals.length-1][0];
		result[intervals.length-1-cntReduce][1] = intervals[intervals.length-1][1];
		return result;
	}

}