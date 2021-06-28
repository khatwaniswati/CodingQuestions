package com.techgig;

class ATM {
	public static void main(String[] args) {
		int amount = Integer.MAX_VALUE;
		int[] rupees = {  50,20,10 };
		int[] count = { 0, 0, 0 };

		for (int i = 0; i < rupees.length; i++) {
			if (rupees[i] < amount || rupees[i] == amount) {
				count[i] = amount / rupees[i];
				amount = amount % rupees[i];
			}
		}
		
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				System.out.print(count[i]+"*"+rupees[i] + " "  );
			}
		}
	}
}