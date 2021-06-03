package com.interviews;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class JPChaseRound2 {
	public static void main(String[] args) {
		
		int[] arr = {Integer.MIN_VALUE,0,Integer.MAX_VALUE};
		/*
		 * List<int[]> asList = Arrays.asList(arr); asList.stream().sorted()
		 */
		int min=arr[0];
		int secondMin=arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(min>arr[i]) {
				min=arr[i];
			}
			/*
			 * } for (int i = 1; i < arr.length; i++) {
			 */
			if(arr[i]!=min && secondMin>min && arr[i]<secondMin) {
				secondMin=arr[i];//10>1&&2<10
			}
		}
		System.out.println("Min:"+min);
		System.out.println("SecondMin:"+secondMin);
	}
	
	/*
	 * @PostMapping("/addBook",) public ResponseEntity<boolen> addBook(@RequestBody
	 * BookPojo) { return (status,boolean) }
	 */
}
