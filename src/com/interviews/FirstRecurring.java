package com.interviews;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import javafx.util.Pair;

public class FirstRecurring {

	public static void main(String[] args) {
		String s = "ABBCA";
		char[] charArray = s.toCharArray();
		Map<Character, Pair<Integer, Integer>> map = new LinkedHashMap<>();
		
		for (int i=0; i< charArray.length; i++) {
			if(map.containsKey(charArray[i])) {
				Pair<Integer, Integer> pair = map.get(charArray[i]);
				map.put(charArray[i], new Pair<>(pair.getKey(), pair.getValue()+1));
				break;
			}else {
				map.put(charArray[i], new Pair<Integer, Integer>(i, 1));
			}
		}
		System.out.println(map);
		Optional<Pair<Integer, Integer>> findFirst = map.values().stream()
				.filter(t->t.getValue()>1)
				.findFirst();
		if (findFirst.isPresent()) {
			Integer key = findFirst.get().getKey();
			System.out.println(charArray[key]);
		} else {
			System.out.println("No Recurring element found");
		}
	}
	
}
