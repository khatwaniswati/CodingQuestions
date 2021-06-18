package com.interviewbit;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		System.out.println(longestConsecutive(Arrays.asList(97, 86, 67, 19, 107, 9, 8, 49, 23, 46, -4, 22, 72, 4, 57, 111, 20, 52, 99, 2, 113, 81, 7, 5, 21, 0, 47, 54, 76, 117, -2, 102, 34, 12, 103, 69, 36, 51, 105, -3, 33, 91, 37, 11, 48, 106, 109, 45, 58, 77, 104, 60, 75, 90, 3, 62, 16, 119, 85, 63, 87, 43, 74, 13, 95, 94, 56, 28, 55, 66, 92, 79, 27, 42, 70)));
		//100, 4, 200, 1, 3, 2->4
		//1,600,800,3,9,7->0
		//101,100, 4, 102, 1, 3, 2,105,103,104->6
		//-5->1
		//1, 1, 2, 2, 3, 3, 4, 4, 5, 5->5
		//97, 86, 67, 19, 107, 9, 8, 49, 23, 46, -4, 22, 72, 4, 57, 111, 20, 52, 99, 2, 113, 81, 7, 5, 21, 0, 47, 54, 76, 117, -2, 102, 34, 12, 103, 69, 36, 51, 105, -3, 33, 91, 37, 11, 48, 106, 109, 45, 58, 77, 104, 60, 75, 90, 3, 62, 16, 119, 85, 63, 87, 43, 74, 13, 95, 94, 56, 28, 55, 66, 92, 79, 27, 42, 70-->6 
	}

	public static int longestConsecutive(final List<Integer> A) {
		//List<Integer> collect = A.stream().sorted().collect(Collectors.toList());
		if(A.size()==1 && A.get(0)<0)
			return 1;
		TreeSet<Integer> tree = new TreeSet<>();
		for (Integer integer : A) {
			tree.add(integer);
		}
		System.out.println(tree);
		int result=0;
		Iterator<Integer> iterator = tree.iterator();
		while(iterator.hasNext()) {
			int consecutiveCnt=0;
			while(tree.contains(iterator.next()+1)) {
				consecutiveCnt++;
			}
			//System.out.println(" "+consecutiveCnt);
			if(consecutiveCnt>=result)
				result=consecutiveCnt+1;
		}
		return result;
	}

}