package com.hackerrank.morganstanley;

import java.util.ArrayList;
import java.util.List;

public class TestABCMain {

	public static void main(String[] args) {
		List<A> lst = new ArrayList<A>();
		lst.add(new B());
		lst.add(new C());
		for (A a : lst) {
			a.x();
			//a.y();
		}
	}
}
