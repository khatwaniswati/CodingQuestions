package com.hackerrank.morganstanley;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class ProfitTargetsResult {

	/*
	 * Complete the 'stockPairs' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY stocksProfit 2. LONG_INTEGER target
	 */

	public static int stockPairs(List<Integer> stocksProfit, long target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> collect = stocksProfit.stream().filter(i -> i < target).sorted().collect(Collectors.toList());
		LinkedList<Integer> copyList = new LinkedList<>(collect);
		System.out.println(copyList);
		while(!copyList.isEmpty()) {
			int current=copyList.poll();
			System.out.println("cu;"+current+" "+copyList);
			if (copyList.contains((int)target - current)) {
				System.out.println("Yess");
				List<Integer> l1 = Arrays.asList(current, (int) target - current);
				System.out.println(l1);
				if (!result.contains(l1))
					result.add(l1);
				copyList.remove(new Integer((int)target - current));
				System.out.println("After:"+copyList);
			}
		}
		System.out.println(result);
		return result.size();
	}

}

public class ProfitTargets {
	public static void main(String[] args) throws IOException {
		/*
		 * List<Integer> stocksProfit = Arrays.asList(5, 7, 9, 13, 11, 6, 6, 3, 3); long
		 * target = 12; int result = ProfitTargetsResult.stockPairs(stocksProfit,
		 * target); System.out.println(result);
		 */
		/*
		 * List<Integer> stocksProfit = Arrays.asList(1,3,46,1,3,9); long target = 47;
		 * int result = ProfitTargetsResult.stockPairs(stocksProfit, target);
		 * System.out.println(result);
		 */
		/*
		 * List<Integer> stocksProfit = Arrays.asList(6,6,3,9,3,5,1); long target = 12;
		 * int result = ProfitTargetsResult.stockPairs(stocksProfit, target);
		 * System.out.println(result);
		 */
		/*
		 * List<Integer> stocksProfit = Arrays.asList(1, 3, 3, 5, 6, 9); long target =
		 * 12; int result = ProfitTargetsResult.stockPairs(stocksProfit, target);
		 * System.out.println(result);
		 */
		/*List<Integer> stocksProfit = Arrays.asList(4, 6, 9, 13, 16, 17, 23, 26, 29, 33, 34, 47, 47, 60, 61, 65, 68, 71, 77, 78, 81, 85, 88, 90);
		long target = 94;
		int result = ProfitTargetsResult.stockPairs(stocksProfit, target);
		System.out.println(result);*/
		
		List<Integer> stocksProfit = Arrays.asList(6,6,3,9,3,5,1);
		long target = 12;
		int result = ProfitTargetsResult.stockPairs(stocksProfit, target);
		System.out.println(result);
		
		String s1="abc";
		String s2=s1;
		s1+="d";
		System.out.println(s1+" "+s2+" "+(s1==s2));
	}
}
