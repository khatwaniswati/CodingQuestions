package com.codilityquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.util.Pair;

public class MaximumCheezeMouseCanHave {
	static List<Integer> maintainListToSum = new ArrayList<>();
	
	public static void main(String[] args) {
		/*
		 * Scanner sc = new Scanner(System.in); int t = sc.nextInt(); int[][] result =
		 * new int[t][]; for (int i = 0; i < t; i++) { int n = sc.nextInt(); int[] arr =
		 * new int[n]; for (int j = 0; j < n; j++) { arr[j]=sc.nextInt(); }
		 * result[i]=arr; } sc.close(); for (int i = 0; i < t; i++) {
		 * System.out.println(maxCheezeMouseCanHave(result[i])); }
		 */
		int[] arr = {9 ,118, 202 ,104 ,10,20,30};
		//System.out.println(maxCheezeMouseCanHave(arr));
		
		getLeftRightSubArraysForMax(arr);
		System.out.println(maintainListToSum);
	}

	private static long maxCheezeMouseCanHave(int[] arr) {
		int arrLength = arr.length;
		AtomicInteger max = getMax(arr);
		System.out.println(max.get());
		
		List<Integer> indexes = findMaxIndices(arr, max);
		System.out.println(indexes);
		
		for (int j = 0; j < indexes.size(); j++) {
			Integer maxIndex = indexes.get(j);
			Pair<int[], int[]> leftRightSubArrays = getLeftRightSubArrays(arr, maxIndex);
			System.out.println("left:"+Arrays.toString( leftRightSubArrays.getKey()));
			System.out.println("right:"+Arrays.toString( leftRightSubArrays.getValue()));
			/*
			 * if(maxIndex-1>=0) { int left=maxIndex-1;
			 * System.out.println("left:"+left+"element:"+arr[left]);
			 * 
			 * } if(maxIndex+1<arrLength) { int right = maxIndex+1;
			 * System.out.println("right:"+right+"element:"+arr[right]); }
			 */
		}
		
		return 0;
	}

	private int getMaxSum(int fixed, int[] leftSubArr, int[] rightSubArr) {
		int sum = fixed;
		
		return sum;
	}
	
	private static void getLeftRightSubArraysForMax(int[] arr){
		
		AtomicInteger max = getMax(arr);
		System.out.println(max.get());
		maintainListToSum.add(max.get());
		
		List<Integer> indexes = findMaxIndices(arr, max);
		
		Pair<int[], int[]> leftRightSubArrays = getLeftRightSubArrays(arr, indexes.get(0));
		int[] leftSubArray =  leftRightSubArrays.getKey();
		int[] rightSubArray =  leftRightSubArrays.getValue();
		System.out.println("left:"+Arrays.toString( leftSubArray));
		System.out.println("right:"+Arrays.toString(rightSubArray));
		
		if(leftSubArray!= null && leftSubArray.length != 0) {
			if(leftSubArray.length == 2 ) {
				maintainListToSum.add(Math.max(leftSubArray[0], leftSubArray[1]));
			}else {
				getLeftRightSubArraysForMax(leftSubArray);
			}
		}
		if(rightSubArray!=null && rightSubArray.length != 0) {
			if(rightSubArray.length == 2 ) {
				maintainListToSum.add(Math.max(rightSubArray[0], rightSubArray[1]));
			}else {
				getLeftRightSubArraysForMax(rightSubArray);
			}
		}
	}
	private static Pair<int[], int[]> getLeftRightSubArrays(int[] arr, int cutIndex){
		int arrLength = arr.length;
		int[] leftMaxArr=null;
		int[] rightMaxArr=null;
		if(cutIndex-2>=0) {
			leftMaxArr = Arrays.copyOfRange(arr, 0, cutIndex-1);
		}
		if(cutIndex+2<arrLength) {
			rightMaxArr = Arrays.copyOfRange(arr, cutIndex+2, arrLength);
		}
		return new Pair<int[], int[]>(leftMaxArr, rightMaxArr);
	}
	
	private static List<Integer> findMaxIndices(int[] arr, AtomicInteger max) {
		return IntStream.range(0, arr.length)
			.filter(i->arr[i]==max.get())
			.boxed()
			.collect(Collectors.toList());
	}

	private static int getFrequency(int[] arr, AtomicInteger max) {
		return Collections.frequency(Arrays.stream(arr).boxed().collect(Collectors.toList()), max.get());
	}

	private static AtomicInteger getMax(int[] arr) {
		AtomicInteger max = new AtomicInteger(); 
		Arrays.stream(arr)
										.boxed()
										.sorted(Comparator.reverseOrder())
										.findFirst().ifPresent(max::set);
		return max;
	}

}
/**
2
6
8 5 10 100 10 5
3
1 2 3
 */
