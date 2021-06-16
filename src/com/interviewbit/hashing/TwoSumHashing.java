package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSumHashing {
	public static void main(String[] args) {
		System.out.println(twoSum(Arrays.asList(-7, -6, 7, 10, -1, -9, -8, 7, -5, -4, -4, 1, 6, 5, 7, 1, 3, -2, 9, -8, -6, -9, -4, -5), -2));
		// 2, 7, 11, 15 B=9-->[1,2]
		// 15, 7, 6, 3, 11, 15, 2, 10, 7, 2 B=9-->[3, 4]
		// -10, -10, -10 B=-5-->[]
		// 1,1,1 B=2-->[1,2]
		//0, 8, -3, -1, 7, 9, -1, 8, -2, 2, -8, -6, -7, -4, -6, -1, -6, 6, 8, -10, -6, 4, -8, 7, 6, -4, -4, -10, -6, 5, -8, -1, 10, 6, 6, -3, -3, -7, -8, -7, 4, -7, 1, -10, 5 B=2-->[1, 10]
		//-7, -6, 7, 10, -1, -9, -8, 7, -5, -4, -4, 1, 6, 5, 7, 1, 3, -2, 9, -8, -6, -9, -4, -5 B=-2
	}

	public static ArrayList<Integer> twoSum(final List<Integer> A, int B) {
		List<List<Integer>> resultList = new ArrayList<>();
		Map<Integer, List<Integer>> map = IntStream.range(0, A.size()).boxed()
				.collect(Collectors.groupingBy(A::get, Collectors.toList()));

		System.out.println(map);

		for (int i = 0; i < A.size() - 1; i++) {
			if (map.containsKey(B - A.get(i))) {
				List<Integer> temp = new ArrayList<>();
				List<Integer> list = map.get(B - A.get(i));
				
				if(list.get(0)==i && list.size()>1)
					temp.add(list.get(1)+1);
				else if(list.get(0)!=i)
					temp.add(list.get(0)+1);
				else
					continue;
				temp.add(i + 1);
				Collections.sort(temp);
				if (!resultList.contains(temp))
					resultList.add(temp);
			}
		}
		System.out.println(resultList);
		if (!resultList.isEmpty()) {
			Comparator<List<Integer>> com = (o1, o2) -> {
				int r1 = o1.get(1).compareTo(o2.get(1));
				int r2 = o1.get(0).compareTo(o2.get(0));
				return r1 == 0 ? r2 : r1;
			};
			Collections.sort(resultList, com);
			return (ArrayList<Integer>) resultList.get(0);
		} else {
			return new ArrayList<>();
		}
	}
}
