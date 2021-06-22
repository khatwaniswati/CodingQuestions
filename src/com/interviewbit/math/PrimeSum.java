package com.interviewbit.math;

import java.util.ArrayList;
import java.util.Collections;

public class PrimeSum {
	public static void main(String[] args) {
		System.out.println(primesum(4));
		System.out.println(primesum(74));
		System.out.println(primesum(1024));
		System.out.println(primesum(66));
		System.out.println(primesum(9990));
		System.out.println(primesum(16777214));//31 16777183//[15, 16777199]
	}

	public static ArrayList<Integer> primesum(int A) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = A-1; i >0; i--) {
			if(isPrime(i) && A-i>=2 && isPrime(A-i)) {
				result.add(i);
				break;
			}
		}
		result.add(A-result.get(0));
		Collections.sort(result);
		return result;
	}

	private static boolean isPrime(int n) {
			if (n <= 1)
				return false;
			else if (n == 2)
				return true;
			else if (n % 2 == 0)
				return false;

			for (int i = 3; i <= Math.sqrt(n); i += 2) {
				if (n % i == 0)
					return false;
			}
			return true;
	}
}
