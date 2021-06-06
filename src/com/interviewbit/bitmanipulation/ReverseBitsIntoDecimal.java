package com.interviewbit.bitmanipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseBitsIntoDecimal {
	public static void main(String[] args) {
		long a = 3;
		System.out.println(reverse(a));
		System.out.println(copiedReverse(a));
	}

	public static long reverse(long a) {
		List<Integer> bits = new ArrayList<>();
		int count = 0;
		while (a >= 1) {
			int rem = (int) (a % 2);
			a = a / 2;
			if (rem == 1)
				count++;
			// System.out.println(rem + " " + a);
			bits.add(rem);
		}

		Collections.reverse(bits);
		String collect = bits.stream().map(i -> Integer.toString(i)).collect(Collectors.joining());
		int cnt = 32 - collect.length();
		StringBuilder join = new StringBuilder(String.join("", Collections.nCopies(cnt, "0")));
		join.append(collect);
		join.reverse();
		// System.out.println(join);
		long parseUnsignedLong = Long.parseUnsignedLong(join.toString(), 2);
		return parseUnsignedLong;
	}

	public static long copiedReverse(long a) {
		long out = 0;

		for (int i = 0; i < 32; i++) {

			out = out << 1L;
			if ((a & 1L) == 1L) {
				out += 1;
			}

			a = a >>> 1L;

		}

		return out;
	}
}
