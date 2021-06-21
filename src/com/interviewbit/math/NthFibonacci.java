package com.interviewbit.math;

public class NthFibonacci {

	static int count = 0;

	public static void main(String[] args) {
		System.out.println(nthFibonacciSimple(10));
		System.out.println(nthFibonacciSimple(5));
		System.out.println(nthFibonacciSimple(3));

		System.out.println(nthFibonacciRecursion(10));
		System.out.println(nthFibonacciRecursion(5));
		System.out.println(nthFibonacciRecursion(3));

		System.out.println(dpFib(1000000000));
		System.out.println(count + "....");
		System.out.println(nthFibonacciMemoization(5));
		System.out.println(nthFibonacciMemoization(3));
		System.out.println(nthFibonacciMemoization(4));
		System.out.println(nthFibonacciMemoization(50));
	}

	private static int nthFibonacciSimple(int n) {
		int a = 0;
		int b = 1;

		if (n == 1)
			return 0;
		else if (n == 2)
			return 1;
		else {
			while (n - 2 > 0) {
				int c = a + b;
				a = b;
				b = c;
				n--;
			}
		}
		return b;
	}

	private static int nthFibonacciRecursion(int n) {
		if (n == 1)
			return 0;
		else if (n == 2)
			return 1;
		else {
			return nthFibonacciRecursion(n - 1) + nthFibonacciRecursion(n - 2);
		}
	}

	private static int nthFibonacciMemoization(int A) {
		int[] fib = new int[A + 1];
		return memoization(A, fib);
	}

	private static int memoization(int A, int[] fib) {
		if (fib[A] == 0) {
			if (A <= 1)
				return fib[A] = A;
			else
				fib[A] = memoization(A - 1, fib) + memoization(A - 2, fib);
		}
		return (int) fib[A] % (1000000007);
	}

	public static int dpFib(int n) {
		int[] terms = new int[n + 1];
		terms[1] = terms[2] = 1;
		for (int i = 3; i <= n; i++)
			terms[i] = (terms[i - 1] + terms[i - 2])% (1000000007);
		return (int)terms[n]% (1000000007);
	}
}
