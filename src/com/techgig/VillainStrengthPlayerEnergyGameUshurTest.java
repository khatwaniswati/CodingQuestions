package com.techgig;

/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VillainStrengthPlayerEnergyGameUshurTest {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		List<List<Integer>> villainsLst = new ArrayList<>();
		List<List<Integer>> playersLst = new ArrayList<>();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			List<Integer> villains = new ArrayList<>();
			List<Integer> players = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				villains.add(sc.nextInt());
			}
			for (int j = 0; j < n; j++) {
				players.add(sc.nextInt());
			}
			Collections.sort(villains);
			Collections.sort(players);
			villainsLst.add(villains);
			playersLst.add(players);
		}
		sc.close();

		for (int k = 0; k < villainsLst.size(); k++) {
			boolean win = true;
			List<Integer> villains = villainsLst.get(k);
			List<Integer> players = playersLst.get(k);
			for (int i = 0; i < villains.size(); i++) {
				if (villains.get(i) > players.get(i)) {
					win = false;
					break;
				}
			}
			if (win)
				System.out.println("WIN");
			else
				System.out.println("LOSE");
		}

	}
}
/**
Input 
2
6
500 50 20 10 400 100
90 60 20 30 490 70
5
50 20 10 30 40
60 40 80 50 70
Output
LOSE
WIN

Input
1
6
512 343 90 112 243 478
150 400 500 789 452 234
Output 
WIN

*/