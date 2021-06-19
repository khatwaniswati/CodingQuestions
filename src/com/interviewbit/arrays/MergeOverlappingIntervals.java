package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */

public class MergeOverlappingIntervals {
	public static void main(String[] args) {
		ArrayList<Interval> arr = new ArrayList<>();

		/*
		 * arr.add(new Interval(1, 3)); arr.add(new Interval(2, 6)); arr.add(new
		 * Interval(8, 10)); arr.add(new Interval(9, 18));
		 * System.out.println(merge2(arr));
		 */

		arr.add(new Interval(4, 100));
		arr.add(new Interval(48, 94));
		arr.add(new Interval(16, 21));
		arr.add(new Interval(58, 71));
		arr.add(new Interval(36, 53));
		arr.add(new Interval(49, 68));
		arr.add(new Interval(18, 42));
		arr.add(new Interval(37, 90));
		arr.add(new Interval(68, 75));
		arr.add(new Interval(6, 57));
		arr.add(new Interval(25, 78));
		arr.add(new Interval(58, 79));
		arr.add(new Interval(18, 29));
		arr.add(new Interval(69, 94));
		arr.add(new Interval(5, 31));
		arr.add(new Interval(10, 87));
		arr.add(new Interval(21, 35));
		arr.add(new Interval(1, 32));
		arr.add(new Interval(7, 24));
		arr.add(new Interval(17, 85));
		arr.add(new Interval(30, 95));
		arr.add(new Interval(5, 63));
		arr.add(new Interval(1, 17));
		arr.add(new Interval(67, 100));
		arr.add(new Interval(53, 55));
		arr.add(new Interval(30, 63));
		arr.add(new Interval(7, 76));
		arr.add(new Interval(33, 51));
		arr.add(new Interval(62, 68));
		arr.add(new Interval(78, 83));
		arr.add(new Interval(12, 24));
		arr.add(new Interval(31, 73));
		arr.add(new Interval(64, 74));
		arr.add(new Interval(33, 40));
		arr.add(new Interval(51, 63));
		arr.add(new Interval(17, 31));
		arr.add(new Interval(14, 29));
		arr.add(new Interval(9, 15));
		arr.add(new Interval(39, 70));
		arr.add(new Interval(13, 67));
		arr.add(new Interval(27, 100));
		arr.add(new Interval(10, 71));
		arr.add(new Interval(18, 47));
		arr.add(new Interval(48, 79));
		arr.add(new Interval(70, 73));
		arr.add(new Interval(44, 59));
		arr.add(new Interval(68, 78));
		arr.add(new Interval(24, 67));
		arr.add(new Interval(32, 70));
		arr.add(new Interval(29, 94));
		arr.add(new Interval(45, 90));
		arr.add(new Interval(10, 76));
		arr.add(new Interval(12, 28));
		arr.add(new Interval(31, 78));
		arr.add(new Interval(9, 44));
		arr.add(new Interval(29, 83));
		arr.add(new Interval(21, 35));
		arr.add(new Interval(46, 93));
		arr.add(new Interval(66, 83));
		arr.add(new Interval(21, 72));
		arr.add(new Interval(29, 37));
		arr.add(new Interval(6, 11));
		arr.add(new Interval(56, 87));
		arr.add(new Interval(10, 26));
		arr.add(new Interval(11, 12));
		arr.add(new Interval(15, 88));
		arr.add(new Interval(3, 13));
		arr.add(new Interval(56, 70));
		arr.add(new Interval(40, 73));
		arr.add(new Interval(25, 62));
		arr.add(new Interval(63, 73));
		arr.add(new Interval(47, 74));
		arr.add(new Interval(8, 36));
		System.out.println(merge(arr));
		System.out.println(mergecopied(arr));

		/*
		 * arr.add(new Interval(3, 5)); arr.add(new Interval(10, 3)); arr.add(new
		 * Interval(8, 10)); System.out.println(merge2(arr));
		 */

	}

	public static ArrayList<Interval> merge2(ArrayList<Interval> intervals) {
		ArrayList<Interval> result = new ArrayList<>();
		Interval interval = intervals.stream().map(sortInterval).reduce(mergeReduce).get();
		System.out.println(interval);
		return intervals;
	}

