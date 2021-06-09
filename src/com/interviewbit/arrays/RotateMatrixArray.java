package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateMatrixArray {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
		ArrayList<Integer> nested = new ArrayList<>(Arrays.asList(1,2,3));
		lst.add(nested);
		nested = new ArrayList<>(Arrays.asList(4,5,6));
		lst.add(nested);
		nested = new ArrayList<>(Arrays.asList(7,8,9));
		lst.add(nested);
		rotate(lst);
		System.out.println(lst);
	}

	public static void rotate(ArrayList<ArrayList<Integer>> a) {
		ArrayList<ArrayList<Integer>> resultArrayList = new ArrayList<>();
		for (int i = 0; i < a.size(); i++) {
			ArrayList<Integer> arrayList = new ArrayList<>();
			for (int j = a.size()-1; j >= 0; j--) {
				arrayList.add(a.get(j).get(i));
			}
			resultArrayList.add(arrayList);
		}
		test(a,resultArrayList);
	}
	
	public static void test(ArrayList<ArrayList<Integer>> a,ArrayList<ArrayList<Integer>> result) {
		for (int i = 0; i < a.size(); i++) {
			ArrayList<Integer> arrayList = a.get(i);
			for (int j = a.size()-1; j >= 0; j--) {
				arrayList.set(j,result.get(i).get(j));
			}
		}
	}
}
