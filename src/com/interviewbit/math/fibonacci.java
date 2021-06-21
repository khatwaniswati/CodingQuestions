package com.interviewbit.math;

//Fibonacci Series using Optimized Method
class fibonacci {
	/* function that returns nth Fibonacci number */
	static int fib(int n) {
		int F[][] = new int[][] { { 1, 1 }, { 1, 0 } };
		if (n == 0)
			return 0;
		power(F, n - 1);

		return (F[0][0])%(1000000007);
	}

	static void multiply(int F[][], int M[][]) {
		int x = (((F[0][0]%1000000007) * (M[0][0]%1000000007))%(1000000007) + ((F[0][1]%1000000007) * (M[1][0]%1000000007))%(1000000007))%(1000000007);
		int y = (((F[0][0]%1000000007) * (M[0][1]%1000000007))%(1000000007) + ((F[0][1]%1000000007) * (M[1][1]%1000000007))%(1000000007))%(1000000007);
		int z = (((F[1][0]%1000000007) * (M[0][0]%1000000007))%(1000000007) + ((F[1][1]%1000000007) * (M[1][0]%1000000007))%(1000000007))%(1000000007);
		int w = (((F[1][0]%1000000007) * (M[0][1]%1000000007))%(1000000007) + ((F[1][1]%1000000007) * (M[1][1]%1000000007))%(1000000007))%(1000000007);

		F[0][0] = x%(1000000007);
		F[0][1] = y%(1000000007);
		F[1][0] = z%(1000000007);
		F[1][1] = w%(1000000007);
	}

	/* Optimized version of power() in method 4 */
	static void power(int F[][], int n) {
		if (n == 0 || n == 1)
			return;
		int M[][] = new int[][] { { 1, 1 }, { 1, 0 } };

		power(F, n / 2);
		multiply(F, F);

		if (n % 2 != 0)
			multiply(F, M);
	}

	/* Driver program to test above function */
	public static void main(String args[]) {
		System.out.println(20%(1000000007));
		int n = 50;
		
		System.out.println(fib(n));
	}
}
/* This code is contributed by Rajat Mishra */
