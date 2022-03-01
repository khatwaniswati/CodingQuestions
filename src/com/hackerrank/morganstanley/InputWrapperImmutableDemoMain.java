package com.hackerrank.morganstanley;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class InputWrapperImmutableDemoMain {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		InputWrapperImmutableDate in = new InputWrapperImmutableDate(calendar.getTime(), "Pune", 20,
				40);
		System.out.println(in.getDate());
		
		System.out.println("Current Date = " + calendar.getTime());
		// Add 8 months to current date
		calendar.add(Calendar.MONTH, 8);
		System.out.println("Updated Date = " + calendar.getTime());
		
		System.out.println(in.getDate());

		/*
		 * List<Integer> lst = new ArrayList(Arrays.asList(1,2,3,4,5,6));
		 * //lst.stream().filter(i->i%3==0).collect(Collectors.toList()); for (Integer
		 * integer : lst) { lst.remove(integer); }
		 */
	}

	private static List<InputWrapperImmutableDate> maxTempForEachCity() {
		List<InputWrapperImmutableDate> input = new ArrayList<>();

		// int minBound,maxBound;

		Map<String, Integer> map = new HashMap<>();
		for (InputWrapperImmutableDate inputWrapper : input) {

			if (map.containsKey(inputWrapper.getCity())) {
				Integer maxTemp = map.get(inputWrapper.getCity());
				if (maxTemp < inputWrapper.getMax()) {
					map.put(inputWrapper.getCity(), inputWrapper.getMax());
				}
			} else {
				map.put(inputWrapper.getCity(), inputWrapper.getMax());
			}
		}

		Comparator<Entry<String, Integer>> com = (e1, e2) -> e2.getValue() - e1.getValue();
		map.entrySet().stream().sorted(com);
		map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry<String, Integer>::getKey, Map.Entry<String, Integer>::getValue));
		return null;

	}

	private static List<InputWrapperImmutableDate> maxTempForEachCity(String city, int minBound, int maxBound,
			String type) {
		List<InputWrapperImmutableDate> input = new ArrayList<>();

		Map<Date, Integer> map = new HashMap<>();
		for (InputWrapperImmutableDate inputWrapper : input) {
			if (inputWrapper.getCity().equals(city)) {
				if (type.equals("MIN")) {
					if (inputWrapper.getMin() > minBound && inputWrapper.getMin() < maxBound) {
						// map.put(inputWrapper.getDate(), inputWrapper.getMin());
					}
				}
			}
		}

		return null;

	}
}
