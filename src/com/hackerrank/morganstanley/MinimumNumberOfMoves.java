package com.hackerrank.morganstanley;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ResultMinimumNumberOfMoves {

	/*
	 * Complete the 'toolchanger' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. STRING_ARRAY tools 2. INTEGER startIndex 3. STRING target
	 */

	public static int toolchanger(List<String> tools, int startIndex, String target) {
		int endIndex = tools.indexOf(target);
		int frequency = Collections.frequency(tools, target);

		int diffResult1 = Math.abs(endIndex - startIndex);
		int temp1 = tools.size() - (endIndex > startIndex ? endIndex : startIndex);
		int diff1 = temp1 + (endIndex > startIndex ? startIndex : endIndex);

		if (frequency == 1) {
			if (diff1 < diffResult1)
				return diff1;
			else
				return diffResult1;
		} else {
			int endIndex2 = tools.lastIndexOf(target);
			int diffResult2 = Math.abs(endIndex2 - startIndex);
			int temp2 = tools.size() - (endIndex2 > startIndex ? endIndex2 : startIndex);
			int diff2 = temp2 + (endIndex2 > startIndex ? startIndex : endIndex2);
			int resultMin2 = 0,resultMin1 = 0;
			if (diff2 < diffResult2)
				resultMin2= diff2;
			else
				resultMin2= diffResult2;
			
			
			if (diff1 < diffResult1)
				resultMin1= diff1;
			else
				resultMin1= diffResult1;
			
			if(resultMin2<resultMin1)
				return resultMin2;
			else
				return resultMin1;
		}
	}

}

public class MinimumNumberOfMoves {
	public static void main(String[] args) {
		/*
		 * int result = ResultMinimumNumberOfMoves
		 * .toolchanger(Arrays.asList("ballendmill", "facemill", "keywaycutter",
		 * "slotdrill","5"), 4, "ballendmill");
		 */
		int result = ResultMinimumNumberOfMoves
				.toolchanger(Arrays.asList("facemill", "slotdrill", "ballendmill", "ballendmill"), 0, "ballendmill");
		System.out.println(result);
	}
}