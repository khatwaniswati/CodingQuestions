package com.techgig;

class disp {
	int m;

	void show() {
		if (m > 1)
			System.out.print(m + " ");
	}
}

class packages {
	public static void main(String args[]) {
		disp[] array = new disp[3];
		for (int a = 0; a < 3; a++)
			array[a] = new disp();
		array[0].m = 0;
		array[1].m = 1;
		array[2].m = 2;
		for (int a = 0; a < 3; ++a)
			array[a].show();
	}
}