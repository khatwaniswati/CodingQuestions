package com.hackerrank.morganstanley;

class CardBoard {
	Short story = 5;

	CardBoard go(CardBoard cb) {
		cb = null;
		return cb;
	}

	public static void main(String[] args) {
		CardBoard c1 = new CardBoard();
		CardBoard c2 = new CardBoard();
		CardBoard c3 = c1.go(c2);
		c1 = null;
		System.out.println(c1+""+c2+c3+"");
	}
}