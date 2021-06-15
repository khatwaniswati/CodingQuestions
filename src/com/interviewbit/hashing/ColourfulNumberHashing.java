package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ColourfulNumberHashing {
	public static void main(String[] args) {
		System.out.println(copiedColorful(234));
		System.out.println(colorful(234));
	}

	public static int copiedColorful(int a) {
		String A = Integer.toString(a);
		HashSet<Integer> set = new HashSet<Integer>();
		int prod = 0;
		for (int i = 0; i < A.length(); i++) {
			prod = 1;
			for (int j = i; j < A.length(); j++) {
				prod *= A.charAt(j) - '0';
				System.out.println(i+" "+j+" "+prod);
				if (set.contains(prod))
					return 0;
				else
					set.add(prod);
			}
		}
		System.out.println(set);
		return 1;
	}

	public static int colorful(int A) {
		List<Long> singles = getSingleDigits(A);

		int len = singles.size();
		if (len == 1)
			return 1;

		String collect = singles.stream().map(s -> s.toString()).collect(Collectors.joining());
		if (singles.stream().distinct().count() == len) {
			List<Long> products = new ArrayList<>();
			products.addAll(singles);

			int fullNumber = Integer.parseInt(collect.toString());
			long product = getProduct(fullNumber);
			if (products.contains(product))
				return 0;
			singles.add((long) fullNumber);

			for (int i = 2; i < len; i++) {
				for (int j = 0; j <= len - i; j++) {
					singles.add(Long.parseLong(collect.substring(j, i + j)));
					product = getProduct(Integer.parseInt(collect.substring(j, i + j)));
					if (products.contains(product))
						return 0;
					products.add(product);
				}
			}
			return 1;
		} else {
			return 0;
		}
	}

	private static List<Long> getSingleDigits(int a) {
		List<Long> lst = new ArrayList<>();
		while (a != 0) {
			lst.add((long) a % 10);
			a = a / 10;
		}
		Collections.reverse(lst);
		return lst;
	}

	private static long getProduct(int a) {
		long product = 1;
		while (a != 0) {
			product *= (a % 10);
			a = a / 10;
		}
		return product;
	}
}
