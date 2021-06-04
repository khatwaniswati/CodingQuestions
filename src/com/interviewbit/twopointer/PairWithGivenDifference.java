package com.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class PairWithGivenDifference {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> lst = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			lst.add(sc.nextInt());
		}
		int b = sc.nextInt();
		sc.close();
		System.out.println(solve(lst, b));
	}

	public static int solve(ArrayList<Integer> A, int B) {
		
		/*
		 * for (int i = 0; i < A.size(); i++) { for (int k = 0; k < A.size(); k++) { if
		 * (i!=k && (A.get(i) - A.get(k) == B || A.get(k) - A.get(i) == B)) return 1; }
		 * } return 0;
		 */
		
		Hashtable<Integer, Integer> ht = new Hashtable<>();
		for (int i = 0; i < A.size(); i++) {
				ht.put(A.get(i), i);
		}
		for (int i = 0; i < A.size(); i++) {
			if(ht.containsKey(B+A.get(i)) && ht.get(B+A.get(i))!=i) {
				return 1;
			}
		}
		return 0;
	}
}
/**
6
5
10
3
2
50
80
78
Ans=1
2
-10
20
30
Ans=1;
4
20
500
1000
200
0
Ans=0
42
-533
-666
-500
169
724
478
358
-38
-536
705
-855
281
-173
961
-509
-5
942
-173
436
-609
-396
902
-847
-708
-618
421
-284
718
895
447
726
-229
538
869
912
667
-701
35
894
-297
811
322
369
Ans=1
*/