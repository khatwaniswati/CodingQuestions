package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayBug {
	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(1,2,3,4,5,6);
		ArrayList<Integer> rotateArray = rotateArray(lst, 1);
		System.out.println(rotateArray);
	}
	public static ArrayList<Integer> rotateArray(List<Integer> lst, int B) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < lst.size(); i++) {
			//if(i + B <lst.size())
				ret.add(lst.get((i + B)%lst.size()));
		}
		return ret;
	}
}