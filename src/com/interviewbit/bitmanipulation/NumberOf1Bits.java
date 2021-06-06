package com.interviewbit.bitmanipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumberOf1Bits {
	public static void main(String[] args) {
		long a = 11;
		System.out.println(numSetBits(a));
		System.out.println(copiedNumSetBits(a));
	}

	public static int numSetBits(long a) {
		List<Integer> bits = new ArrayList<>();
		int count = 0;
		while (a >= 1) {
			int rem = (int) (a % 2);
			a = a / 2;
			if (rem == 1)
				count++;
			System.out.println(rem + " " + a);
			bits.add(rem);
		}

		Collections.reverse(bits);
		String collect = bits.stream().map(i -> Integer.toString(i)).collect(Collectors.joining());
		int cnt = 32 - collect.length();
		String join = String.join("", Collections.nCopies(cnt, "0")) + collect;
		System.out.println(join);

		return count;
	}

	public static int copiedNumSetBits(long a) {
		int count = 0;
		while (a > 0) {
			System.out.println(a&1);
			if ((a & 1) == 1) {
				count = count + 1;
			}
			a = a >> 1;
		}
		return count;
	}

}
