package com.interviewbit.math;

public class FibonacciSolutionCopy {
	public static void main(String[] args) {
		int n = 50;

		System.out.println(solve(n));
	}

	public static int solve(int a) {
		if (a == 1)
			return 1;
		long[][] arr = { { 1, 1 }, { 1, 0 } };
		long[][] arr1 = { { 1, 1 }, { 1, 0 } };
		arr = pow(arr, arr1, a - 1);
		// System.out.println(Arrays.toString(arr[0]) + ":" + Arrays.toString(arr[1]));
		return (int) (arr[0][0] % 1000000007);
	}

	public static long[][] pow(long[][] a, long[][] b, int p) {
		if (p == 1)
			return a;
		long[][] r = pow(a, b, p / 2);
		long[][] x = matMul(r, r);
		if (p % 2 == 0)
			return x;
		return matMul(x, b);
	}

	public static long[][] matMul(long[][] r, long[][] a) {
		long j = ((r[0][0] * a[0][0]) % 1000000007 + (r[0][1] * a[1][0]) % 1000000007) % 1000000007;
		long k = ((r[0][0] * a[0][1]) % 1000000007 + (r[0][1] * a[1][1]) % 1000000007) % 1000000007;
		long l = ((r[1][0] * a[0][0]) % 1000000007 + (r[1][1] * a[1][0]) % 1000000007) % 1000000007;
		long m = ((r[1][0] * a[0][1]) % 1000000007 + (r[1][1] * a[1][1]) % 1000000007) % 1000000007;
		r[0][0] = j;
		r[0][1] = k;
		r[1][0] = l;
		r[1][1] = m;
		return r;
	}
}