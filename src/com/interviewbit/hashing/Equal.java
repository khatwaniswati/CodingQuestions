package com.interviewbit.hashing;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Equal {
	public static void main(String[] args) {

		System.out.println(equal(new ArrayList<>(Arrays.asList(3, 4, 7, 1, 2, 9, 8))));

		System.out.println(equal(new ArrayList<>(Arrays.asList(1,1,1,1,1))));
	}

	public static ArrayList<Integer> equal(ArrayList<Integer> A) {
		ArrayList<Integer> lst = new ArrayList<>();
		HashMap<Integer, SimpleEntry<Integer, Integer>> map = new HashMap<>();
		for (int i = 0; i < A.size(); i++) {
			for (int j = i + 1; j < A.size(); j++) {
				System.out.println(i + " " + j);
				if (map.containsKey(A.get(i) + A.get(j))
						&& (map.get(A.get(i) + A.get(j)).getKey() != i && map.get(A.get(i) + A.get(j)).getKey() != j)
						&& (map.get(A.get(i) + A.get(j)).getValue() != i
								&& map.get(A.get(i) + A.get(j)).getValue() != j)) {

					System.out.println(i + " " + j + "Yo" + map.get(A.get(i) + A.get(j)).getKey() + " "
							+ map.get(A.get(i) + A.get(j)).getValue());

					ArrayList<Integer> current = new ArrayList<>();
					current.add(map.get(A.get(i) + A.get(j)).getKey());
					current.add(map.get(A.get(i) + A.get(j)).getValue());
					current.add(i);
					current.add(j);
					//Collections.sort(current);
					if (lst.size() == 4) {
						if (current.get(0) < lst.get(0) || (current.get(0) == lst.get(0) && current.get(1) < lst.get(1))
								|| (current.get(0) == lst.get(0) && current.get(1) == lst.get(1)
										&& current.get(2) < lst.get(2))
								|| (current.get(0) == lst.get(0) && current.get(1) == lst.get(1)
										&& current.get(2) == lst.get(2) && current.get(3) < lst.get(3))) {
							lst = current;
						}
					} else {
						lst = current;
					}
				} else if (map.containsKey(A.get(i) + A.get(j))) {
					System.out.println("Ohhh");
				} else {
					map.put(A.get(i) + A.get(j), new SimpleEntry<Integer, Integer>(i, j));
				}
			}
		}
		return lst;
	}
}