	private static Function<Interval, Interval> sortInterval = i -> {
		if (i.start > i.end) {
			int temp = i.start;
			i.start = i.end;
			i.end = temp;
		}
		return i;
	};
	private static BinaryOperator<Interval> mergeReduce = (i1, i2) -> {
		if ((i2.start <= i1.end && i1.start <= i2.start) || (i2.end >= i1.start && i1.end >= i2.end)
				|| (i2.start <= i1.start && i2.end >= i1.end))
			return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
		return i1;
	};

	public static ArrayList<Interval> mergecopied(ArrayList<Interval> a) {
		Collections.sort(a, (m,n) -> Integer.compare(m.start, n.start));
		Stack<Interval> s = new Stack<>();
		s.push(new Interval(a.get(0).start, a.get(0).end));
		for (int i = 1; i < a.size(); i++) {
			if (s.peek().end >= a.get(i).start) {
				int st = s.peek().start;
				int m = Math.max(s.peek().end, a.get(i).end);
				s.pop();
				s.push(new Interval(st, m));
			} else {
				s.push(new Interval(a.get(i).start, a.get(i).end));
			}
		}
		ArrayList<Interval> ans = new ArrayList<>();
		while (!s.isEmpty()) {
			Interval rem = s.peek();
			s.pop();
			ans.add(0, rem);
		}
		return ans;

	}

	boolean compareInterval(Interval a, Interval b) {
		return (a.start < b.start);
	}

	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> result = new ArrayList<>();
		int overlap = 0;
		Collections.sort(intervals, (m,n) -> Integer.compare(m.start, n.start));
		for (int i = 0; i < intervals.size() - 1; i++) {
			if (intervals.get(i).start > intervals.get(i).end) {
				int temp = intervals.get(i).start;
				intervals.get(i).start = intervals.get(i).end;
				intervals.get(i).end = temp;
			}
			if (intervals.get(i + 1).start > intervals.get(i + 1).end) {
				int temp = intervals.get(i + 1).start;
				intervals.get(i + 1).start = intervals.get(i + 1).end;
				intervals.get(i + 1).end = temp;
			}
			System.out.println(i + " " + intervals.get(i));
			List<Integer> minList = new ArrayList<>();
			List<Integer> maxList = new ArrayList<>();
			boolean flag = true;
			Interval newInterval = null;
			while (i < intervals.size() - 1 && ((intervals.get(i + 1).start <= intervals.get(i).end
					&& intervals.get(i).start <= intervals.get(i + 1).start)
					|| (intervals.get(i + 1).end >= intervals.get(i).start
							&& intervals.get(i).end >= intervals.get(i + 1).end)
					|| (intervals.get(i + 1).start <= intervals.get(i).start
							&& intervals.get(i + 1).end >= intervals.get(i).end))) {

				minList.add(Math.min(intervals.get(i).start, intervals.get(i + 1).start));
				maxList.add(Math.max(intervals.get(i).end, intervals.get(i + 1).end));
				flag = false;
				i++;
				overlap++;
				if (i < intervals.size() - 1) {
					if (intervals.get(i).start > intervals.get(i).end) {
						int temp = intervals.get(i).start;
						intervals.get(i).start = intervals.get(i).end;
						intervals.get(i).end = temp;
					}
					if (intervals.get(i + 1).start > intervals.get(i + 1).end) {
						int temp = intervals.get(i + 1).start;
						intervals.get(i + 1).start = intervals.get(i + 1).end;
						intervals.get(i + 1).end = temp;
					}
				}
			}
			if (!flag) {
				int min = minList.stream().reduce(Integer::min).get();
				int max = maxList.stream().reduce(Integer::max).get();
				result.add(new Interval(min, max));
			} else {
				result.add(intervals.get(i));
			}
		}
		// System.out.println(intervals.size()-overlap+" "+result.size());
		if (intervals.size() - overlap > result.size())
			result.add(intervals.get(intervals.size() - 1));

		return result;
	}
}
