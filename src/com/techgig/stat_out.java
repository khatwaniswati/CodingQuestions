package com.techgig;

class stat_out {
	static int a;
	static int b;

	void add(int m, int n) {
		a = m + n;
		b = a + n;
	}
}

class stat_use {
	public static void main(String args[]) {
		stat_out obj1 = new stat_out();
		stat_out obj2 = new stat_out();
		int m = 2;
		obj1.add(m, m + 1);
		obj2.add(5, m);
		System.out.println(obj1.a + " " + obj2.b);
	}
}