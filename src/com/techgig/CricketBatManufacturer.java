package com.techgig;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/* Read input from STDIN. Print your output to STDOUT*/

public class CricketBatManufacturer {
	static List<Entry<Integer, Integer>> batsAvailable = new LinkedList<>();
	static Map<Entry<Integer, Integer>, List<Entry<Integer, Integer>>> map = new HashMap<>();

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int n = sc.nextInt();
		List<Entry<Integer, Integer>> criketersReq = new ArrayList<>();
		for (int i = 0; i < c; i++) {
			criketersReq.add(new AbstractMap.SimpleEntry<Integer, Integer>(sc.nextInt(), sc.nextInt()));
		}

		for (int i = 0; i < n; i++) {
			batsAvailable.add(new AbstractMap.SimpleEntry<Integer, Integer>(sc.nextInt(), sc.nextInt()));
		}
		sc.close();

		Comparator<Entry<Integer, Integer>> com = new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getKey() - o1.getKey();
			}

		};
		Collections.sort(criketersReq, com);
		Collections.sort(batsAvailable, com);

		List<Entry<Integer, Integer>> removedItems = new ArrayList<>();
		int result = 0;
		for (int i = 0; i < n; i++) {
			List<Entry<Integer, Integer>> eligibleBats = getEligibleBats(criketersReq.get(i), batsAvailable);
			if (eligibleBats.size() == 1) {
				batsAvailable.remove(eligibleBats.get(0));
				removedItems.add(eligibleBats.get(0));
				result++;
			}else if(eligibleBats.size()>1){
				map.put(criketersReq.get(i), eligibleBats);
			}
		}
		//System.out.println(result);
		//System.out.println(map);
		//System.out.println(removedItems);
		for(Entry<Entry<Integer, Integer>, List<Entry<Integer, Integer>>> entry : map.entrySet()) {
			List<Entry<Integer, Integer>> value = entry.getValue();
			value.removeAll(removedItems);
			if(value.size()>=1 && batsAvailable.contains(value.get(0))) {
				batsAvailable.remove(value.get(0));
				result++;
			}
			if(batsAvailable.size()==0)
				break;
		}
		System.out.println(result);
	}

	private static List<Entry<Integer, Integer>> getEligibleBats(Entry<Integer, Integer> req,
			List<Entry<Integer, Integer>> batsAvailable) {
		List<Entry<Integer, Integer>> lst = new ArrayList();
		for (int i = 0; i < batsAvailable.size(); i++) {
			if (batsAvailable.get(i).getKey() >= req.getKey() && req.getValue() <= batsAvailable.get(i).getValue())
				lst.add(batsAvailable.get(i));
		}
		return lst;
	}
}

/**
4 4
5 100
7 80
10 90
6 150
8 100
10 150
9 60
7 80
 */