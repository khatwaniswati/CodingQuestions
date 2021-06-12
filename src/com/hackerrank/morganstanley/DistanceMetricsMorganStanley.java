package com.hackerrank.morganstanley;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ResultDistanceMetrics {

	public static List<Long> getDistanceMetrics(List<Integer> arr) {
		List<Long> result = new ArrayList<>();
		Map<Integer, List<Integer>> map = IntStream.range(0, arr.size()).boxed().collect(Collectors.groupingBy(arr::get, Collectors.toList()));
		for (int i = 0; i < arr.size(); i++) {
			result.add(0l);
		}
		for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> valueLst = entry.getValue();
			for (int i = 0; i < valueLst.size(); i++) {
				long diff = 0l;
				for (int j = 0; j < valueLst.size(); j++) {
					if(i==j)
						continue;
					diff += abs(valueLst.get(i) - valueLst.get(j));
				}
				result.set(valueLst.get(i), diff);
			}
		}
		return result;
	}

	private static long abs(int i) {
		return Math.abs((long) i);
	}
}

public class DistanceMetricsMorganStanley {
	public static void main(String[] args) throws IOException {
		List<Integer> arr = Arrays.asList(1, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1, 1, 1, 1, 1, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1, 1, 1, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1000000000, 1, 1, 1, 1000000000, 1, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1, 1, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1, 1, 1, 1, 1000000000, 1, 1, 1, 1000000000, 1, 1, 1, 1, 1000000000, 1, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1000000000, 1, 1, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1, 1, 1, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1000000000, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1, 1000000000, 1, 1, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1, 1, 1, 1000000000, 1, 1000000000, 1, 1, 1000000000, 1000000000, 1, 1, 1, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1, 1000000000, 1, 1, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1, 1, 1, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1000000000, 1, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1, 1, 1, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1, 1, 1000000000, 1, 1, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1, 1, 1, 1000000000, 1000000000, 1000000000, 1, 1, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1, 1, 1, 1000000000, 1000000000, 1, 1, 1, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1, 1000000000, 1, 1, 1, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1, 1, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1, 1000000000, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1, 1, 1, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1, 1, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1, 1, 1, 1000000000, 1, 1, 1, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1, 1, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1, 1, 1000000000, 1, 1, 1, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1000000000, 1, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1, 1, 1, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1, 1, 1000000000, 1, 1, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1, 1, 1, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1, 1, 1, 1, 1, 1, 1, 1000000000, 1000000000, 1, 1, 1, 1000000000, 1, 1000000000, 1, 1, 1000000000, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1, 1000000000, 1, 1, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1, 1000000000, 1, 1, 1, 1000000000, 1, 1, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1, 1, 1, 1000000000, 1, 1, 1000000000, 1, 1, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1, 1, 1, 1, 1, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1, 1000000000, 1000000000, 1, 1, 1, 1000000000, 1, 1, 1, 1, 1, 1, 1000000000, 1, 1000000000, 1, 1, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1, 1000000000, 1, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1, 1, 1, 1000000000, 1, 1, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1, 1, 1, 1, 1, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1000000000, 1, 1, 1, 1, 1000000000, 1000000000, 1, 1, 1, 1, 1000000000, 1, 1000000000, 1, 1, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1, 1, 1, 1, 1, 1000000000, 1, 1000000000, 1000000000, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1, 1, 1, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1, 1000000000, 1000000000, 1000000000, 1, 1, 1000000000, 1, 1, 1, 1000000000, 1000000000, 1, 1000000000, 1, 1, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1, 1000000000, 1000000000, 1);
		// O/p [5, 3, 3, 4, 3, 0] // in 1, 2, 1, 1, 2, 3
		// 1,2,2,1,5,1-->[8, 1, 1, 5, 0, 7]
		// 99,99,99,200,200,200-->[3, 2, 3, 3, 2, 3]
		//List<Integer> arr = Arrays.asList(99,99,99,200,200,200);
		List<Long> result = ResultDistanceMetrics.getDistanceMetrics(arr);
		System.out.println(result);
	}
}