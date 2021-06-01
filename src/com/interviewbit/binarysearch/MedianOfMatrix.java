package com.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MedianOfMatrix {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
		ArrayList<Integer> sub = new  ArrayList<>();
		sub.add(5);sub.add(17);sub.add(100);
		lst.add(sub);
		/*
		 * sub = new ArrayList<>(); sub.add(2);sub.add(6);sub.add(9); lst.add(sub); sub
		 * = new ArrayList<>(); sub.add(3);sub.add(6);sub.add(9); lst.add(sub);
		 */
		System.out.println(lst);
		System.out.println(findMedian(lst));
	}

	public static int findMedian(ArrayList<ArrayList<Integer>> A) {
		List<Integer> collect = A.stream().flatMap(l->l.stream()).sorted().collect(Collectors.toList());
		//System.out.println(collect);
		return collect.get(collect.size()/2);
	}

}
