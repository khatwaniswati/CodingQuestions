package com.interviewbit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimeComplexityPrimeNo {

	public static void main(String[] args) {
		System.out.println(allPrimesTill(10));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=sc.nextInt();
		}
		sc.close();
		for (int i = 0; i < n; i++) {
			System.out.println(isPrime(arr[i]));
		}
	}

	private static int isPrime(int A) {
		if(A==1)
			return 1;
		else if(A==2)
			return 1;
		else if(A%2==0)
			return 0;
		else {
			for (int i = 3; i <= Math.sqrt(A); i++) {
				if(A%i==0)
					return 0;
			}
		}
		
		return 1;
	}
	private static List<Integer> allPrimesTill(int A) {
		List<Integer> lst = new ArrayList<>();
		if(2<=A)
			lst.add(2);
		for(int i=3;i<=A;i=i+2) {
			if(isPrime(i)==1)
				lst.add(i);
		}
		return lst;
	}
}