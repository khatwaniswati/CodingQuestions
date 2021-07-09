package com.interviewbit.arrays;

public class MaxTripletSum {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 3, 1, 4, 9 };
		System.out.println(maxTripletSum(arr, arr.length));
	}

	public static int maxTripletSum(int arr[], int n) {
		int sum = 0;
		for (int i = 0; i < arr.length-2; i++) {
			for (int j = i+1; j < arr.length-1; j++) {
				for (int k = j+1; k < arr.length; k++) {
					if(arr[i]<arr[j] && arr[j]<arr[k]) {
						int tempSum = arr[i]+arr[j]+arr[k];
						if( tempSum>sum)
							sum=tempSum;
					}
				}
			}
		}
		return sum;
	}

}
