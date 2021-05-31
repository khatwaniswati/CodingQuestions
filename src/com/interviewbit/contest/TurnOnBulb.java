package com.interviewbit.contest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TurnOnBulb {
	public static void main(String[] args) {
		//System.out.println(solve(51007));
		//System.out.println(solve(90645));//30216 36258
		System.out.println(solve(48687));//16230 19475
	}
	public static int solve(int A) {
		if(A==2)
			return 2;
		int steps=0;
		List<Integer> bulbs = new ArrayList<>();
		IntStream.range(0, A).forEach(i->bulbs.add(0));
		System.out.println(bulbs);
		for (int i = 2; i < A; i++) {
			if(bulbs.get(i)==1) {
				i+=2;
				continue;
			}
			if(bulbs.get(i)==0) {
				bulbs.set(i, 1);
				if(bulbs.contains(0)) {
					steps++;
				}else {
					break;
				}
				if((i-2)<A && (i-2)>=0) {
					bulbs.set(i-2, 1);
				}
				if((i+2)<A) {
					bulbs.set(i+2, 1);
				}
			}
		}
		if(bulbs.contains(0))
			steps++;
		System.out.println(bulbs);
		return steps;
	}
}
