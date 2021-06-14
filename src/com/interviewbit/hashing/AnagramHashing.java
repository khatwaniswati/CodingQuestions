package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramHashing {
	public static void main(String[] args) {
		System.out.println(anagrams(Arrays.asList("cat","dog", "god", "tca")));
		System.out.println(improvedAnagrams(Arrays.asList("cat","dog", "god", "tca")));
	}

	public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		ArrayList<ArrayList<Integer>> resultLst = new ArrayList<>();
		Map<Map<Character, Long>, ArrayList<Integer>> resultMap = new HashMap<>();
		for (int i = 0; i < A.size(); i++) {
			Map<Character, Long> map = strToMap.apply(A.get(i));
			if (resultMap.containsKey(map)) {
				ArrayList<Integer> arrayList = resultMap.get(map);
				arrayList.add(i + 1);
			} else {
				resultMap.put(map, new ArrayList<>(Arrays.asList(i + 1)));
			}
		}
		resultMap.values().stream().forEach(c -> {
			Collections.sort(c);
			resultLst.add(c);
		});
		Collections.sort(resultLst, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				return o1.get(0).compareTo(o2.get(0));
			}
		});
		return resultLst;
	}
	
	public static ArrayList<ArrayList<Integer>> improvedAnagrams(final List<String> A) {
		ArrayList<ArrayList<Integer>> resultLst = new ArrayList<>();
		Map<String, ArrayList<Integer>> resultMap = new HashMap<>();
		for (int i = 0; i < A.size(); i++) {
			String sortedStr = getSortedStr.apply(A.get(i));
			if (resultMap.containsKey(sortedStr)) {
				ArrayList<Integer> arrayList = resultMap.get(sortedStr);
				arrayList.add(i + 1);
			} else {
				resultMap.put(sortedStr, new ArrayList<>(Arrays.asList(i + 1)));
			}
		}
		resultMap.values().stream().forEach(c -> {
			Collections.sort(c);
			resultLst.add(c);
		});
		Collections.sort(resultLst, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				return o1.get(0).compareTo(o2.get(0));
			}
		});
		return resultLst;
	}

	private static Function<String, Map<Character, Long>> strToMap = s -> s.chars().mapToObj(i -> (char) i)
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	
	private static Function<String, String> getSortedStr = s -> s.chars().mapToObj(i -> (char) i).sorted().map(c->c.toString())
			.collect(Collectors.joining());
}
