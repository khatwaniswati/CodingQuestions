package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
class Interval{
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public String toString() {
		return "(" + start + ", " + end + ")";
	}

}

public class MergeIntervalsArrayList {
	public static void main(String[] args) {
		// [1,2],[3,5],[6,7],[8,10],[12,16]
		// A : [ (6037774, 6198243), (6726550, 7004541), (8842554, 10866536), (11027721,
		// 11341296),
		// (11972532, 14746848), (16374805, 16706396), (17557262, 20518214), (22139780,
		// 22379559),
		// (27212352, 28404611), (28921768, 29621583), (29823256, 32060921), (33950165,
		// 36418956),
		// (37225039, 37785557), (40087908, 41184444), (41922814, 45297414), (48142402,
		// 48244133),
		// (48622983, 50443163), (50898369, 55612831), (57030757, 58120901), (59772759,
		// 59943999),
		// (61141939, 64859907), (65277782, 65296274), (67497842, 68386607), (70414085,
		// 73339545),
		// (73896106, 75605861), (79672668, 84539434), (84821550, 86558001), (91116470,
		// 92198054), (96147808, 98979097) ]
		// B : (36210193, 61984219)
		ArrayList<Interval> arr = new ArrayList<>();

		/*
		 * arr.add(new Interval(1, 3)); arr.add(new Interval(6, 9));
		 * System.out.println(insert(arr, new Interval(1,5)));
		 */

		/*
		 * arr.add(new Interval(1, 2)); arr.add(new Interval(3,6));
		 * System.out.println(insert(arr, new Interval(10, 8)));
		 */

		arr.add(new Interval(3,5));
		arr.add(new Interval(8,10));
		System.out.println(insert(arr, new Interval(10,3)));

		/*
		 * arr.add(new Interval(6037774, 6198243)); arr.add(new Interval(6726550,
		 * 7004541)); arr.add(new Interval(8842554, 10866536)); arr.add(new
		 * Interval(11027721, 11341296)); arr.add(new Interval(11972532, 14746848));
		 * arr.add(new Interval(16374805, 16706396)); arr.add(new Interval(17557262,
		 * 20518214)); arr.add(new Interval(22139780, 22379559)); arr.add(new
		 * Interval(27212352, 28404611)); arr.add(new Interval(28921768, 29621583));
		 * arr.add(new Interval(29823256, 32060921)); arr.add(new Interval(33950165,
		 * 36418956)); arr.add(new Interval(37225039, 37785557)); arr.add(new
		 * Interval(40087908, 41184444)); arr.add(new Interval(41922814, 45297414));
		 * arr.add(new Interval(48142402, 48244133)); arr.add(new Interval(48622983,
		 * 50443163)); arr.add(new Interval(50898369, 55612831)); arr.add(new
		 * Interval(57030757, 58120901)); arr.add(new Interval(59772759, 59943999));
		 * arr.add(new Interval(61141939, 64859907)); arr.add(new Interval(65277782,
		 * 65296274)); arr.add(new Interval(67497842, 68386607)); arr.add(new
		 * Interval(70414085, 73339545)); arr.add(new Interval(73896106, 75605861));
		 * arr.add(new Interval(79672668, 84539434)); arr.add(new Interval(84821550,
		 * 86558001)); arr.add(new Interval(91116470, 92198054)); arr.add(new
		 * Interval(96147808, 98979097));
		 * 
		 * System.out.println(insert(arr, new Interval(36210193, 61984219)));
		 */

		/*
		 * arr.add(new Interval(1, 2)); arr.add(new Interval(3, 5)); arr.add(new
		 * Interval(6, 7)); arr.add(new Interval(8, 10)); arr.add(new Interval(12, 16));
		 * System.out.println(insert(arr, new Interval(4, 9)));
		 */

	}

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		if(newInterval.start>newInterval.end)
			newInterval = new Interval(newInterval.end,newInterval.start);
		ArrayList<Interval> result = new ArrayList<>();
		if (intervals.isEmpty()) {
			result.add(newInterval);
			return result;
		}
		int startMin = Integer.MAX_VALUE, endMax = Integer.MIN_VALUE;
		boolean flag = true;
		for (int i = 0; i < intervals.size(); i++) {
			if ((newInterval.start <= intervals.get(i).end && intervals.get(i).start <= newInterval.start)
					|| (newInterval.end >= intervals.get(i).start && intervals.get(i).end >= newInterval.end)
					|| (newInterval.start <= intervals.get(i).start && newInterval.end >= intervals.get(i).end) ) {
				if (i < startMin)
					startMin = i;
				if (i > endMax)
					endMax = i;
				flag = false;
			}
		}

		 
		if (flag) {
			int t=intervals.size();
			for (int i = 0; i < intervals.size(); i++) {
				if(intervals.get(i).start<newInterval.start) {
					result.add(intervals.get(i));
				}else {
					t=i;
					break;
				}
			}
			result.add(newInterval);
			result.addAll(intervals.subList(t, intervals.size()));
			return result;
		}
		System.out.println(startMin + " " + endMax);
		for (int i = 0; i < startMin; i++)
			result.add(new Interval(intervals.get(i).start, intervals.get(i).end));
		//System.out.println(result.size());
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		List<Integer> minList = new ArrayList<>();
		List<Integer> maxList = new ArrayList<>();
		for (int i = startMin; i <= endMax; i++) {
			minList.add(intervals.get(i).start);
			maxList.add(intervals.get(i).end);
		}
		minList.add(newInterval.start);
		maxList.add(newInterval.end);
		min = minList.stream().reduce(Integer::min).get();
		max = maxList.stream().reduce(Integer::max).get();
		result.add(new Interval(min, max));
		// System.out.println(result.size());
		for (int i = endMax + 1; i < intervals.size(); i++)
			result.add(new Interval(intervals.get(i).start, intervals.get(i).end));
		// System.out.println(result.size());
		return result;
	}
}
