package com.interviewbit.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		System.out.println(gcd(6, 9));
		System.out.println(gcd(5, 7));
		System.out.println(gcd(1, 0));
		
		System.out.println(gcdCopied(6, 9));
		System.out.println(gcdCopied(5, 7));
		System.out.println(gcdCopied(1, 0));
	}

	public static int gcd(int A, int B) {
		if (A == 0)
			return B;
		if (B == 0)
			return A;
		Map<Integer, Integer> primeFactorsA = primeFactors(A);
		Map<Integer, Integer> primeFactorsB = primeFactors(B);
		// System.out.println(primeFactorsA);
		// System.out.println(primeFactorsB);
		int result = 1;
		for (Entry<Integer, Integer> entry : primeFactorsA.entrySet()) {
			if (primeFactorsB.containsKey(entry.getKey())) {
				int coefficient = Math.min(primeFactorsB.get(entry.getKey()), entry.getValue());
				result *= Math.pow(entry.getKey(), coefficient);
			}
		}
		return result;
	}

	private static int gcdCopied(int A, int B) {
		while (B > 0){
			int c = A % B;
			A = B;
			B = c;
		}
		return A;
	}

	public static Map<Integer, Integer> primeFactors(int A) {
		Map<Integer, Integer> map = new HashMap<>();
		int n = A;
		for (Integer i : getAllPrimes(n)) {
			while (A % i == 0) {
				A = A / i;
				if (map.containsKey(i)) {
					Integer integer = map.get(i);
					map.put(i, integer + 1);
				} else {
					map.put(i, 1);
				}
			}
		}
		return map;
	}

	private static List<Integer> getAllPrimes(int n) {
		List<Integer> getPrimes = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if (isPrime(i))
				getPrimes.add(i);
		}
		return getPrimes;
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