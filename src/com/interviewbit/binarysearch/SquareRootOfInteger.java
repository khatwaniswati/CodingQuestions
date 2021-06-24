package com.interviewbit.binarysearch;

import java.math.BigInteger;

public class SquareRootOfInteger {
	public static void main(String[] args) {
		System.out.println(sqrt(17));
		System.out.println(sqrt(11));
		System.out.println(sqrt(9));
		System.out.println(sqrt(Integer.MAX_VALUE));
		System.out.println(sqrt(Integer.MIN_VALUE));

	}

	public static int sqrtUsingLibrary(int A) {
		return (int) Math.floor(Math.sqrt(A));
	}

	public static int sqrt(int A) {
		if (A == 0 || A == 1)
			return A;
		int l = 0, h = A;
		while (l <= h && l >= 0) {
			// System.out.println(l + " " + h);
			BigInteger a = new BigInteger(l + "");
			BigInteger b = new BigInteger(h + "");
			BigInteger add = a.add(b);
			BigInteger divide = add.divide(new BigInteger(2 + ""));
			BigInteger mid = new BigInteger(divide + "");
			BigInteger midSq = new BigInteger(mid.multiply(mid) + "");
			// System.out.println(midSq + " " + A);
			// System.out.println(midSq.compareTo(new BigInteger(A + "")));
			if (midSq.equals(A)) {
				break;
			} else if (midSq.compareTo(new BigInteger(A + "")) > 0)
				h = mid.intValue() - 1;
			else
				l = mid.intValue() + 1;
			// System.out.println(mid + " " + midSq + " " + l + " " + " " + h);
		}
		return h;
	}
}
