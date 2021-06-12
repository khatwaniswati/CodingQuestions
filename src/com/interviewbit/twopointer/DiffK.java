package com.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;

public class DiffK {
	public static void main(String[] args) {
		System.out.println(diffPossible(new ArrayList<>(Arrays.asList(1,3,5)), 4));
		// 1, 2, 2, 3, 4  B=0 O/p=1
		//1,3,5 B=4 o/p=1
		//1,3,5 B=3 o/p=0
	}

	public static int diffPossible(ArrayList<Integer> A, int B) {
		for (int i = 0; i < A.size(); i++) {
			int j=A.size()-1;
			while(j!=i) {
				//System.out.println(i+" "+j);
				int diff = A.get(j)-A.get(i);
				if(diff==B)
					return 1;
				else if(diff>B)
					j--;
				else break;
			}
		}
		return 0;
	}
}
